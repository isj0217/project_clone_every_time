package com.example.everytime_mock.src.main.frag_home.my_page.interfaces;

import com.example.everytime_mock.src.main.frag_home.my_page.models.MyPageResponse;

public interface MyPageActivityView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void myPageSuccess(MyPageResponse myPageResponse);
}