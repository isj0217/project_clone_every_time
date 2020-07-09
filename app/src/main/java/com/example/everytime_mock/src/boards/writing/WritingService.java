package com.example.everytime_mock.src.boards.writing;

import com.example.everytime_mock.src.boards.interfaces.WritingActivityView;
import com.example.everytime_mock.src.boards.interfaces.WritingRetrofitInterface;
import com.example.everytime_mock.src.boards.models.writing.WritingResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class WritingService {
    private final WritingActivityView mWritingActivityView;
    private HashMap<String, Object> mParams;
    private int board_number;

    public WritingService(WritingActivityView mWritingActivityView, int board_number ,HashMap<String, Object> mParams) {
        this.board_number = board_number;
        this.mWritingActivityView = mWritingActivityView;
        this.mParams = mParams;
    }

    void postWriting() {
        final WritingRetrofitInterface writingRetrofitInterface = getRetrofit().create(WritingRetrofitInterface.class);
        writingRetrofitInterface.postWriting(X_ACCESS_TOKEN, board_number, mParams).enqueue(new Callback<WritingResponse>() {
            @Override
            public void onResponse(Call<WritingResponse> call, Response<WritingResponse> response) {
                final WritingResponse writingResponse = response.body();
                if (writingResponse == null) {
                    mWritingActivityView.validateFailure(null);
                    return;
                }

                mWritingActivityView.WritingSuccess(writingResponse);
            }

            @Override
            public void onFailure(Call<WritingResponse> call, Throwable t) {
                mWritingActivityView.validateFailure(null);
            }
        });
    }
}
