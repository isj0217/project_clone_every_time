package com.example.everytime_mock.src.Main.interfaces;

import com.example.everytime_mock.src.Main.models.MyPageResponse;

public interface MyPageActivityView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void myPageSuccess(MyPageResponse myPageResponse);
}