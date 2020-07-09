package com.example.everytime_mock.src.boards.general_boards.free_board;

import android.util.Log;

import com.example.everytime_mock.src.boards.interfaces.BoardActivityView;
import com.example.everytime_mock.src.boards.general_boards.free_board.interfaces.FreeBoardRetrofitInterface;
import com.example.everytime_mock.src.boards.models.common_board.CommonBoardResponse;

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
        freeBoardRetrofitInterface.getFreeBoard(X_ACCESS_TOKEN).enqueue(new Callback<CommonBoardResponse>() {
            @Override
            public void onResponse(Call<CommonBoardResponse> call, Response<CommonBoardResponse> response) {
                final CommonBoardResponse commonBoardResponse = response.body();
                if (commonBoardResponse == null) {
                    Log.d(TAG, "onResponse: validateFailure");
                    mBoardActivityView.validateFailure(null);
                    return;
                }

                Log.d(TAG, "onResponse: 성공");
                mBoardActivityView.boardSuccess(commonBoardResponse);
            }

            @Override
            public void onFailure(Call<CommonBoardResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: onFailure");
                mBoardActivityView.validateFailure(null);
            }
        });
    }
}
