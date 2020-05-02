package com.cloudec.hbcs.cassandra;

/**
 * Q1 - Selecionar PostHistory por PostId - Simples
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
public class CsQuery1Normal extends CsQuery {

  public CsQuery1Normal() {
    super("query1", "normal");
  }

  @Override
  public String createDefaultQuery() {
    return "SELECT * FROM "
        + "normal.post_history WHERE post_history_postid = '26' ALLOW FILTERING";

  }
}
