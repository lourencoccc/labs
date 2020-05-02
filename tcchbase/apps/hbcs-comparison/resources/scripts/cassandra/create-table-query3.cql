CREATE KEYSPACE  IF NOT EXISTS query
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};

CREATE TABLE IF NOT EXISTS query.q3_posts_by_posthistorytypeid (
    posts_Id text,
    posts_PostTypeId text,
    posts_ParentID text,
    posts_AcceptedAnswerId text,
    posts_CreationDate text,
    posts_Score int,
    posts_ViewCount int,
    posts_Body text,
    posts_OwnerUserId text,
    posts_OwnerDisplayName text,
    posts_LastEditorUserId text,
    posts_LastEditorDisplayName text,
    posts_LastEditDate text,
    posts_LastActivityDate text,
    posts_CommunityOwnedDate text,
    posts_ClosedDate text,
    posts_Title text,
    posts_Tags text,
    posts_AnswerCount int,
    posts_CommentCount int,
    posts_FavoriteCount int,
    post_history_Id text,
    post_history_PostHistoryTypeId text,
    post_history_PostId text,
    site text,
    PRIMARY KEY (post_history_PostHistoryTypeId, post_history_PostId, site)
);
