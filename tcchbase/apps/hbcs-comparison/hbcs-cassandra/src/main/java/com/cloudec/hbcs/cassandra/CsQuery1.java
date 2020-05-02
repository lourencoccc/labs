package com.cloudec.hbcs.cassandra;

import org.apache.log4j.Logger;

/**
 * Q1 - Selecionar PostHistory por PostId - Simples
 *
 * CREATE TABLE IF NOT EXISTS query.q1_post_history_by_postid (
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
 * PRIMARY KEY (post_history_PostId, post_history_Id)
 * );
 *
 * @author SOUZA JR, JOAO
 * @since 2017-04-28
 */
public class CsQuery1 extends CsQuery {

  static Logger logger = Logger.getLogger(CsQuery1.class);

  public CsQuery1() {
    super("query1", "query");
  }

  @Override
  public String createDefaultQuery() {
    return "SELECT * FROM "
        + "query.q1_post_history_by_postid WHERE post_history_postid = '26'";
  }
}
