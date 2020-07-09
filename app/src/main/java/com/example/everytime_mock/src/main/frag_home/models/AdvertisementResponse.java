package com.example.everytime_mock.src.main.frag_home.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AdvertisementResponse {

    @SerializedName("result")
    private List<AdvertisementResult> advertisementResults;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public AdvertisementResponse(List<AdvertisementResult> advertisementResults, int code, String message, boolean isSuccess) {
        this.advertisementResults = advertisementResults;
        this.code = code;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public List<AdvertisementResult> getAdvertisementResults() {
        return advertisementResults;
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