CREATE KEYSPACE  IF NOT EXISTS query
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};

CREATE TABLE IF NOT EXISTS query.q2_posts_scores_by_userid (
  posts_Id text,
  posts_Score int,
  posts_ViewCount int,
  posts_OwnerUserId text,
  site text,
  PRIMARY KEY (posts_OwnerUserId, posts_Id, site)
);
