package com.example.everytime_mock.src.signUp;

import com.example.everytime_mock.src.signUp.interfaces.SignUpInputFormActivityView;
import com.example.everytime_mock.src.signUp.interfaces.SignUpInputFormRetrofitInterface;
import com.example.everytime_mock.src.signUp.models.SignUpResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class SignUpInputFormService {
    private final SignUpInputFormActivityView mSignUpInputFormActivity_View;
    private HashMap<String, Object> mParams;

    SignUpInputFormService(final SignUpInputFormActivityView signUpInputFormActivity_view) {
        this.mSignUpInputFormActivity_View = signUpInputFormActivity_view;
    }

    SignUpInputFormService(final SignUpInputFormActivityView signUpInputFormActivity_view, HashMap<String, Object> mParams) {
        this.mSignUpInputFormActivity_View = signUpInputFormActivity_view;
        this.mParams = mParams;
    }

    void postSignUp() {
        final SignUpInputFormRetrofitInterface signUpInputForms_retrofitInterface = getRetrofit().create(SignUpInputFormRetrofitInterface.class);
        signUpInputForms_retrofitInterface.signUpTest(mParams).enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {

                final SignUpResponse signUpResponse = response.body();
                if (signUpResponse == null) {
                    mSignUpInputFormActivity_View.validateFailure(null);
                    return;
                }

                mSignUpInputFormActivity_View.signUpSuccess(signUpResponse);
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                mSignUpInputFormActivity_View.validateFailure(null);
            }
        });
    }
}
