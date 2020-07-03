package com.example.everytime_mock.src.Home;

import com.example.everytime_mock.src.Home.interfaces.HomeActivityView;
import com.example.everytime_mock.src.Home.interfaces.HomeRetrofitInterface;
import com.example.everytime_mock.src.SignIn.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class HomeService {
    private final HomeActivityView mHomeActivityView;

    HomeService(final HomeActivityView homeActivityView) {
        this.mHomeActivityView = homeActivityView;
    }

    void getTest() {
        final HomeRetrofitInterface homeRetrofitInterface = getRetrofit().create(HomeRetrofitInterface.class);
        homeRetrofitInterface.getTest().enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                final DefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mHomeActivityView.validateFailure(null);
                    return;
                }

                mHomeActivityView.validateSuccess(defaultResponse.getMessage());
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                mHomeActivityView.validateFailure(null);
            }
        });
    }
}
