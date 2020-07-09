package com.example.everytime_mock.src.main.frag_home.my_page.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyPageResponse {

    @SerializedName("result")
    private List<MyPageResult> myPageResult;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public MyPageResponse() {
    }

    public MyPageResponse(List<MyPageResult> myPageResult, int code, String message, boolean isSuccess) {
        this.myPageResult = myPageResult;
        this.code = code;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public List<MyPageResult> getMyPageResult() {
        return myPageResult;
    }

    public void setMyPageResult(List<MyPageResult> myPageResult) {
        this.myPageResult = myPageResult;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}