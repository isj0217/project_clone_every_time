package com.example.everytime_mock.src.signup2_inputForms;

import com.example.everytime_mock.src.main.interfaces.MainRetrofitInterface;
import com.example.everytime_mock.src.main.models.DefaultResponse;
import com.example.everytime_mock.src.signup2_inputForms.interfaces.SignupActivity_2_View;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class Signup_2_Service {
    private final SignupActivity_2_View mSignupActivity_2_View;

    Signup_2_Service(final SignupActivity_2_View signupActivity_2_view) {
        this.mSignupActivity_2_View = signupActivity_2_view;
    }

    void getTest() {
        final MainRetrofitInterface mainRetrofitInterface = getRetrofit().create(MainRetrofitInterface.class);
        mainRetrofitInterface.getTest().enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                final DefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mSignupActivity_2_View.validateFailure(null);
                    return;
                }

                mSignupActivity_2_View.validateSuccess(defaultResponse.getMessage());
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                mSignupActivity_2_View.validateFailure(null);
            }
        });
    }
}
