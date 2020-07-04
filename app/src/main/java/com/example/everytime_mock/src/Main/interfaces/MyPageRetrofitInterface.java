package com.example.everytime_mock.src.Main.interfaces;

import com.example.everytime_mock.src.Main.models.MyPageResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyPageRetrofitInterface {

    @GET("/user")
    Call<MyPageResponse> getMyPage(@Header("x-access-token")String accessToken);
}
