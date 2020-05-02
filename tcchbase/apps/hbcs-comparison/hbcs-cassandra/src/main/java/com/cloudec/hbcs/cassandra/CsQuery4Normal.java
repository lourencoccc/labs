package com.cloudec.hbcs.cassandra;

import com.cloudec.hbcs.HbcsProcessor;
import com.cloudec.hbcs.HbcsReport;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import java.time.Instant;


/**
 * Q4 - Selecionar total de votos UpMod e DownMod por UserId - Complexa
 *
 * @author SOUZA JR, JOAO
 * @since 2017-05-24
 */
public class CsQuery4Normal extends CsQuery {

  private int totalUpMod = 0;
  private int totalDownMod = 0;

  public CsQuery4Normal() {
    super("query4", "normal");
  }

  @Override
  public String createDefaultQuery() {
    return "select posts_Id, site from normal.posts where posts_owneruserid ='33' ALLOW FILTERING;";
  }

  @Override
  public void show() {
    super.show();
    System.out.println("***************** HBCS - CASSANDRA - RESULT -QUERY4 *****************");
    System.out.println("Total votes UpMod: " + this.totalUpMod);
    System.out.println("Total votes DownMod: " + this.totalDownMod);
  }

  @Override
  public void processResult() {
    if (resultSet != null) {
      totalUpMod = 0;
      totalDownMod = 0;
      for (Row row : resultSet) {
        StringBuilder cqlVotes = new StringBuilder("SELECT votes_VoteTypeId "
            + "FROM normal.votes WHERE votes_PostId = ");
        cqlVotes.append("'");
        cqlVotes.append(row.get("posts_id", String.class));
        cqlVotes.append("' AND site ='");
        cqlVotes.append(row.get("site", String.class));
        cqlVotes.append("' ALLOW FILTERING;");
        HbcsReport hbcsReport = createReport(HbcsProcessor.DATABASE);
        ResultSet resultVotes = csQueryExecutor.execute(cqlVotes.toString(), hbcsReport);
        reports.add(hbcsReport);
        Instant start = Instant.now();
        for (Row row1 : resultVotes) {
          String voteType = row1.getString("votes_votetypeid");
          if ("2".equals(voteType)) {
            this.totalUpMod++;
          } else if ("3".equals(voteType)) {
            this.totalDownMod++;
          }
        }
        Instant end = Instant.now();
        addReport(HbcsProcessor.APPLICATION, start, end);
      }
    }
  }

}
