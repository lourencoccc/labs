package com.cloudec.hbcs.cassandra;

import org.apache.log4j.Logger;

/**
 * Q3 - Selecionar todos as postagens (Posts) fechadas (PostHistoryTypeId igual á 10)
 *
 * CREATE TABLE IF NOT EXISTS query.q3_posts_by_posthistorytypeid (
 * posts_Id text,
 * posts_PostTypeId text,
 * posts_ParentID text,
 * posts_AcceptedAnswerId text,
 * posts_CreationDate text,
 * posts_Score int,
 * posts_ViewCount int,
 * posts_Body text,
 * posts_OwnerUserId text,
 * posts_OwnerDisplayName text,
 * posts_LastEditorUserId text,
 * posts_LastEditorDisplayName text,
 * posts_LastEditDate text,
 * posts_LastActivityDate text,
 * posts_CommunityOwnedDate text,
 * posts_ClosedDate text,
 * posts_Title text,
 * posts_Tags text,
 * posts_AnswerCount int,
 * posts_CommentCount int,
 * posts_FavoriteCount int,
 * post_history_Id text,
 * post_history_PostHistoryTypeId text,
 * post_history_PostId text,
 * site text,
 * PRIMARY KEY (post_history_PostHistoryTypeId, post_history_PostId, post_history_Id, site)
 * );
 *
 * @author SOUZA JR, JOAO
 * @since 2017-04-28
 */
public class CsQuery3 extends CsQuery {

  static Logger logger = Logger.getLogger(CsQuery3.class);

  public CsQuery3() {
    super("query3", "query");
  }

  @Override
  public String createDefaultQuery() {
    return "SELECT * FROM query.q3_posts_by_posthistorytypeid "
        + "WHERE post_history_PostHistoryTypeId = '10' ALLOW FILTERING";
  }
}