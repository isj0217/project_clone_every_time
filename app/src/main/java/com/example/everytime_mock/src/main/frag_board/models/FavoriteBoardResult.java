package com.example.everytime_mock.src.main.frag_board.models;

public class FavoriteBoardResult {

    int noticeIdx;
    String noticeName;
    int checkStatus;

    public FavoriteBoardResult(int noticeIdx, String noticeName, int checkStatus) {
        this.noticeIdx = noticeIdx;
        this.noticeName = noticeName;
        this.checkStatus = checkStatus;
    }

    public int getNoticeIdx() {
        return noticeIdx;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public int getCheckStatus() {
        return checkStatus;
    }
}
