package com.example.everytime_mock.src.boards.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecentLectureReviewBoardResponse {

    @SerializedName("result")
    private List<RecentLectureReviewBoardResult> recentLectureReviewBoardResults;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public RecentLectureReviewBoardResponse(List<RecentLectureReviewBoardResult> recentLectureReviewBoardResults, int code, String message, boolean isSuccess) {
        this.recentLectureReviewBoardResults = recentLectureReviewBoardResults;
        this.code = code;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public List<RecentLectureReviewBoardResult> getRecentLectureReviewBoardResults() {
        return recentLectureReviewBoardResults;
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