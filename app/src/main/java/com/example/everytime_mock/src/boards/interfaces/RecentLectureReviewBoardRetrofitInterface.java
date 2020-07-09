package com.example.everytime_mock.src.boards.interfaces;

import com.example.everytime_mock.src.boards.models.RecentLectureReviewBoardResponse;
import com.example.everytime_mock.src.main.models.DefaultResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RecentLectureReviewBoardRetrofitInterface {
    //    @GET("/test")
    @GET("/jwt")
    Call<DefaultResponse> getTest();

    @GET("/class-comment")
    Call<RecentLectureReviewBoardResponse> getRecentLectureReviewBoard(@Header("x-access-token") String accessToken);

    @GET("/test/{number}")
    Call<DefaultResponse> getTestPathAndQuery(
            @Path("number") int number,
            @Query("content") final String content
//            @Header('X-ACCESS-TOKEN') final String
    );

    @POST("/test")
    Call<DefaultResponse> postTest(@Body RequestBody params);
}
