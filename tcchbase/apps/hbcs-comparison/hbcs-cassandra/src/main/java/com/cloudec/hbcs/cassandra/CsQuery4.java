package com.cloudec.hbcs.cassandra;

import com.cloudec.hbcs.HbcsProcessor;
import com.datastax.driver.core.Row;
import java.time.Instant;
import org.apache.log4j.Logger;

/**
 * Q4 - Selecionar total de votos UpMod e DownMod por UserId - Complexa
 *
 * @author SOUZA JR, JOAO
 * @since 2017-05-28
 */
public class CsQuery4 extends CsQuery {

  static Logger logger = Logger.getLogger(CsQuery4.class);

  private int totalUpMod = 0;
  private int totalDownMod = 0;

  public CsQuery4() {
    super("query4", "query");
  }

  @Override
  public String createDefaultQuery() {
    return "select votes_votetypeid from query.q4_posts_votes_by_userid where "
        + "posts_owneruserid ='33' and votes_votetypeid in ('2', '3') ALLOW FILTERING;";
  }


  @Override
  public void processResult() {
    if (resultSet != null) {
      Instant start = Instant.now();
      totalUpMod = 0;
      totalDownMod = 0;
      for (Row row : resultSet) {
        String voteType = row.getString("votes_votetypeid");
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

  @Override
  public void show() {
    super.show();
    System.out.println("***************** HBCS - CASSANDRA - RESULT -QUERY4 *****************");
    System.out.println("Total votes UpMod: " + this.totalUpMod);
    System.out.println("Total votes DownMod: " + this.totalDownMod);
  }

}
