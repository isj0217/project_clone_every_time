package com.example.everytime_mock.src.boards.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReviewDetailResponse {

    @SerializedName("result")
    private List<ReviewDetailResult> reviewDetailResults;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public ReviewDetailResponse(List<ReviewDetailResult> reviewDetailResults, int code, String message, boolean isSuccess) {
        this.reviewDetailResults = reviewDetailResults;
        this.code = code;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public List<ReviewDetailResult> getReviewDetailResults() {
        return reviewDetailResults;
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