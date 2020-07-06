package com.example.everytime_mock.src.Boards.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AlumniBoardResponse {

    @SerializedName("result")
    private List<AlumniBoardResult> alumniBoardResults;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public AlumniBoardResponse(List<AlumniBoardResult> alumniBoardResults, int code, String message, boolean isSuccess) {
        this.alumniBoardResults = alumniBoardResults;
        this.code = code;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public List<AlumniBoardResult> getAlumniBoardResults() {
        return alumniBoardResults;
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