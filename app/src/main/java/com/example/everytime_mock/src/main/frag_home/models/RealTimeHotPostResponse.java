package com.example.everytime_mock.src.main.frag_home.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RealTimeHotPostResponse {

    @SerializedName("result")
    private List<RealTimeHotPostResult> realTimeHotPostResults;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public RealTimeHotPostResponse(List<RealTimeHotPostResult> realTimeHotPostResults, int code, String message, boolean isSuccess) {
        this.realTimeHotPostResults = realTimeHotPostResults;
        this.code = code;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public List<RealTimeHotPostResult> getRealTimeHotPostResults() {
        return realTimeHotPostResults;
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