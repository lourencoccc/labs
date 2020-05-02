package com.cloudec.hbcs.cassandra;

import com.cloudec.hbcs.HbcsProcessor;
import com.cloudec.hbcs.HbcsReport;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Q3 - Selecionar todos as postagens (Posts) fechadas (PostHistoryTypeId igual á 10)
 *
 * CREATE TABLE IF NOT EXISTS normal.post_history (
 * post_history_Id text,
 * post_history_PostHistoryTypeId text,
 * post_history_PostId text,
 * post_history_RevisionGUID text,
 * post_history_CreationDate text,
 * post_history_UserId text,
 * post_history_UserDisplayName text,
 * post_history_Comment text,
 * post_history_Text text,
 * post_history_CloseReasonId text,
 * site text,
 * PRIMARY KEY (post_history_Id, site)
 * );
 *
 * @author SOUZA JR, JOAO
 * @since 2017-05-24
 */
public class CsQuery3Normal extends CsQuery {

  public CsQuery3Normal() {
    super("query3", "normal");
  }

  List<ResultSet> resultSets;

  @Override
  public String createDefaultQuery() {
    return "SELECT post_history_PostId, site FROM normal.post_history WHERE post_history_PostHistoryTypeId = '10' ALLOW FILTERING";
  }

  @Override
  public void processResult() {
    if (resultSet != null) {
      Instant start = Instant.now();
      Set<String> cqlPosts = new HashSet<>();
      for (Row row : resultSet) {
        String pId = row.get("post_history_PostId", String.class);
        String s = row.get("site", String.class);
        StringBuilder cqlPost = new StringBuilder(
            "SELECT * FROM normal.posts WHERE posts_id = '");
        cqlPost.append(pId);
        cqlPost.append("' AND site = '");
        cqlPost.append(s);
        cqlPost.append("';");
        cqlPosts.add(cqlPost.toString());
      }
      Instant end = Instant.now();
      addReport(HbcsProcessor.APPLICATION, start, end);
      this.resultSets = new LinkedList<>();
      for (String cqlPost : cqlPosts) {
        HbcsReport hbcsReport = createReport(HbcsProcessor.DATABASE);
        this.resultSets.add(csQueryExecutor.execute(cqlPost, hbcsReport));
        reports.add(hbcsReport);
      }
    }
  }

  private void processSelectIn() {
    if (resultSet != null) {
      Instant start = Instant.now();

      Set<String> postIds = new HashSet<>();
      Set<String> sites = new HashSet<>();
      for (Row row : resultSet) {
        String pId = row.get("post_history_PostId", String.class);
        String s = row.get("site", String.class);
        postIds.add(pId);
        sites.add(row.get("site", String.class));
        System.out.println("[" + pId + "," + s + "]");
      }
      System.out.println("SIZE " + postIds.size());
      StringBuilder cqlPosts = new StringBuilder(
          "SELECT posts_id, site FROM normal.posts WHERE posts_id IN ");
      cqlPosts.append("(");
      for (String postId : postIds) {
        cqlPosts.append("'");
        cqlPosts.append(postId);
        cqlPosts.append("',");
      }
      cqlPosts.replace(cqlPosts.length() - 1, cqlPosts.length(), "");
      cqlPosts.append(")");
      cqlPosts.append(" AND site IN ");
      cqlPosts.append("(");
      for (String site : sites) {
        cqlPosts.append("'");
        cqlPosts.append(site);
        cqlPosts.append("',");
      }
      cqlPosts.replace(cqlPosts.length() - 1, cqlPosts.length(), "");
      cqlPosts.append(")");
      System.out.println(cqlPosts.toString());
      Instant end = Instant.now();
      addReport(HbcsProcessor.APPLICATION, start, end);
      HbcsReport hbcsReport = createReport(HbcsProcessor.DATABASE);
      this.resultSet = csQueryExecutor.execute(cqlPosts.toString(), hbcsReport);
      reports.add(hbcsReport);
    }
  }
}
