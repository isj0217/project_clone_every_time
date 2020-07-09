package com.example.everytime_mock.src.signIn.models;

import com.google.gson.annotations.SerializedName;

public class SignInBody {

    public SignInBody(String userID, String pw) {
        this.userID = userID;
        this.pw = pw;
    }

    @SerializedName("userID")
    private String userID;

    @SerializedName("pw")
    private String pw;
}
