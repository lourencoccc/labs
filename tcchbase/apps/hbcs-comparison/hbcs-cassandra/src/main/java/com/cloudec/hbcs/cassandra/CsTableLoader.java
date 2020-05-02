package com.cloudec.hbcs.cassandra;

import static com.cloudec.hbcs.HbcsTypeDatabase.CASSANDRA;

import com.cloudec.hbcs.HbcsFileUtils;
import com.cloudec.hbcs.HbcsTableValidator;
import com.cloudec.hbcs.HbcsUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.cloudec.hbcs.DatasetReader;
import com.cloudec.hbcs.HbcsCache;
import com.cloudec.hbcs.HbcsConfiguration;
import com.cloudec.hbcs.HbcsConfigurationFactory;
import com.cloudec.hbcs.HbcsConfigurationTable;
import com.cloudec.hbcs.ICommand;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.apache.log4j.Logger;

/**
 * @author SOUZA JR, JOAO
 * @since 2017-03-15
 */
public class CsTableLoader implements ICommand {

  static Logger logger = Logger.getLogger(CsTableLoader.class);

  private CsConfig csConfig;
  private Cluster cluster;
  private Session session;

  private void connect() {
    cluster = Cluster.builder().addContactPoints(this.csConfig.getContacPoints())
        .withPort(this.csConfig.getPort()).build();
    System.out.printf("Connected to cluster: %s%n", cluster.getMetadata().getClusterName());
    session = cluster.connect();
  }

  private String load(final Map<String, String> params) {
    this.csConfig = CsConfig.create(params.get("environment"));
    connect();
    try {
      for (File dataset : HbcsFileUtils.listSubDirs(params.get("datasetPath"))) {
        HbcsConfiguration hbcsConf = HbcsConfigurationFactory.create(
            new File(params.get("configFilePath")));
        hbcsConf.updateDataset(dataset.getName(), dataset.getAbsolutePath());
        load(hbcsConf);
      }
    } catch (Exception ex) {
      throw ex;
    } finally {
      close();
    }
    // TODO return report
    return "";
  }

  private String load(final HbcsConfiguration hbcsConf) {
    for (HbcsConfigurationTable hbcsTableConf : hbcsConf.getTables()) {
      Map<String, HbcsCache> caches = putAggregatesInCache(hbcsTableConf);
      insert(hbcsTableConf, caches);
    }
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

  private void insert(final HbcsConfigurationTable hbcsTableConf,
      final Map<String, HbcsCache> caches) {
    String pathXml = hbcsTableConf.sourcePath();
    DatasetReader reader = new DatasetReader();
    String tableName = hbcsTableConf.tableName(CASSANDRA);
    logger.debug("tableName:" + tableName);
    logger.debug("pathXml:" + pathXml);
    reader.readXmlTable(pathXml, (Map<String, String> mapRow) -> {

      if (!HbcsTableValidator.hasAllRequiredColumns(hbcsTableConf, mapRow)) {
        logger.warn("Missing not empty columns in table " + tableName);
        logger.warn("Skip");
        return;
      }

      Map<String, String> mapRowSelected = new HashMap<>();

      if (!hbcsTableConf.columnSet().isEmpty()) {
        mapRow.keySet().retainAll(hbcsTableConf.columnSet());
      }

      for (String field : mapRow.keySet()) {
        mapRowSelected.put(hbcsTableConf.getCfName() + "_" + field, mapRow.get(field));
      }

      // process aggregates
      if (hbcsTableConf.hasAggregates()) {
        for (HbcsConfigurationTable hbcsAggreConf : hbcsTableConf.getAggregates()) {
          // get from cache
          Map<String, String> map =
              caches.get(hbcsAggreConf.getName()).get(mapRow.get(hbcsAggreConf.getRefKeyField()));
          if (!hbcsAggreConf.columnSet().isEmpty()) {
            map.keySet().retainAll(hbcsAggreConf.columnSet());
          }
          Map<String, String> mapSelected = new HashMap<>();
          for (String field : map.keySet()) {
            mapSelected.put(hbcsAggreConf.getCfName() + "_" + field, map.get(field));
          }
          if (!HbcsTableValidator.hasAllRequiredColumns(hbcsAggreConf, map)) {
            logger.warn("Missing not empty columns in table " + hbcsAggreConf.getName());
            logger.warn("Skip");
            return;
          }
          mapRowSelected.putAll(mapSelected);
        }
      }

      mapRowSelected.put("site", hbcsTableConf.getDatasetName());

      StringBuilder insert = new StringBuilder("INSERT INTO ");
      insert.append(tableName);
      insert.append(" ");
      StringBuilder columns = new StringBuilder("(");
      StringBuilder values = new StringBuilder("(");
      for (String field : mapRowSelected.keySet()) {
        columns.append(field);
        columns.append(",");
        if (hbcsTableConf.isTextOrTimestamp(field)) {
          values.append("'" + mapRowSelected.get(field).replace("'", "") + "'");
        } else {
          values.append(mapRowSelected.get(field));
        }
        values.append(",");
      }
      columns.append(")");
      values.append(")");
      insert.append(columns);
      insert.append(" VALUES ");
      insert.append(values);
      String insertCmd = insert.toString().replace(",)", ")");
      logger.debug(insertCmd);
      session.execute(insertCmd);
    });
  }

  private void close() {
    session.close();
    cluster.close();
  }

  public void exec(String... args) {
    load(HbcsUtils.processTableLoaderCommandArgs(args));
  }
}
