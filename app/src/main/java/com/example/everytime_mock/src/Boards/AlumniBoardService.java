package com.example.everytime_mock.src.Boards;

import android.util.Log;

import com.example.everytime_mock.src.Boards.interfaces.FreeBoardActivityView;
import com.example.everytime_mock.src.Boards.interfaces.FreeBoardRetrofitInterface;
import com.example.everytime_mock.src.Boards.interfaces.SecretBoardActivityView;
import com.example.everytime_mock.src.Boards.interfaces.SecretBoardRetrofitInterface;
import com.example.everytime_mock.src.Boards.models.FreeBoardResponse;
import com.example.everytime_mock.src.Boards.models.SecretBoardResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class SecretBoardService {
    private final SecretBoardActivityView mSecretBoardActivityView;

    SecretBoardService(final SecretBoardActivityView secretBoardActivityView) {
        this.mSecretBoardActivityView = secretBoardActivityView;
    }

    void getSecretBoard() {
        final SecretBoardRetrofitInterface secretBoardRetrofitInterface = getRetrofit().create(SecretBoardRetrofitInterface.class);
        secretBoardRetrofitInterface.getSecretBoard(X_ACCESS_TOKEN).enqueue(new Callback<SecretBoardResponse>() {
            @Override
            public void onResponse(Call<SecretBoardResponse> call, Response<SecretBoardResponse> response) {
                final SecretBoardResponse secretBoardResponse = response.body();
                if (secretBoardResponse == null) {
                    mSecretBoardActivityView.validateFailure(null);
                    return;
                }
                mSecretBoardActivityView.secretBoardSuccess(secretBoardResponse);
            }

            @Override
            public void onFailure(Call<SecretBoardResponse> call, Throwable t) {
                mSecretBoardActivityView.validateFailure(null);
            }
        });
    }
}
