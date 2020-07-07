package com.example.everytime_mock.src.Boards.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReviewResponse {

    @SerializedName("result")
    private List<BoardResult> boardResults;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public ReviewResponse(List<BoardResult> boardResults, int code, String message, boolean isSuccess) {
        this.boardResults = boardResults;
        this.code = code;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public List<BoardResult> getBoardResults() {
        return boardResults;
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