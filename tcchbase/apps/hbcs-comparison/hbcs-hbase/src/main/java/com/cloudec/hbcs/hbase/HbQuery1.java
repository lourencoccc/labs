package com.cloudec.hbcs.hbase;

import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;

/**
 * Q1 - Selecionar PostHistory por PostId - Simples
 *
 * create 'query:q1_post_history_by_postid', 'post_history'
 */
public class HbQuery1 extends HbQuery {

  static Logger logger = Logger.getLogger(HbQuery1.class);


  public HbQuery1() {
    super("query1", "query");
    tableName = "query:q1_post_history_by_postid";
  }

  public Scan createScan() {
//    SingleColumnValueFilter filter = new SingleColumnValueFilter(
//        Bytes.toBytes("post_history"), Bytes.toBytes("PostId"),
//        CompareFilter.CompareOp.EQUAL, new BinaryComparator(Bytes.toBytes("26")));
//    // all rows that do not have the reference column are dropped from the result.
//    filter.setFilterIfMissing(true);
//    Filter filter1 = new RowFilter(CompareFilter.CompareOp.EQUAL,
//        new BinaryPrefixComparator(Bytes.toBytes("26")));
    //bugfix esta listando maior q 26
    Scan scan = new Scan();
    scan.setStartRow(Bytes.toBytes("26_"));
    scan.setStopRow(Bytes.toBytes("27"));
//    scan.setFilter(filter1);
    return scan;
  }

  @Override
  public void processResult() {
    //nothing to do
  }
}
