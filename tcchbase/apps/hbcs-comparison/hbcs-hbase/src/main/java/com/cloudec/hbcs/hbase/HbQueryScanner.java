package com.cloudec.hbcs.hbase;

import com.cloudec.hbcs.HbcsEnvironment;
import com.cloudec.hbcs.HbcsException;
import com.cloudec.hbcs.HbcsReport;
import java.io.Closeable;
import java.io.IOException;
import java.time.Instant;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;

/**
 * Created by joao_lourenco on 5/12/17.
 */
public class HbQueryScanner implements Closeable {

  final Connection connection;
  final HbcsEnvironment environment;

  public HbQueryScanner(HbcsEnvironment environment) {
    super();
    this.environment = environment;
    Configuration conf = HbConfigFactory.createHBaseConf(environment);
    try {
      this.connection = ConnectionFactory.createConnection(conf);
    } catch (IOException e) {
      throw new HbcsException("hbcs_erro_connect_hbase", e);
    }
  }

  public ResultScanner scan(final String tableName, final Scan scan, final HbcsReport report) {
    ResultScanner resultScanner = null;
    Table table = connectTable(tableName);
    Instant start = Instant.now();
    try {
      resultScanner = table.getScanner(scan);
    } catch (IOException e) {
      throw new HbcsException("hbcs_erro_execute_query_hbase", e);
    }
    Instant end = Instant.now();
    close(table);
    report.configureDuration(start, end);
    return resultScanner;
  }

  private Table connectTable(final String tableName) {
    // Create the required configuration
    Table table = null;
    try {
      table = connection.getTable(TableName.valueOf(tableName));
    } catch (IOException e) {
      throw new HbcsException("hbcs_erro_connect_hbase", e);
    }
    return table;
  }

  private void close(final Table table) {
    try {
      table.close();
    } catch (IOException e) {
      throw new HbcsException("hbcs_erro_close_connections_hbase", e);
    }
  }

  public void close() {
    try {
      connection.close();
    } catch (IOException e) {
      throw new HbcsException("hbcs_erro_close_connections_hbase", e);
    }
  }

}
