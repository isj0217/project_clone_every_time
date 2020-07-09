package com.example.everytime_mock.src.main.frag_board;

import com.example.everytime_mock.src.main.frag_board.interfaces.FragBoardRetrofitInterface;
import com.example.everytime_mock.src.main.frag_board.interfaces.FragBoardView;
import com.example.everytime_mock.src.main.frag_board.models.FavoriteBoardResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class FragBoardService {
    private final FragBoardView mFragBoardView;
    private HashMap<String, Object> mParams;

    FragBoardService(final FragBoardView fragBoardView) {
        this.mFragBoardView = fragBoardView;
    }

    FragBoardService(final FragBoardView fragBoardView, HashMap<String, Object> mParams) {
        this.mFragBoardView = fragBoardView;
        this.mParams = mParams;
    }

    void postFavoriteBoard(int index_of_board) {
        final FragBoardRetrofitInterface fragBoardRetrofitInterface = getRetrofit().create(FragBoardRetrofitInterface.class);
        fragBoardRetrofitInterface.postFavoriteBoard(X_ACCESS_TOKEN, index_of_board).enqueue(new Callback<FavoriteBoardResponse>() {
            @Override
            public void onResponse(Call<FavoriteBoardResponse> call, Response<FavoriteBoardResponse> response) {
                final FavoriteBoardResponse favoriteBoardResponse = response.body();
                if (favoriteBoardResponse == null) {
                    mFragBoardView.validateFailure(null);
                    return;
                }
                mFragBoardView.favoriteBoardSuccess(favoriteBoardResponse);
            }

            @Override
            public void onFailure(Call<FavoriteBoardResponse> call, Throwable t) {
                mFragBoardView.validateFailure(null);
            }
        });
    }
}
