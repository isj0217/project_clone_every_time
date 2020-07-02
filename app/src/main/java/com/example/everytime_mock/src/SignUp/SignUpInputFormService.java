package com.example.everytime_mock.src.signup2_inputForms;

import com.example.everytime_mock.src.SignIn.interfaces.SignInRetrofitInterface;
import com.example.everytime_mock.src.SignIn.models.DefaultResponse;
import com.example.everytime_mock.src.signup1_agreement.interfaces.SignUpInputFormActivityView;
import com.example.everytime_mock.src.signup1_agreement.interfaces.SignUpInputFormRetrofitInterface;
import com.example.everytime_mock.src.signup2_inputForms.models.SignUpResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class Signup2_Service {
    private final SignUpInputFormActivityView mSignUpInputFormActivity__View;
    private HashMap<String, Object> mParams;

    Signup2_Service(final SignUpInputFormActivityView signUpInputFormActivity__view) {
        this.mSignUpInputFormActivity__View = signUpInputFormActivity__view;
    }

    Signup2_Service(final SignUpInputFormActivityView signUpInputFormActivity__view, HashMap<String, Object> mParams) {
        this.mSignUpInputFormActivity__View = signUpInputFormActivity__view;
        this.mParams = mParams;
    }

    void getTest() {
        final SignInRetrofitInterface signInRetrofitInterface = getRetrofit().create(SignInRetrofitInterface.class);
        signInRetrofitInterface.getTest().enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                final DefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mSignUpInputFormActivity__View.validateFailure(null);
                    return;
                }

                mSignUpInputFormActivity__View.validateSuccess(defaultResponse.getMessage());
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                mSignUpInputFormActivity__View.validateFailure(null);
            }
        });
    }

    void postSignUp() {
        final SignUpInputFormRetrofitInterface signUpInputForms_retrofitInterface = getRetrofit().create(SignUpInputFormRetrofitInterface.class);
        signUpInputForms_retrofitInterface.signUpTest(mParams).enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                final SignUpResponse signUpResponse = response.body();
                if (signUpResponse == null) {
                    mSignUpInputFormActivity__View.validateFailure(null);
                    return;
                }

                mSignUpInputFormActivity__View.signUpSuccess(signUpResponse.getSignUpResult());
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                mSignUpInputFormActivity__View.validateFailure(null);
            }
        });
    }
}
