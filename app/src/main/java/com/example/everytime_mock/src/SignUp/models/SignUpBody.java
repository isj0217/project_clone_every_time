package com.example.everytime_mock.src.SignUp.models;

import com.google.gson.annotations.SerializedName;

public class SignUpBody {

    public SignUpBody(String userID, String pw, String userNickname, String phoneNum, String univName, int univYear, String email) {
        this.userID = userID;
        this.pw = pw;
        this.userNickname = userNickname;
        this.phoneNum = phoneNum;
        this.univName = univName;
        this.univYear = univYear;
        this.email = email;
    }

    @SerializedName("userID")
    private String userID;

    @SerializedName("pw")
    private String pw;

    @SerializedName("userNickname")
    private String userNickname;

    @SerializedName("phoneNum")
    private String phoneNum;

    @SerializedName("univName")
    private String univName;

    @SerializedName("univYear")
    private int univYear;

    @SerializedName("email")
    private String email;
}
