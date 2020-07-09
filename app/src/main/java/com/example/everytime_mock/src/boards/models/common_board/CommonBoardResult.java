package com.example.everytime_mock.src.boards.models.common_board;

public class CommonBoardResult {

    int contentIdx;
    String contentWriter;
    String contentTitle;
    String contentInf;
    String noticeName;
    String contentThumbnailURL;
    String writeDay;
    int countLike;
    int countComment;
    int countImage;

    public CommonBoardResult(int contentIdx, String contentWriter, String contentTitle, String contentInf, String noticeName, String contentThumbnailURL, String writeDay, int countLike, int countComment, int countImage) {
        this.contentIdx = contentIdx;
        this.contentWriter = contentWriter;
        this.contentTitle = contentTitle;
        this.contentInf = contentInf;
        this.noticeName = noticeName;
        this.contentThumbnailURL = contentThumbnailURL;
        this.writeDay = writeDay;
        this.countLike = countLike;
        this.countComment = countComment;
        this.countImage = countImage;
    }

    public int getContentIdx() {
        return contentIdx;
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

    public String getContentThumbnailURL() {
        return contentThumbnailURL;
    }

    public String getWriteDay() {
        return writeDay;
    }

    public int getCountLike() {
        return countLike;
    }

    public int getCountComment() {
        return countComment;
    }

    public int getCountImage() {
        return countImage;
    }
}
