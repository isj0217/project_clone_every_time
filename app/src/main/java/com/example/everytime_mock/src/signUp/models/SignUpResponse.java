package com.example.everytime_mock.src.signUp.models;

import com.google.gson.annotations.SerializedName;

public class SignUpResponse {

    public class SignUpResult {
        @SerializedName("jwt")
        private String jwt;

        public String getJwt() {
            return jwt;
        }
    }


    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private SignUpResult signUpResult;


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public SignUpResult getSignUpResult() {
        return signUpResult;
    }
}