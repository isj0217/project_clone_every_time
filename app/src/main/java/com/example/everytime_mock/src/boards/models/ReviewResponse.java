package com.example.everytime_mock.src.boards.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReviewResponse {

    @SerializedName("result")
    private List<ReviewResult> reviewResults;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public ReviewResponse(List<ReviewResult> reviewResults, int code, String message, boolean isSuccess) {
        this.reviewResults = reviewResults;
        this.code = code;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public List<ReviewResult> getReviewResults() {
        return reviewResults;
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