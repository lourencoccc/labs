CREATE KEYSPACE  IF NOT EXISTS query
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};

CREATE TABLE IF NOT EXISTS query.q1_post_history_by_postid (
    post_history_Id text,
    post_history_PostHistoryTypeId text,
    post_history_PostId text,
    post_history_RevisionGUID text,
    post_history_CreationDate text,
    post_history_UserId text,
    post_history_UserDisplayName text,
    post_history_Comment text,
    post_history_Text text,
    post_history_CloseReasonId text,
    site text,
    PRIMARY KEY (post_history_PostId, post_history_Id, site)
);
