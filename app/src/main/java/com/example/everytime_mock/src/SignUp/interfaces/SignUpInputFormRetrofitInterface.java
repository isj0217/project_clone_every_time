package com.example.everytime_mock.src.signup1_agreement.interfaces;

import com.example.everytime_mock.src.SignIn.models.DefaultResponse;
import com.example.everytime_mock.src.signup2_inputForms.models.SignUpBody;
import com.example.everytime_mock.src.signup2_inputForms.models.SignUpResponse;

import java.util.HashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SignUpInputFormRetrofitInterface {
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

    @POST("/user")
    Call<SignUpResponse> signUpTest(@Body HashMap<String, Object> params);
}
