/**
 * @author SOUZA JR, JOAO
 * @since 2017-04-28
 */CREATE KEYSPACE  IF NOT EXISTS normal
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 3};

CREATE TABLE IF NOT EXISTS normal.posts (
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
    site text,
    PRIMARY KEY (posts_Id, site)
);

CREATE TABLE IF NOT EXISTS normal.post_history (
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
    PRIMARY KEY (post_history_Id, site)
);

CREATE TABLE IF NOT EXISTS normal.votes (
    votes_Id text,
    votes_PostId text,
    votes_VoteTypeId text,
    votes_CreationDate text,
    votes_UserId text,
    votes_BountyAmount int,
    site text,
    PRIMARY KEY (votes_Id, site)
);
