package com.example.everytime_mock.src.boards.models;

public class ReviewDetailResult {

    String selectHw;
    String selectTeam;
    String selectRate;
    String selectAtt;
    String selectTest;

    public ReviewDetailResult(String selectHw, String selectTeam, String selectRate, String selectAtt, String selectTest) {
        this.selectHw = selectHw;
        this.selectTeam = selectTeam;
        this.selectRate = selectRate;
        this.selectAtt = selectAtt;
        this.selectTest = selectTest;
    }

    public String getSelectHw() {
        return selectHw;
    }

    public String getSelectTeam() {
        return selectTeam;
    }

    public String getSelectRate() {
        return selectRate;
    }

    public String getSelectAtt() {
        return selectAtt;
    }

    public String getSelectTest() {
        return selectTest;
    }
}
