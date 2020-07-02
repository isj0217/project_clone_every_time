package com.example.everytime_mock.src.signup1_agreement.interfaces;

import com.example.everytime_mock.src.signup2_inputForms.models.SignUpResponse;

public interface SignUpInputFormActivityView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void signUpSuccess(SignUpResponse.SignUpResult signUpResult);
}