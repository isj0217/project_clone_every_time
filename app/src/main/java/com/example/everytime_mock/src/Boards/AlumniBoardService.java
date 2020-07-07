package com.example.everytime_mock.src.Boards;

import com.example.everytime_mock.src.Boards.interfaces.AlumniBoardRetrofitInterface;
import com.example.everytime_mock.src.Boards.interfaces.BoardActivityView;
import com.example.everytime_mock.src.Boards.models.BoardResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class AlumniBoardService {
    private final BoardActivityView mBboardActivityView;

    AlumniBoardService(final BoardActivityView boardActivityView) {
        this.mBboardActivityView = boardActivityView;
    }

    void getAlumniBoard() {
        final AlumniBoardRetrofitInterface alumniBoardRetrofitInterface = getRetrofit().create(AlumniBoardRetrofitInterface.class);
        alumniBoardRetrofitInterface.getAlumniBoard(X_ACCESS_TOKEN).enqueue(new Callback<BoardResponse>() {
            @Override
            public void onResponse(Call<BoardResponse> call, Response<BoardResponse> response) {
                final BoardResponse boardResponse = response.body();
                if (boardResponse == null) {
                    mBboardActivityView.validateFailure(null);
                    return;
                }
                mBboardActivityView.boardSuccess(boardResponse);
            }

            @Override
            public void onFailure(Call<BoardResponse> call, Throwable t) {
                mBboardActivityView.validateFailure(null);
            }
        });
    }
}
