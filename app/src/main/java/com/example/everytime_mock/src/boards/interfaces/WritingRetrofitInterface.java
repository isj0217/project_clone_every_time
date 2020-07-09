package com.example.everytime_mock.src.boards.interfaces;

import com.example.everytime_mock.src.boards.models.WritingResponse;
import com.example.everytime_mock.src.signIn.models.DefaultResponse;
import com.example.everytime_mock.src.signIn.models.SignInResponse;

import java.util.HashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WritingRetrofitInterface {

    @POST("/login")
    Call<SignInResponse> signInTest(@Body HashMap<String, Object> params);

//    @POST("/notice/{noticeIdx}/content")
//    Call<WritingResponse> postWriting(@Body HashMap<String, Object> params);

    @POST("/notice/{noticeIdx}/content")
    Call<WritingResponse> postWriting(
            @Header("x-access-token")String accessToken,
            @Path("noticeIdx") int boardNumber,
            @Body HashMap<String, Object> params);

//    @POST("/notice/{noticeIdx}/content")
//    Call<WritingResponse> postWriting(
//            @Path("noticeIdx") int boardNumber
//    );


    //    @GET("/test")
    @GET("/jwt")
    Call<DefaultResponse> getTest();

    @GET("/test/{number}")
    Call<DefaultResponse> getTestPathAndQuery(
            @Path("number") int number,
            @Query("content") final String content
    );

    @POST("/test")
    Call<DefaultResponse> postTest(@Body RequestBody params);
}
