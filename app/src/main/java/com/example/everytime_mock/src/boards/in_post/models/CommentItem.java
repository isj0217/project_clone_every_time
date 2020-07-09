package com.example.everytime_mock.src.boards.in_post.models;

public class CommentItem {

    private int commentIdx;
    private String commentInf;
    private String commentWriter;
    private int commentCountLike;
    private String commentWriteDay;

    public int getCommentIdx() {
        return commentIdx;
    }

    public void setCommentIdx(int commentIdx) {
        this.commentIdx = commentIdx;
    }

    public String getCommentInf() {
        return commentInf;
    }

    public void setCommentInf(String commentInf) {
        this.commentInf = commentInf;
    }

    public String getCommentWriter() {
        return commentWriter;
    }

    public void setCommentWriter(String commentWriter) {
        this.commentWriter = commentWriter;
    }

    public int getCommentCountLike() {
        return commentCountLike;
    }

    public void setCommentCountLike(int commentCountLike) {
        this.commentCountLike = commentCountLike;
    }

    public String getCommentWriteDay() {
        return commentWriteDay;
    }

    public void setCommentWriteDay(String commentWriteDay) {
        this.commentWriteDay = commentWriteDay;
    }
}
