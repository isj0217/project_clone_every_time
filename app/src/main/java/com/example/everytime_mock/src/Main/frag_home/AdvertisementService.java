package com.example.everytime_mock.src.Main.frag_home;

import com.example.everytime_mock.src.Main.frag_home.interfaces.FragHomeRetrofitInterface;
import com.example.everytime_mock.src.Main.frag_home.interfaces.FragHomeView;
import com.example.everytime_mock.src.Main.frag_home.models.AdvertisementResponse;
import com.example.everytime_mock.src.Main.frag_home.models.HotPostResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class AdvertisementService {
    private final FragHomeView mFragHomeView;

    AdvertisementService(final FragHomeView fragHomeView) {
        this.mFragHomeView = fragHomeView;
    }

    void getAdvertisement() {
        final FragHomeRetrofitInterface fragHomeRetrofitInterface = getRetrofit().create(FragHomeRetrofitInterface.class);
        fragHomeRetrofitInterface.getAdvertisement(X_ACCESS_TOKEN).enqueue(new Callback<AdvertisementResponse>() {
            @Override
            public void onResponse(Call<AdvertisementResponse> call, Response<AdvertisementResponse> response) {
                final AdvertisementResponse advertisementResponse = response.body();
                if (advertisementResponse == null) {
                    mFragHomeView.validateFailure(null);
                    return;
                }
                mFragHomeView.advertisementSuccess(advertisementResponse);
            }

            @Override
            public void onFailure(Call<AdvertisementResponse> call, Throwable t) {
                mFragHomeView.validateFailure(null);
            }
        });
    }
}
