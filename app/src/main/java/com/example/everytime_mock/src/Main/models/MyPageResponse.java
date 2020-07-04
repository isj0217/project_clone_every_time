package com.example.everytime_mock.src.Main.models;

import com.google.gson.annotations.SerializedName;

public class MyPageResponse {

    public class MyPageResult {
        @SerializedName("userNickname")
        private String userNickname;

        @SerializedName("userID")
        private String userID;

        @SerializedName("univName")
        private String univName;

        @SerializedName("univYear")
        private String univYear;

        public String getUserNickname() {
            return userNickname;
        }

        public String getUserID() {
            return userID;
        }

        public String getUnivName() {
            return univName;
        }

        public String getUnivYear() {
            return univYear;
        }
    }

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private MyPageResult myPageResult;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public MyPageResult getMyPageResult() {
        return myPageResult;
    }
}