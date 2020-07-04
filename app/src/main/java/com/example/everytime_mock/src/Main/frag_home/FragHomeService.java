package com.example.everytime_mock.src.Main.frag_home;

import com.example.everytime_mock.src.Main.frag_home.interfaces.FragHomeRetrofitInterface;
import com.example.everytime_mock.src.Main.frag_home.interfaces.FragHomeView;
import com.example.everytime_mock.src.Main.frag_home.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class FragHomeService {
    private final FragHomeView mFragHomeView;

    FragHomeService(final FragHomeView fragHomeView) {
        this.mFragHomeView = fragHomeView;
    }

//    void getTest() {
//        final FragHomeRetrofitInterface fragHomeRetrofitInterface = getRetrofit().create(FragHomeRetrofitInterface.class);
//        fragHomeRetrofitInterface.getTest().enqueue(new Callback<DefaultResponse>() {
//            @Override
//            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
//                final DefaultResponse defaultResponse = response.body();
//                if (defaultResponse == null) {
//                    mFragHomeView.validateFailure(null);
//                    return;
//                }
//
//                mFragHomeView.validateSuccess(defaultResponse.getMessage());
//            }
//
//            @Override
//            public void onFailure(Call<DefaultResponse> call, Throwable t) {
//                mFragHomeView.validateFailure(null);
//            }
//        });
//    }
}
