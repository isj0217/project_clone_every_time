package com.example.everytime_mock.src.boards.in_post.models;

public class CommentResult {
    int commentIdx;
    String commentInf;
    String commentWriter;
    int commentCountLike;
    String commentWriteDay;

    public CommentResult(int commentIdx, String commentInf, String commentWriter, int commentCountLike, String commentWriteDay) {
        this.commentIdx = commentIdx;
        this.commentInf = commentInf;
        this.commentWriter = commentWriter;
        this.commentCountLike = commentCountLike;
        this.commentWriteDay = commentWriteDay;
    }

    public int getCommentIdx() {
        return commentIdx;
    }

    public String getCommentInf() {
        return commentInf;
    }

    public String getCommentWriter() {
        return commentWriter;
    }

    public int getCommentCountLike() {
        return commentCountLike;
    }

    public String getCommentWriteDay() {
        return commentWriteDay;
    }
}
