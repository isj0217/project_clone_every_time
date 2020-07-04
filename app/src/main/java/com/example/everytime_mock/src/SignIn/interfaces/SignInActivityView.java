package com.example.everytime_mock.src.SignIn.interfaces;

import com.example.everytime_mock.src.SignIn.models.SignInResponse;

public interface SignInActivityView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void signInSuccess(SignInResponse signInResponse);
}