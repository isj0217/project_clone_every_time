package com.example.everytime_mock.src.SignUp.interfaces;

import com.example.everytime_mock.src.SignUp.models.SignUpResponse;

public interface SignUpInputFormActivityView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void signUpSuccess(SignUpResponse signUpResponse);
//    void signUpSuccess(String string);
}