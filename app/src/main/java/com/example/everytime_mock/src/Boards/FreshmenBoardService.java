package com.example.everytime_mock.src.Boards;

import com.example.everytime_mock.src.Boards.interfaces.AlumniBoardActivityView;
import com.example.everytime_mock.src.Boards.interfaces.AlumniBoardRetrofitInterface;
import com.example.everytime_mock.src.Boards.interfaces.SecretBoardActivityView;
import com.example.everytime_mock.src.Boards.interfaces.SecretBoardRetrofitInterface;
import com.example.everytime_mock.src.Boards.models.AlumniBoardResponse;
import com.example.everytime_mock.src.Boards.models.SecretBoardResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class AlumniBoardService {
    private final AlumniBoardActivityView mAlumniBoardActivityView;

    AlumniBoardService(final AlumniBoardActivityView alumniBoardActivityView) {
        this.mAlumniBoardActivityView = alumniBoardActivityView;
    }

    void getAlumniBoard() {
        final AlumniBoardRetrofitInterface alumniBoardRetrofitInterface = getRetrofit().create(AlumniBoardRetrofitInterface.class);
        alumniBoardRetrofitInterface.getAlumniBoard(X_ACCESS_TOKEN).enqueue(new Callback<AlumniBoardResponse>() {
            @Override
            public void onResponse(Call<AlumniBoardResponse> call, Response<AlumniBoardResponse> response) {
                final AlumniBoardResponse alumniBoardResponse = response.body();
                if (alumniBoardResponse == null) {
                    mAlumniBoardActivityView.validateFailure(null);
                    return;
                }
                mAlumniBoardActivityView.alumniBoardSuccess(alumniBoardResponse);
            }

            @Override
            public void onFailure(Call<AlumniBoardResponse> call, Throwable t) {
                mAlumniBoardActivityView.validateFailure(null);
            }
        });
    }
}
