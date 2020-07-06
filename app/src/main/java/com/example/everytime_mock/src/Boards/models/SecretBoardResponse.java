package com.example.everytime_mock.src.Boards.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FreeBoardResponse {

    @SerializedName("result")
    private List<FreeBoardResult> freeBoardResults;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public FreeBoardResponse(List<FreeBoardResult> freeBoardResults, int code, String message, boolean isSuccess) {
        this.freeBoardResults = freeBoardResults;
        this.code = code;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public List<FreeBoardResult> getFreeBoardResults() {
        return freeBoardResults;
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