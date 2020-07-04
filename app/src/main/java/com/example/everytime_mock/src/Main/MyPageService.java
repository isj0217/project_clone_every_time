package com.example.everytime_mock.src.Main.models;

import com.example.everytime_mock.src.Main.interfaces.MyPageActivityView;
import com.example.everytime_mock.src.SignUp.interfaces.SignUpInputFormActivityView;
import com.example.everytime_mock.src.SignUp.interfaces.SignUpInputFormRetrofitInterface;
import com.example.everytime_mock.src.SignUp.models.SignUpResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class MyPageService {
    private final MyPageActivityView mMyPageActivityView;
    private HashMap<String, Object> mParams;

    MyPageService(final MyPageActivityView myPageActivityView) {
        this.mMyPageActivityView = myPageActivityView;
    }

    MyPageService(final MyPageActivityView myPageActivityView, HashMap<String, Object> mParams) {
        this.mMyPageActivityView = myPageActivityView;
        this.mParams = mParams;
    }

    void getMyPage() {
        final SignUpInputFormRetrofitInterface signUpInputForms_retrofitInterface = getRetrofit().create(SignUpInputFormRetrofitInterface.class);
        signUpInputForms_retrofitInterface.signUpTest(mParams).enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {

                final SignUpResponse signUpResponse = response.body();
                if (signUpResponse == null) {
                    mMyPageActivityView.validateFailure(null);
                    return;
                }

                mMyPageActivityView.signUpSuccess(signUpResponse);
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                mMyPageActivityView.validateFailure(null);
            }
        });
    }
}
