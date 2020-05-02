package com.cloudec.hbcs.hbase;

import static org.apache.hadoop.hbase.util.Bytes.toBytes;

import com.cloudec.hbcs.HbcsProcessor;
import java.time.Instant;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.FilterList.Operator;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;

/**
 * Q4 - Selecionar total de votos UpMod e DownMod por UserId - Complexa
 */
public class HbQuery4 extends HbQuery {

  static Logger logger = Logger.getLogger(HbQuery4.class);

  static final String VOTE_TYPE_ID_UP_MOD = "2";
  static final String VOTE_TYPE_ID_DOWN_MOD = "3";

  public HbQuery4() {
    super("query4", "query");
    tableName = "query:q4_posts_votes_by_userid";
  }

  private int totalUpMod = 0;
  private int totalDownMod = 0;

  @Override
  public Scan createScan() {

    FilterList filters = new FilterList(Operator.MUST_PASS_ONE);
    SingleColumnValueFilter filterVoteTypeId2 =
        new SingleColumnValueFilter(Bytes.toBytes("votes"), Bytes.toBytes("VoteTypeId"),
            CompareFilter.CompareOp.EQUAL, new BinaryComparator(Bytes.toBytes("2")));
    SingleColumnValueFilter filterVoteTypeId3 =
        new SingleColumnValueFilter(Bytes.toBytes("votes"), Bytes.toBytes("VoteTypeId"),
            CompareFilter.CompareOp.EQUAL, new BinaryComparator(Bytes.toBytes("3")));
//     all rows that do not have the reference column are dropped from the result.
    filterVoteTypeId2.setFilterIfMissing(true);
    filterVoteTypeId3.setFilterIfMissing(true);
    filters.addFilter(filterVoteTypeId2);
    filters.addFilter(filterVoteTypeId3);
    Scan scan = new Scan(Bytes.toBytes("33_"));
    scan.setStopRow(Bytes.toBytes("34"));
    scan.setFilter(filters);
    return scan;
  }

  @Override
  public void processResult() {
    if (resultScanner != null) {
      Instant start = Instant.now();
      totalUpMod = 0;
      totalDownMod = 0;
      for (Result result : resultScanner) {
        byte[] voteTypeId = result.getValue(Bytes.toBytes("votes"), Bytes.toBytes("VoteTypeId"));
        String voteType = Bytes.toString(voteTypeId);
        if (VOTE_TYPE_ID_UP_MOD.equals(voteType)) {
          this.totalUpMod++;
        } else if (VOTE_TYPE_ID_DOWN_MOD.equals(voteType)) {
          this.totalDownMod++;
        }
      }
      Instant end = Instant.now();
      addReport(HbcsProcessor.APPLICATION, start, end);
    }
  }

  public void show() {
    System.out.println("***************** HBCS - HBASE - RESULT -QUERY4 *****************");
    System.out.println("Total votes UpMod: " + totalUpMod);
    System.out.println("Total votes DownMod: " + totalDownMod);
    printReport();
  }
}
