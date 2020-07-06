package com.example.everytime_mock.src.Main.frag_home.models;

public class RealTimeHotPostResult {

    String contentWriter;
    String contentTitle;
    String contentInf;
    String noticeName;
    String writeDay;
    String countLike;
    String countComment;

    public RealTimeHotPostResult(String contentWriter, String contentTitle, String contentInf, String noticeName, String writeDay, String countLike, String countComment) {
        this.contentWriter = contentWriter;
        this.contentTitle = contentTitle;
        this.contentInf = contentInf;
        this.noticeName = noticeName;
        this.writeDay = writeDay;
        this.countLike = countLike;
        this.countComment = countComment;
    }

    public String getContentWriter() {
        return contentWriter;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public String getContentInf() {
        return contentInf;
    }

    public String getNoticeName() {
        return noticeName;
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
