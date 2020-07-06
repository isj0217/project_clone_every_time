package com.example.everytime_mock.src.Boards.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SecretBoardResponse {

    @SerializedName("result")
    private List<SecretBoardResult> secretBoardResults;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public SecretBoardResponse(List<SecretBoardResult> secretBoardResults, int code, String message, boolean isSuccess) {
        this.secretBoardResults = secretBoardResults;
        this.code = code;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public List<SecretBoardResult> getSecretBoardResults() {
        return secretBoardResults;
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