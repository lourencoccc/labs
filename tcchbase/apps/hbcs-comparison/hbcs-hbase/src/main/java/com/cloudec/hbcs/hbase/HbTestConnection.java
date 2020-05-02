package com.cloudec.hbcs.hbase;

import com.cloudec.hbcs.HbcsException;
import com.cloudec.hbcs.ICommand;
import java.io.Closeable;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * Created by joao_lourenco on 5/10/17.
 */
public class HbTestConnection implements ICommand, Closeable {

  private void connnect() {
    Configuration conf = HBaseConfiguration.create();
    conf.set("hbase.zookeeper.property.clientPort", "2181");
    conf.set("hbase.zookeeper.quorum", "192.168.1.111");
    try (Connection connection = ConnectionFactory.createConnection(conf);
        Table table = connection.getTable(TableName.valueOf("hbcs:hbcs"))) {
      Scan scan = new Scan();
      scan.setStartRow(Bytes.toBytes("info"));
      ResultScanner resultScanner = table.getScanner(scan);
      if (resultScanner != null) {
        for (Result result : resultScanner) {
          System.out.println(result);
        }
      }
    } catch (IOException e) {
      throw new HbcsException("hbcs_erro_connect_hbase", e);
    }
  }

  @Override
  public void close() {

  }

  @Override
  public void exec(String... args) {
    connnect();
  }
}
