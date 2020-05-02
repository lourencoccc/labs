package com.cloudec.hbcs.cassandra;

import org.apache.log4j.Logger;

/**
 * Q2 - Selecionar total de Scores por ID do usuario - Media
 *
 * CREATE TABLE IF NOT EXISTS query.q2_posts_scores_by_userid (
 * posts_Id text,
 * posts_Score int,
 * posts_ViewCount int,
 * posts_OwnerUserId text,
 * PRIMARY KEY (posts_OwnerUserId, posts_Id)
 * );
 *
 * @author SOUZA JR, JOAO
 * @since 2017-04-28
 */
public class CsQuery2 extends CsQuery {

  static Logger logger = Logger.getLogger(CsQuery2.class);

  public CsQuery2() {
    super("query2", "query");
  }

  @Override
  public String createDefaultQuery() {
    return "SELECT posts_owneruserid, sum(posts_score) as sumscore "
        + "FROM query.q2_posts_scores_by_userid "
        + "WHERE posts_owneruserid = '33' ALLOW FILTERING;";
  }


}
