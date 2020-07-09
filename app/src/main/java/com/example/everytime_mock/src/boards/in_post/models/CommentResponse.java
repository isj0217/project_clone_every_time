package com.example.everytime_mock.src.boards.models.common_board;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CommonBoardResponse {

    @SerializedName("result")
    private List<CommonBoardResult> commonBoardResults;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public CommonBoardResponse(List<CommonBoardResult> commonBoardResults, int code, String message, boolean isSuccess) {
        this.commonBoardResults = commonBoardResults;
        this.code = code;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public List<CommonBoardResult> getCommonBoardResults() {
        return commonBoardResults;
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