package com.example.everytime_mock.src.main.frag_board.interfaces;

import com.example.everytime_mock.src.main.frag_board.models.FavoriteBoardResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface FragBoardRetrofitInterface {

    @POST("/my-notice")
    Call<FavoriteBoardResponse> postFavoriteBoard(@Header("x-access-token") String accessToken,
                                                  @Body int index_of_board);

}

