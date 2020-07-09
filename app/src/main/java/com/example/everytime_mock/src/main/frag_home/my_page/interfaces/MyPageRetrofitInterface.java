package com.example.everytime_mock.src.main.frag_home.my_page.interfaces;

import com.example.everytime_mock.src.main.frag_home.my_page.models.MyPageResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface MyPageRetrofitInterface {

    @GET("/user")
    Call<MyPageResponse> getMyPage(@Header("x-access-token")String accessToken);
}
