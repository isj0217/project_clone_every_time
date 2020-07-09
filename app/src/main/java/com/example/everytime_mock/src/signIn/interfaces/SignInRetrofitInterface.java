package com.example.everytime_mock.src.SignIn.interfaces;

import com.example.everytime_mock.src.SignIn.models.DefaultResponse;
import com.example.everytime_mock.src.SignIn.models.SignInBody;
import com.example.everytime_mock.src.SignIn.models.SignInResponse;

import java.util.HashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SignInRetrofitInterface {

    @POST("/login")
    Call<SignInResponse> signInTest(@Body HashMap<String, Object> params);



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
