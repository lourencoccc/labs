CREATE KEYSPACE  IF NOT EXISTS query
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 3};

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

CREATE TABLE IF NOT EXISTS query.q2_posts_scores_by_userid (
  posts_Id text,
  posts_Score int,
  posts_ViewCount int,
  posts_OwnerUserId text,
  site text,
  PRIMARY KEY (posts_OwnerUserId, posts_Id, site)
);

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
