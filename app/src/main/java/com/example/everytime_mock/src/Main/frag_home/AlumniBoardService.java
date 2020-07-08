package com.example.everytime_mock.src.Main.frag_home;

import com.example.everytime_mock.src.Boards.interfaces.AlumniBoardRetrofitInterface;
import com.example.everytime_mock.src.Boards.interfaces.FreeBoardRetrofitInterface;
import com.example.everytime_mock.src.Boards.models.BoardResponse;
import com.example.everytime_mock.src.Main.frag_home.interfaces.FragHomeView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class AlumniBoardService {
    private final FragHomeView mFragHomeView;

    AlumniBoardService(final FragHomeView fragHomeView) {
        this.mFragHomeView = fragHomeView;
    }

    void getFirstAlumniBoardPost() {
        final AlumniBoardRetrofitInterface alumniBoardRetrofitInterface = getRetrofit().create(AlumniBoardRetrofitInterface.class);
        alumniBoardRetrofitInterface.getAlumniBoard(X_ACCESS_TOKEN).enqueue(new Callback<BoardResponse>() {
            @Override
            public void onResponse(Call<BoardResponse> call, Response<BoardResponse> response) {
                final BoardResponse boardResponse = response.body();
                if (boardResponse == null) {
                    mFragHomeView.validateFailure(null);
                    return;
                }
                mFragHomeView.getAlumniBoardSuccess(boardResponse);
            }

            @Override
            public void onFailure(Call<BoardResponse> call, Throwable t) {
                mFragHomeView.validateFailure(null);
            }
        });
    }
}
