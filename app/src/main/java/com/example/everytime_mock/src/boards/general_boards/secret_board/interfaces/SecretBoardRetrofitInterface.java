package com.example.everytime_mock.src.boards.general_boards.secret_board.interfaces;

import com.example.everytime_mock.src.boards.models.BoardResponse;
import com.example.everytime_mock.src.main.models.DefaultResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SecretBoardRetrofitInterface {
    //    @GET("/test")
    @GET("/jwt")
    Call<DefaultResponse> getTest();

    @GET("/notice/2/contents")
    Call<BoardResponse> getSecretBoard(@Header("x-access-token") String accessToken);

    @GET("/test/{number}")
    Call<DefaultResponse> getTestPathAndQuery(
            @Path("number") int number,
            @Query("content") final String content
//            @Header('X-ACCESS-TOKEN') final String
    );

    @POST("/test")
    Call<DefaultResponse> postTest(@Body RequestBody params);
}
