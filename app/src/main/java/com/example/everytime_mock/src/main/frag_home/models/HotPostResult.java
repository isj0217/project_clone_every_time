package com.example.everytime_mock.src.main.frag_home.models;

public class HotPostResult {

    String contentIdx;
    String contentTitle;
    String writeDay;
    String countLike;
    String countComment;

    public HotPostResult(String contentIdx, String contentTitle, String writeDay, String countLike, String countComment) {
        this.contentIdx = contentIdx;
        this.contentTitle = contentTitle;
        this.writeDay = writeDay;
        this.countLike = countLike;
        this.countComment = countComment;
    }

    public String getContentIdx() {
        return contentIdx;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public String getWriteDay() {
        return writeDay;
    }

    public String getCountLike() {
        return countLike;
    }

    public String getCountComment() {
        return countComment;
    }
}
