package com.example.everytime_mock.src.Main.frag_home.interfaces;

import com.example.everytime_mock.src.Main.frag_home.models.FragHomeResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FragHomeRetrofitInterface {
    //    @GET("/test")
    @GET("/jwt")
    Call<FragHomeResponse> getTest();

    @GET("/test/{number}")
    Call<FragHomeResponse> getTestPathAndQuery(
            @Path("number") int number,
            @Query("content") final String content
//            @Header('X-ACCESS-TOKEN') final String
    );

    @POST("/test")
    Call<FragHomeResponse> postTest(@Body RequestBody params);
}
