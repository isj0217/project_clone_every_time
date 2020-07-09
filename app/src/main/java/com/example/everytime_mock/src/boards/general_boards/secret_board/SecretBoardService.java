package com.example.everytime_mock.src.boards.general_boards.secret_board;

import com.example.everytime_mock.src.boards.interfaces.BoardActivityView;
import com.example.everytime_mock.src.boards.general_boards.secret_board.interfaces.SecretBoardRetrofitInterface;
import com.example.everytime_mock.src.boards.models.common_board.CommonBoardResponse;

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
        secretBoardRetrofitInterface.getSecretBoard(X_ACCESS_TOKEN).enqueue(new Callback<CommonBoardResponse>() {
            @Override
            public void onResponse(Call<CommonBoardResponse> call, Response<CommonBoardResponse> response) {
                final CommonBoardResponse commonBoardResponse = response.body();
                if (commonBoardResponse == null) {
                    mBoardActivityView.validateFailure(null);
                    return;
                }
                mBoardActivityView.boardSuccess(commonBoardResponse);
            }

            @Override
            public void onFailure(Call<CommonBoardResponse> call, Throwable t) {
                mBoardActivityView.validateFailure(null);
            }
        });
    }
}
