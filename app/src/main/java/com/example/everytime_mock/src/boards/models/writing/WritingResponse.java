package com.example.everytime_mock.src.boards.models;

import com.google.gson.annotations.SerializedName;

public class WritingResponse {

    public class WritingResult {
        @SerializedName("noticeIdx")
        private String noticeIdx;

        @SerializedName("noticeName")
        private String noticeName;

        @SerializedName("contentTitle")
        private String contentTitle;

        @SerializedName("contentInf")
        private String contentInf;

        @SerializedName("userStatus")
        private String userStatus;
    }


    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private WritingResult writingResult;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public WritingResult getWritingResult() {
        return writingResult;
    }
}