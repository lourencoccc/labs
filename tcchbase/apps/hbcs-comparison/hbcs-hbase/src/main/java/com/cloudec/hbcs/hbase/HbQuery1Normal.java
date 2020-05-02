package com.cloudec.hbcs.hbase;

import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;

public class  HbQuery1Normal extends HbQuery {

  static Logger logger = Logger.getLogger(HbQuery1Normal.class);

  public HbQuery1Normal() {
    super("query1", "normal");
    tableName = "normal:post_history";
  }

  @Override
  public Scan createScan() {
    SingleColumnValueFilter filter = new SingleColumnValueFilter(
        Bytes.toBytes("post_history"), Bytes.toBytes("PostId"),
        CompareFilter.CompareOp.EQUAL, new BinaryComparator(Bytes.toBytes("26")));
    filter.setFilterIfMissing(true);
    Scan scan = new Scan();
    scan.setFilter(filter);
    return scan;
  }

  @Override
  public void processResult() {
    //nothing to do
  }


}
