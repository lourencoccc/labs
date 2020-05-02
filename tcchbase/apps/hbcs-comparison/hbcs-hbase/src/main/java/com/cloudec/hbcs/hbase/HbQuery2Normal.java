package com.cloudec.hbcs.hbase;

import com.cloudec.hbcs.HbcsProcessor;
import java.time.Instant;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;

/**
 * Q2 - Selecionar total de Scores por ID do usuario - Media
 *
 * create 'normal:posts', 'posts'
 */
public class HbQuery2Normal extends HbQuery {

  static Logger logger = Logger.getLogger(HbQuery2.class);

  public HbQuery2Normal() {
    super("query2", "normal");
    tableName = "normal:posts";
  }

  private int totalScores = 0;

  @Override
  public Scan createScan() {
    SingleColumnValueFilter filter = new SingleColumnValueFilter(
        Bytes.toBytes("posts"), Bytes.toBytes("OwnerUserId"),
        CompareFilter.CompareOp.EQUAL, new BinaryComparator(Bytes.toBytes("33")));
    filter.setFilterIfMissing(true);
    Scan scan = new Scan();
    scan.setFilter(filter);
    return scan;
  }

  @Override
  public void show() {
    System.out.println("***************** HBCS - HBASE - RESULT -QUERY2 *****************");
    System.out.println("Total Scores por OwnerUserId 33: " + totalScores);
    printReport();
  }

  @Override
  public void processResult() {
    if (resultScanner != null) {
      totalScores = 0;
      Instant start = Instant.now();
      for (Result result : resultScanner) {
        byte[] score = result.getValue(Bytes.toBytes("posts"), Bytes.toBytes("Score"));
        totalScores += Integer.parseInt(Bytes.toString(score));
      }
      Instant end = Instant.now();
      addReport(HbcsProcessor.APPLICATION, start, end);
    }
  }
}
