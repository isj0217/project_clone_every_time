package com.example.everytime_mock.src.boards.in_post.models;

public class CommentAddResult {
    int contentIdx;
    String commentInf;
    int userStatus;

    public CommentAddResult(int contentIdx, String commentInf, int userStatus) {
        this.contentIdx = contentIdx;
        this.commentInf = commentInf;
        this.userStatus = userStatus;
    }

    public int getContentIdx() {
        return contentIdx;
    }

    public String getCommentInf() {
        return commentInf;
    }

    public int getUserStatus() {
        return userStatus;
    }
}
