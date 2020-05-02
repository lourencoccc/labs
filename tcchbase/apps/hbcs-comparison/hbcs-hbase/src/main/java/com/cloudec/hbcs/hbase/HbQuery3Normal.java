package com.cloudec.hbcs.hbase;

import static org.apache.hadoop.hbase.util.Bytes.toBytes;

import com.cloudec.hbcs.HbcsProcessor;
import com.cloudec.hbcs.HbcsReport;
import java.time.Instant;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.BinaryPrefixComparator;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.FilterList.Operator;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;

public class HbQuery3Normal extends HbQuery {

  static Logger logger = Logger.getLogger(HbQuery3Normal.class);

  public HbQuery3Normal() {
    super("query3", "normal");
    tableName = "normal:post_history";
  }

  public Scan createScanPost(byte[] postId) {
    Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL,
        new BinaryComparator(postId));
    Scan scan = new Scan();
    scan.setFilter(filter);
    return scan;
  }

  @Override
  public Scan createScan() {
    SingleColumnValueFilter filter = new SingleColumnValueFilter(toBytes("post_history"),
        toBytes("PostHistoryTypeId"), CompareFilter.CompareOp.EQUAL,
        new BinaryComparator(toBytes("10")));
    // all rows that do not have the reference column are dropped from the result.
    filter.setFilterIfMissing(true);
    Scan scan = new Scan();
    scan.setFilter(filter);
    return scan;
  }

  @Override
  public void processResult() {
    FilterList filters = new FilterList(Operator.MUST_PASS_ONE);
    if (resultScanner != null) {
      Instant start = Instant.now();
      for (Result result : resultScanner) {
        byte[] postId = result.getValue(toBytes("post_history"), toBytes("PostId"));
        byte[] site = result.getValue(toBytes("post_history"), toBytes("site"));
        String postRowKey = Bytes.toString(postId) + "_" + Bytes.toString(site);
        Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL,
            new BinaryPrefixComparator(toBytes(postRowKey)));
        filters.addFilter(filter);
      }
      Scan scan = new Scan();
      scan.setFilter(filters);
      Instant end = Instant.now();
      addReport(HbcsProcessor.APPLICATION, start, end);
      HbcsReport hbcsReport = createReport(HbcsProcessor.DATABASE);
      this.resultScanner = hbQueryScanner.scan("normal:posts", scan, hbcsReport);
      reports.add(hbcsReport);
    }
  }
}
