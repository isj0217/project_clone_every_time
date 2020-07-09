package com.example.everytime_mock.src.boards.in_post.models;

import com.example.everytime_mock.src.boards.models.common_board.CommonBoardResult;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CommentResponse {

    @SerializedName("result")
    private List<CommentResult> commentResults;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public CommentResponse(List<CommentResult> commentResults, int code, String message, boolean isSuccess) {
        this.commentResults = commentResults;
        this.code = code;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public List<CommentResult> getCommentResults() {
        return commentResults;
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