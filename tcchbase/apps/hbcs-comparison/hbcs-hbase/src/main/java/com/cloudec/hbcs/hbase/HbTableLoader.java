package com.cloudec.hbcs.hbase;

import static com.cloudec.hbcs.HbcsTypeDatabase.HBASE;

import com.cloudec.hbcs.DatasetReader;
import com.cloudec.hbcs.HbcsCache;
import com.cloudec.hbcs.HbcsConfiguration;
import com.cloudec.hbcs.HbcsConfigurationFactory;
import com.cloudec.hbcs.HbcsConfigurationTable;
import com.cloudec.hbcs.HbcsException;
import com.cloudec.hbcs.HbcsFileUtils;
import com.cloudec.hbcs.HbcsTableValidator;
import com.cloudec.hbcs.HbcsUtils;
import com.cloudec.hbcs.ICommand;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;


/**
 * @author SOUZA JR, JOAO
 * @since 2017-02-27
 */
public class HbTableLoader implements ICommand {

  static Logger logger = Logger.getLogger(HbTableLoader.class);

  private String load(final Map<String, String> params) {
    // Create the required configuration
    Configuration conf = HbConfigFactory.createHBaseConf(params.get("environment"));
    try (Connection connection = ConnectionFactory.createConnection(conf)) {
      for (File dataset : HbcsFileUtils.listSubDirs(params.get("datasetPath"))) {
        HbcsConfiguration hbcsConf = HbcsConfigurationFactory.create(
            new File(params.get("configFilePath")));
        hbcsConf.updateDataset(dataset.getName(), dataset.getAbsolutePath());
        for (HbcsConfigurationTable hbcsTableConf : hbcsConf.getTables()) {
          Map<String, HbcsCache> caches = putAggregatesInCache(hbcsTableConf);
          putHbaseTable(connection, hbcsTableConf, caches);
        }
      }
    } catch (IOException ex) {
      throw new HbcsException("erro_when_create_hbase_connection", ex);
    }
    // TODO return report
    return "";
  }

  private Map<String, HbcsCache> putAggregatesInCache(final HbcsConfigurationTable hbcsTableConf) {
    Map<String, HbcsCache> caches = new HashMap<>();
    if (hbcsTableConf.hasAggregates()) {
      for (HbcsConfigurationTable hbcsAggreConf : hbcsTableConf.getAggregates()) {
        // push on cache
        caches.put(hbcsAggreConf.getName(), new HbcsCache(hbcsAggreConf.getName()));
        DatasetReader reader = new DatasetReader();
        reader.readXmlTable(hbcsAggreConf.sourcePath(), (Map<String, String> mapRow) -> {
          if (!hbcsAggreConf.getColumns().isEmpty()) {
            mapRow.keySet().retainAll(hbcsAggreConf.columnSet());
          }
          caches.get(hbcsAggreConf.getName()).put(mapRow.get(hbcsAggreConf.getKeyField()), mapRow);
        });
      }
    }
    return caches;
  }

  private void putHbaseTable(final Connection connection,
      final HbcsConfigurationTable hbcsTableConf, final Map<String, HbcsCache> caches)
      throws IOException {

    String pathXml = hbcsTableConf.sourcePath();
    String name = hbcsTableConf.tableName(HBASE);
    String cfName = hbcsTableConf.getCfName();
    String keyField = hbcsTableConf.getKeyField();

    try (Table table = connection.getTable(TableName.valueOf(name));) {
      DatasetReader reader = new DatasetReader();
      reader.readXmlTable(pathXml, (Map<String, String> mapRow) -> {
        // Create put with specific row.
        String rowKey = mapRow.get(keyField);

        if (!HbcsTableValidator.hasAllRequiredColumns(hbcsTableConf, mapRow)) {
          logger.warn("Missing not empty columns in table " + name);
          logger.warn("Skip");
          return;
        }

        if (!hbcsTableConf.getRowKeys().isEmpty()) {
          rowKey = "";
          for (String key : hbcsTableConf.getRowKeys()) {
            rowKey += "_" + mapRow.get(key);
          }
        }

        if (!hbcsTableConf.columnSet().isEmpty()) {
          mapRow.keySet().retainAll(hbcsTableConf.columnSet());
        }

        Map<String, String> map = Collections.emptyMap();
        String cfNameAggre = null;
        if (hbcsTableConf.hasAggregates()) {
          for (HbcsConfigurationTable hbcsAggreConf : hbcsTableConf.getAggregates()) {
            cfNameAggre = hbcsAggreConf.getCfName();
            // get from cache
            map = caches.get(hbcsAggreConf.getName())
                .get(mapRow.get(hbcsAggreConf.getRefKeyField()));

            if (!hbcsAggreConf.columnSet().isEmpty()) {
              map.keySet().retainAll(hbcsAggreConf.columnSet());
            }

            if (!HbcsTableValidator.hasAllRequiredColumns(hbcsAggreConf, map)) {
              logger.warn("Missing not empty columns in table " + name);
              logger.warn("Skip");
              return;
            }

            if (!hbcsAggreConf.getRowKeys().isEmpty()) {
              for (String key : hbcsAggreConf.getRowKeys()) {
                rowKey = "_" + map.get(key) + rowKey;
              }
            }
            map.put("site", hbcsTableConf.getDatasetName());
          }
        }

        rowKey = rowKey.substring(1, rowKey.length());
        rowKey = rowKey + "_" + hbcsTableConf.getDatasetName();
        mapRow.put("site", hbcsTableConf.getDatasetName());
        Put put = new Put(Bytes.toBytes(rowKey));

        // Add columns
        for (String field : map.keySet()) {
          // Add columns
          put.addColumn(Bytes.toBytes(cfNameAggre), Bytes.toBytes(field),
              Bytes.toBytes(map.get(field)));
        }

        for (String field : mapRow.keySet()) {
          // Add columns
          put.addColumn(Bytes.toBytes(cfName), Bytes.toBytes(field),
              Bytes.toBytes(mapRow.get(field)));
        }
        // Store row with column into the HBase table.
        try {
          table.put(put);
        } catch (IOException ex) {
          throw new HbcsException("erro_when_put_data", ex);
        }

      });
    }
  }

  public void exec(String... args) {
    load(HbcsUtils.processTableLoaderCommandArgs(args));
  }

}
