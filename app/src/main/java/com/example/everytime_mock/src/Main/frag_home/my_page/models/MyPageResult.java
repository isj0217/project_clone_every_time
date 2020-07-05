package com.example.everytime_mock.src.Main.models;

public class MyPageResult {

    String userNickname;
    String userID;
    String univName;
    String univYear;

    public MyPageResult(String userNickname, String userID, String univName, String univYear) {
        this.userNickname = userNickname;
        this.userID = userID;
        this.univName = univName;
        this.univYear = univYear;
    }

    public MyPageResult() {

    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUnivName() {
        return univName;
    }

    public void setUnivName(String univName) {
        this.univName = univName;
    }

    public String getUnivYear() {
        return univYear;
    }

    public void setUnivYear(String univYear) {
        this.univYear = univYear;
    }
}
