package com.example.everytime_mock.src.Boards;

import android.util.Log;

import com.example.everytime_mock.src.Boards.interfaces.BoardActivityView;
import com.example.everytime_mock.src.Boards.interfaces.RecentLectureReviewBoardActivityView;
import com.example.everytime_mock.src.Boards.interfaces.RecentLectureReviewBoardRetrofitInterface;
import com.example.everytime_mock.src.Boards.interfaces.SecretBoardRetrofitInterface;
import com.example.everytime_mock.src.Boards.models.BoardResponse;
import com.example.everytime_mock.src.Boards.models.RecentLectureReviewBoardResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class RecentLectureReviewBoardService {
    private static final String TAG = "RecentLectureReviewBoar";
    private final RecentLectureReviewBoardActivityView mRecentLectureReviewBoardActivityView;

    RecentLectureReviewBoardService(final RecentLectureReviewBoardActivityView recentLectureReviewBoardActivityView) {
        this.mRecentLectureReviewBoardActivityView = recentLectureReviewBoardActivityView;
    }

    void getRecentLectureReviewBoard() {
        final RecentLectureReviewBoardRetrofitInterface recentLectureReviewBoardRetrofitInterface = getRetrofit().create(RecentLectureReviewBoardRetrofitInterface.class);
        recentLectureReviewBoardRetrofitInterface.getRecentLectureReviewBoard(X_ACCESS_TOKEN).enqueue(new Callback<RecentLectureReviewBoardResponse>() {
            @Override
            public void onResponse(Call<RecentLectureReviewBoardResponse> call, Response<RecentLectureReviewBoardResponse> response) {
                final RecentLectureReviewBoardResponse recentLectureReviewBoardResponse = response.body();
                if (recentLectureReviewBoardResponse == null) {
                    Log.d(TAG, "onResponse: onResponse지만 실패");
                    mRecentLectureReviewBoardActivityView.validateFailure(null);
                    return;
                }
                Log.d(TAG, "onResponse: 성공");
                mRecentLectureReviewBoardActivityView.recentLectureReviewBoardSuccess(recentLectureReviewBoardResponse);
            }

            @Override
            public void onFailure(Call<RecentLectureReviewBoardResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: 통신실패");
                mRecentLectureReviewBoardActivityView.validateFailure(null);
            }
        });
    }
}
