package com.example.everytime_mock.src.main.frag_board.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FavoriteBoardResponse {

    @SerializedName("result")
    private List<FavoriteBoardResult> favoriteBoardResults;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public FavoriteBoardResponse(List<FavoriteBoardResult> favoriteBoardResults, int code, String message, boolean isSuccess) {
        this.favoriteBoardResults = favoriteBoardResults;
        this.code = code;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public List<FavoriteBoardResult> getFavoriteBoardResults() {
        return favoriteBoardResults;
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