package com.example.everytime_mock.src.boards.in_post.models;

import com.google.gson.annotations.SerializedName;

public class CommentBody {

    public CommentBody(String commentInf, int userStatus) {
        this.commentInf = commentInf;
        this.userStatus = userStatus;
    }

    @SerializedName("commentInf")
    private String commentInf;

    @SerializedName("userStatus")
    private int userStatus;
}
