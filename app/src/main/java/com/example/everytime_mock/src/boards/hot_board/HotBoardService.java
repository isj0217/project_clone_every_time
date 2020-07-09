package com.example.everytime_mock.src.boards.hot_board;

import android.util.Log;

import com.example.everytime_mock.src.boards.interfaces.BoardActivityView;
import com.example.everytime_mock.src.boards.hot_board.interfaces.HotBoardRetrofitInterface;
import com.example.everytime_mock.src.boards.models.common_board.CommonBoardResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class HotBoardService {
    private final BoardActivityView mBoardActivityView;

    private static final String TAG = "HotBoardService";

    HotBoardService(final BoardActivityView boardActivityView) {
        this.mBoardActivityView = boardActivityView;
    }

    void getHotBoard() {
        final HotBoardRetrofitInterface hotBoardRetrofitInterface = getRetrofit().create(HotBoardRetrofitInterface.class);
        hotBoardRetrofitInterface.getHotBoard(X_ACCESS_TOKEN, "hot-content").enqueue(new Callback<CommonBoardResponse>() {
            @Override
            public void onResponse(Call<CommonBoardResponse> call, Response<CommonBoardResponse> response) {
                final CommonBoardResponse commonBoardResponse = response.body();
                if (commonBoardResponse == null) {
                    Log.d(TAG, "onResponse: onResponse 인데 실패");
                    mBoardActivityView.validateFailure(null);
                    return;
                }
                Log.d(TAG, "onResponse: 성공");
                mBoardActivityView.boardSuccess(commonBoardResponse);
            }

            @Override
            public void onFailure(Call<CommonBoardResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: 통신 실패");
                mBoardActivityView.validateFailure(null);
            }
        });
    }
}
