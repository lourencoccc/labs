package com.cloudec.hbcs.cassandra;

/**
 * @author SOUZA JR, JOAO
 * @since 2017-05-24
 */
public class CsQuery2Normal extends CsQuery {

  public CsQuery2Normal() {
    super("query2", "normal");
  }

  @Override
  public String createDefaultQuery() {
    return "SELECT posts_owneruserid, sum(posts_score) as sumscore FROM normal.posts WHERE posts_owneruserid = '33' ALLOW FILTERING;";
  }

}
