package com.cloudec.hbcs.hbase;

import static org.apache.hadoop.hbase.util.Bytes.toBytes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;

/**
 * Q3 - Selecionar todos as postagens (Posts) fechadas (PostHistoryTypeId igual á 10)
 *
 * create 'query:q3_posts_by_posthistorytypeid', 'post_history'
 * alter 'query:q3_posts_by_posthistorytypeid', 'posts'
 */
public class HbQuery3 extends HbQuery {

  static Logger logger = Logger.getLogger(HbQuery3.class);

  public HbQuery3() {
    super("query3", "query");
    tableName = "query:q3_posts_by_posthistorytypeid";
  }

  @Override
  public Scan createScan() {
    Scan scan = new Scan();
    scan.setStartRow(Bytes.toBytes("10_"));
    scan.setStopRow(Bytes.toBytes("11"));
    return scan;
  }


  @Override
  public void processResult() {
    //nothing to do
  }

}
