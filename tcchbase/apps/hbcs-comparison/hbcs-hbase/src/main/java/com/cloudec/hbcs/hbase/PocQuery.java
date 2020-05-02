package com.cloudec.hbcs.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;

import com.cloudec.hbcs.HbcsException;

public class PocQuery {

  static Logger logger = Logger.getLogger(HbQuery1.class);

  public void scan() {
    //Create the required configuration
    Configuration conf = HBaseConfiguration.create();
    //Instantiate a new client.
    try (Connection connection = ConnectionFactory.createConnection(conf);
        Table table = connection.getTable(TableName.valueOf("post_history_q1"));) {
      Scan scan = new Scan();
      scan.addColumn(Bytes.toBytes("post_history"), Bytes.toBytes("Text"))
          .setStartRow(Bytes.toBytes("1"))
          .setStopRow(Bytes.toBytes("2"));
      ResultScanner scanner = table.getScanner(scan);
      for (Result res : scanner) {
        byte[] text = res.getValue(Bytes.toBytes("post_history"),
            Bytes.toBytes("Text"));
        System.out.println("### Result: " + res);
        System.out.println("### Value: " + Bytes.toString(text));
      }
      scanner.close();
    } catch (IOException ex) {
      throw new HbcsException("erro_when_create_hbase_connection", ex);
    }
  }

  public void get() {
    //Create the required configuration
    Configuration conf = HBaseConfiguration.create();
    //Instantiate a new client.
    try (Connection connection = ConnectionFactory.createConnection(conf);
        Table table = connection.getTable(TableName.valueOf("post_history_q1"));) {
      Get get = new Get(Bytes.toBytes("2"));
      Result result = table.get(get);
      byte[] val = result.getValue(Bytes.toBytes("post_history"), Bytes.toBytes("UserId"));
      System.out.println("### Value: " + Bytes.toString(val));
    } catch (IOException ex) {
      throw new HbcsException("erro_when_create_hbase_connection", ex);
    }
  }

  public static void main(String[] args) {
    new PocQuery().scan();
  }

}
