package com.example.everytime_mock.src.Boards;

import android.util.Log;

import com.example.everytime_mock.src.Boards.interfaces.FreeBoardActivityView;
import com.example.everytime_mock.src.Boards.interfaces.FreeBoardRetrofitInterface;
import com.example.everytime_mock.src.Boards.models.FreeBoardResponse;
import com.example.everytime_mock.src.Main.interfaces.MainActivityView;
import com.example.everytime_mock.src.Main.interfaces.MainRetrofitInterface;
import com.example.everytime_mock.src.Main.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class FreeBoardService {
    private final FreeBoardActivityView mFreeBoardActivityView;

    private static final String TAG = "FreeBoardService";

    FreeBoardService(final FreeBoardActivityView freeBoardActivityView) {
        this.mFreeBoardActivityView = freeBoardActivityView;
    }

    void getFreeBoard() {
        final FreeBoardRetrofitInterface freeBoardRetrofitInterface = getRetrofit().create(FreeBoardRetrofitInterface.class);
        freeBoardRetrofitInterface.getFreeBoard(X_ACCESS_TOKEN).enqueue(new Callback<FreeBoardResponse>() {
            @Override
            public void onResponse(Call<FreeBoardResponse> call, Response<FreeBoardResponse> response) {
                final FreeBoardResponse freeBoardResponse = response.body();
                if (freeBoardResponse == null) {
                    Log.d(TAG, "onResponse: validateFailure");
                    mFreeBoardActivityView.validateFailure(null);
                    return;
                }

                Log.d(TAG, "onResponse: 성공");
                mFreeBoardActivityView.freeBoardSuccess(freeBoardResponse);
            }

            @Override
            public void onFailure(Call<FreeBoardResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: onFailure");
                mFreeBoardActivityView.validateFailure(null);
            }
        });
    }
}
