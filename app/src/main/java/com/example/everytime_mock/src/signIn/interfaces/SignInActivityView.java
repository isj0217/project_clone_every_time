package com.example.everytime_mock.src.signIn.interfaces;

import com.example.everytime_mock.src.signIn.models.SignInResponse;

public interface SignInActivityView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void signInSuccess(SignInResponse signInResponse);
}