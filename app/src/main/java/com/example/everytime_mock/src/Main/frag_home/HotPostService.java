package com.example.everytime_mock.src.Main.frag_home;

import com.example.everytime_mock.src.Main.frag_home.interfaces.FragHomeRetrofitInterface;
import com.example.everytime_mock.src.Main.frag_home.interfaces.FragHomeView;
import com.example.everytime_mock.src.Main.frag_home.models.RealTimeHotPostResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class RealTimeHotPostService {
    private final FragHomeView mFragHomeView;

    RealTimeHotPostService(final FragHomeView fragHomeView) {
        this.mFragHomeView = fragHomeView;
    }

    void getRealTimeHotPost() {
        final FragHomeRetrofitInterface fragHomeRetrofitInterface = getRetrofit().create(FragHomeRetrofitInterface.class);
        fragHomeRetrofitInterface.getRealTimeHotPost(X_ACCESS_TOKEN).enqueue(new Callback<RealTimeHotPostResponse>() {
            @Override
            public void onResponse(Call<RealTimeHotPostResponse> call, Response<RealTimeHotPostResponse> response) {
                final RealTimeHotPostResponse realTimeHotPostResponse = response.body();
                if (realTimeHotPostResponse == null) {
                    mFragHomeView.validateFailure(null);
                    return;
                }
                mFragHomeView.RealTimeHotPostSuccess(realTimeHotPostResponse);
            }

            @Override
            public void onFailure(Call<RealTimeHotPostResponse> call, Throwable t) {
                mFragHomeView.validateFailure(null);
            }
        });
    }
}
