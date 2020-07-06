package com.example.everytime_mock.src.Main.frag_home.models;

import com.example.everytime_mock.src.Main.frag_home.FragHome;
import com.google.gson.annotations.SerializedName;

public class FragHomeResponse {

    public class FragHomeResult {

    }


    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private FragHomeResult fragHomeResult;


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public FragHomeResult getFragHomeResult() {
        return fragHomeResult;
    }
}