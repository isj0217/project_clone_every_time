package com.example.everytime_mock.src.Main.frag_home.interfaces;

import com.example.everytime_mock.src.Main.frag_home.models.HotPostResponse;
import com.example.everytime_mock.src.Main.frag_home.models.RealTimeHotPostResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FragHomeRetrofitInterface {
    //    @GET("/test")
    @GET("/jwt")
    Call<RealTimeHotPostResponse> getTest();

    // 실시간 인기글 조회
    @GET("/popular-content")
    Call<RealTimeHotPostResponse> getRealTimeHotPost(@Header("x-access-token")String accessToken);

    // HOT 게시물 조회
    @GET("/hot-content")
    Call<HotPostResponse> getHotPost(@Header("x-access-token")String accessToken);


    @GET("/test/{number}")
    Call<RealTimeHotPostResponse> getTestPathAndQuery(
            @Path("number") int number,
            @Query("content") final String content
//            @Header('X-ACCESS-TOKEN') final String
    );

    @POST("/test")
    Call<RealTimeHotPostResponse> postTest(@Body RequestBody params);
}
