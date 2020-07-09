package com.example.everytime_mock.src.main.frag_home.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecentLectureReviewResponse {

    @SerializedName("result")
    private List<RecentLectureReviewResult> recentLectureReviewResults;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public RecentLectureReviewResponse(List<RecentLectureReviewResult> recentLectureReviewResults, int code, String message, boolean isSuccess) {
        this.recentLectureReviewResults = recentLectureReviewResults;
        this.code = code;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public List<RecentLectureReviewResult> getRecentLectureReviewResults() {
        return recentLectureReviewResults;
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