package com.example.everytime_mock.src.boards.general_boards.freshmen_board;

import com.example.everytime_mock.src.boards.interfaces.BoardActivityView;
import com.example.everytime_mock.src.boards.general_boards.freshmen_board.interfaces.FreshmenBoardRetrofitInterface;
import com.example.everytime_mock.src.boards.models.BoardResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class FreshmenBoardService {
    private final BoardActivityView mBoardActivityView;

    FreshmenBoardService(final BoardActivityView boardActivityView) {
        this.mBoardActivityView = boardActivityView;
    }

    void getFreshmenBoard() {
        final FreshmenBoardRetrofitInterface freshmenBoardRetrofitInterface = getRetrofit().create(FreshmenBoardRetrofitInterface.class);
        freshmenBoardRetrofitInterface.getFreshmenBoard(X_ACCESS_TOKEN).enqueue(new Callback<BoardResponse>() {
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
