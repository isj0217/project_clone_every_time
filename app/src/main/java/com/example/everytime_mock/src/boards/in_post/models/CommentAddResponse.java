package com.example.everytime_mock.src.boards.in_post.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CommentAddResponse {

    @SerializedName("result")
    private List<CommentAddResult> commentAddResults;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public CommentAddResponse(List<CommentAddResult> commentAddResults) {
        this.commentAddResults = commentAddResults;
    }

    public List<CommentAddResult> getCommentAddResults() {
        return commentAddResults;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}