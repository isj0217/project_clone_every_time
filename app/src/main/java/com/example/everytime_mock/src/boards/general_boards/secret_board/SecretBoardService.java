package com.example.everytime_mock.src.boards.general_boards.secret_board;

import com.example.everytime_mock.src.boards.interfaces.BoardActivityView;
import com.example.everytime_mock.src.boards.general_boards.secret_board.interfaces.SecretBoardRetrofitInterface;
import com.example.everytime_mock.src.boards.models.BoardResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class SecretBoardService {
    private final BoardActivityView mBoardActivityView;

    SecretBoardService(final BoardActivityView boardActivityView) {
        this.mBoardActivityView = boardActivityView;
    }

    void getSecretBoard() {
        final SecretBoardRetrofitInterface secretBoardRetrofitInterface = getRetrofit().create(SecretBoardRetrofitInterface.class);
        secretBoardRetrofitInterface.getSecretBoard(X_ACCESS_TOKEN).enqueue(new Callback<BoardResponse>() {
            @Override
            public void onResponse(Call<BoardResponse> call, Response<BoardResponse> response) {
                final BoardResponse boardResponse = response.body();
                if (boardResponse == null) {
                    mBoardActivityView.validateFailure(null);
                    return;
                }
                mBoardActivityView.boardSuccess(boardResponse);
            }

            @Override
            public void onFailure(Call<BoardResponse> call, Throwable t) {
                mBoardActivityView.validateFailure(null);
            }
        });
    }
}
