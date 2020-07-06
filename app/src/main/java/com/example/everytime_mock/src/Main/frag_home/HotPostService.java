package com.example.everytime_mock.src.Main.frag_home;

import com.example.everytime_mock.src.Main.frag_home.interfaces.FragHomeRetrofitInterface;
import com.example.everytime_mock.src.Main.frag_home.interfaces.FragHomeView;
import com.example.everytime_mock.src.Main.frag_home.models.HotPostResponse;
import com.example.everytime_mock.src.Main.frag_home.models.RealTimeHotPostResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class HotPostService {
    private final FragHomeView mFragHomeView;

    HotPostService(final FragHomeView fragHomeView) {
        this.mFragHomeView = fragHomeView;
    }

    void getHotPost() {
        final FragHomeRetrofitInterface fragHomeRetrofitInterface = getRetrofit().create(FragHomeRetrofitInterface.class);
        fragHomeRetrofitInterface.getHotPost(X_ACCESS_TOKEN).enqueue(new Callback<HotPostResponse>() {
            @Override
            public void onResponse(Call<HotPostResponse> call, Response<HotPostResponse> response) {
                final HotPostResponse hotPostResponse = response.body();
                if (hotPostResponse == null) {
                    mFragHomeView.validateFailure(null);
                    return;
                }
                mFragHomeView.hotPostSuccess(hotPostResponse);
            }

            @Override
            public void onFailure(Call<HotPostResponse> call, Throwable t) {
                mFragHomeView.validateFailure(null);
            }
        });
    }
}
