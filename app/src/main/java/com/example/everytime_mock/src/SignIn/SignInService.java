package com.example.everytime_mock.src.SignIn;

import com.example.everytime_mock.src.SignIn.interfaces.SignInActivityView;
import com.example.everytime_mock.src.SignIn.interfaces.SignInRetrofitInterface;
import com.example.everytime_mock.src.SignIn.models.DefaultResponse;
import com.example.everytime_mock.src.SignIn.models.SignInResponse;
import com.example.everytime_mock.src.SignUp.models.SignUpResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class SignInService {
    private final SignInActivityView mSignInActivityView;
    private HashMap<String, Object> mParams;

    SignInService(final SignInActivityView signInActivityView) {
        this.mSignInActivityView = signInActivityView;
    }

    SignInService(final SignInActivityView signInActivityView, HashMap<String, Object> mParams) {
        this.mSignInActivityView = signInActivityView;
        this.mParams = mParams;
    }

    void postSignIn() {
        final SignInRetrofitInterface signInRetrofitInterface = getRetrofit().create(SignInRetrofitInterface.class);
        signInRetrofitInterface.signInTest(mParams).enqueue(new Callback<SignInResponse>() {
            @Override
            public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {

                final SignInResponse signInResponse = response.body();
                if (signInResponse == null) {
                    mSignInActivityView.validateFailure(null);
                    return;
                }

                mSignInActivityView.signInSuccess(signInResponse);
            }

            @Override
            public void onFailure(Call<SignInResponse> call, Throwable t) {
                mSignInActivityView.validateFailure(null);
            }
        });
    }







    void getTest() {
        final SignInRetrofitInterface signInRetrofitInterface = getRetrofit().create(SignInRetrofitInterface.class);
        signInRetrofitInterface.getTest().enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                final DefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mSignInActivityView.validateFailure(null);
                    return;
                }

                mSignInActivityView.validateSuccess(defaultResponse.getMessage());
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                mSignInActivityView.validateFailure(null);
            }
        });
    }
}
