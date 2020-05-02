package com.cloudec.hbcs.hbase;

import static org.apache.hadoop.hbase.util.Bytes.toBytes;

import com.cloudec.hbcs.HbcsProcessor;
import com.cloudec.hbcs.HbcsReport;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

/**
 * Q4 - Selecionar total de votos UpMod e DownMod por UserId - Complexa
 */
public class HbQuery4Normal extends HbQuery {

  static Logger logger = Logger.getLogger(HbQuery4Normal.class);

  static final String VOTE_TYPE_ID_UP_MOD = "2";
  static final String VOTE_TYPE_ID_DOWN_MOD = "3";

  public HbQuery4Normal() {
    super("query4", "normal");
    tableName = "normal:posts";
  }

  private int totalUpMod = 0;
  private int totalDownMod = 0;

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
  public void processResult() {
    if (resultScanner != null) {
      Instant start = Instant.now();
      FilterList filtersExt = new FilterList(Operator.MUST_PASS_ONE);
      totalUpMod = 0;
      totalDownMod = 0;
      for (Result result : resultScanner) {
        byte[] postId = result.getValue(toBytes("posts"), toBytes("Id"));
        byte[] site = result.getValue(toBytes("posts"), toBytes("site"));
        FilterList filters = new FilterList(Operator.MUST_PASS_ALL);
        SingleColumnValueFilter filter = new SingleColumnValueFilter(
            Bytes.toBytes("votes"), Bytes.toBytes("PostId"),
            CompareFilter.CompareOp.EQUAL, new BinaryComparator(postId));
        SingleColumnValueFilter filter2 = new SingleColumnValueFilter(
            Bytes.toBytes("votes"), Bytes.toBytes("site"),
            CompareFilter.CompareOp.EQUAL, new BinaryComparator(site));
        filter.setFilterIfMissing(true);
        filter2.setFilterIfMissing(true);
        filters.addFilter(filter);
        filters.addFilter(filter2);

        Scan scan = new Scan();
        scan.setFilter(filters);
        Instant end = Instant.now();
        addReport(HbcsProcessor.APPLICATION, start, end);

        HbcsReport hbcsReport = createReport(HbcsProcessor.DATABASE);
        resultScanner = hbQueryScanner.scan("normal:votes", scan, hbcsReport);
        reports.add(hbcsReport);

        start = Instant.now();
        for (Result resultVotes : resultScanner) {
          byte[] voteTypeId = resultVotes.getValue(Bytes.toBytes("votes"),
              Bytes.toBytes("VoteTypeId"));
          String voteType = Bytes.toString(voteTypeId);
          if (VOTE_TYPE_ID_UP_MOD.equals(voteType)) {
            this.totalUpMod++;
          } else if (VOTE_TYPE_ID_DOWN_MOD.equals(voteType)) {
            this.totalDownMod++;
          }
        }
        end = Instant.now();
        addReport(HbcsProcessor.APPLICATION, start, end);
      }
    }
  }

  public void show() {
    System.out.println("***************** HBCS - HBASE - RESULT -QUERY4 *****************");
    System.out.println("Total votes UpMod: " + totalUpMod);
    System.out.println("Total votes DownMod: " + totalDownMod);
    printReport();
  }
}
