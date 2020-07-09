package com.example.everytime_mock.src.boards.board_free;

import android.util.Log;

import com.example.everytime_mock.src.boards.interfaces.BoardActivityView;
import com.example.everytime_mock.src.boards.interfaces.FreeBoardRetrofitInterface;
import com.example.everytime_mock.src.boards.models.BoardResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class FreeBoardService {
    private final BoardActivityView mBoardActivityView;

    private static final String TAG = "FreeBoardService";

    FreeBoardService(final BoardActivityView boardActivityView) {
        this.mBoardActivityView = boardActivityView;
    }

    void getFreeBoard() {
        final FreeBoardRetrofitInterface freeBoardRetrofitInterface = getRetrofit().create(FreeBoardRetrofitInterface.class);
        freeBoardRetrofitInterface.getFreeBoard(X_ACCESS_TOKEN).enqueue(new Callback<BoardResponse>() {
            @Override
            public void onResponse(Call<BoardResponse> call, Response<BoardResponse> response) {
                final BoardResponse boardResponse = response.body();
                if (boardResponse == null) {
                    Log.d(TAG, "onResponse: validateFailure");
                    mBoardActivityView.validateFailure(null);
                    return;
                }

                Log.d(TAG, "onResponse: 성공");
                mBoardActivityView.boardSuccess(boardResponse);
            }

            @Override
            public void onFailure(Call<BoardResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: onFailure");
                mBoardActivityView.validateFailure(null);
            }
        });
    }
}
