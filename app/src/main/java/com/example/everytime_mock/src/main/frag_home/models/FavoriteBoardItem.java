package com.example.everytime_mock.src.main.frag_home.models;

public class FavoriteBoardItem {
    private String tv_board_name;
    private String tv_board_title;
    private int is_new;

    public FavoriteBoardItem(String tv_board_name, String tv_board_title, int is_new) {
        this.tv_board_name = tv_board_name;
        this.tv_board_title = tv_board_title;
        this.is_new = is_new;
    }

    public String getTv_board_name() {
        return tv_board_name;
    }

    public void setTv_board_name(String tv_board_name) {
        this.tv_board_name = tv_board_name;
    }

    public String getTv_board_title() {
        return tv_board_title;
    }

    public void setTv_board_title(String tv_board_title) {
        this.tv_board_title = tv_board_title;
    }

    public int getIs_new() {
        return is_new;
    }

    public void setIs_new(int is_new) {
        this.is_new = is_new;
    }
}
