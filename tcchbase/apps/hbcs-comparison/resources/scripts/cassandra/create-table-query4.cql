CREATE KEYSPACE  IF NOT EXISTS query
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};

CREATE TABLE IF NOT EXISTS query.q4_posts_votes_by_userid (
    posts_Id text,
    posts_OwnerUserId text,
    votes_Id text,
    votes_PostId text,
    votes_VoteTypeId text,
    votes_CreationDate text,
    site text,
    PRIMARY KEY (votes_VoteTypeId, votes_PostId, votes_Id, site)
);
