package com.example.everytime_mock.src.main.frag_home.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HotPostResponse {

    @SerializedName("result")
    private List<HotPostResult> hotPostResults;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public HotPostResponse(List<HotPostResult> hotPostResults, int code, String message, boolean isSuccess) {
        this.hotPostResults = hotPostResults;
        this.code = code;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public List<HotPostResult> getHotPostResults() {
        return hotPostResults;
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