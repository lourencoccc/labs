package com.cloudec.hbcs.hbase;

import com.cloudec.hbcs.HbcsProcessor;
import java.time.Instant;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;

/**
 * Q2 - Selecionar total de Scores por ID do usuario - Media
 *
 * create 'query:q2_posts_scores_by_userid', 'posts'
 */
public class HbQuery2 extends HbQuery {

  static Logger logger = Logger.getLogger(HbQuery2.class);

  public HbQuery2() {
    super("query2", "query");
    tableName = "query:q2_posts_scores_by_userid";
  }

  private int totalScores = 0;

  @Override
  public Scan createScan() {
    Scan scan = new Scan();
    scan.setStartRow(Bytes.toBytes("33_"));
    scan.setStopRow(Bytes.toBytes("34"));
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
