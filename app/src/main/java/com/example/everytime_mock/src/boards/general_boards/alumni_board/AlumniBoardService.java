package com.example.everytime_mock.src.boards.general_boards.alumni_board;

import com.example.everytime_mock.src.boards.general_boards.alumni_board.interfaces.AlumniBoardRetrofitInterface;
import com.example.everytime_mock.src.boards.interfaces.BoardActivityView;
import com.example.everytime_mock.src.boards.models.common_board.CommonBoardResponse;

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
        alumniBoardRetrofitInterface.getAlumniBoard(X_ACCESS_TOKEN).enqueue(new Callback<CommonBoardResponse>() {
            @Override
            public void onResponse(Call<CommonBoardResponse> call, Response<CommonBoardResponse> response) {
                final CommonBoardResponse commonBoardResponse = response.body();
                if (commonBoardResponse == null) {
                    mBboardActivityView.validateFailure(null);
                    return;
                }
                mBboardActivityView.boardSuccess(commonBoardResponse);
            }

            @Override
            public void onFailure(Call<CommonBoardResponse> call, Throwable t) {
                mBboardActivityView.validateFailure(null);
            }
        });
    }
}
