package com.example.everytime_mock.src.Boards;

import android.util.Log;

import com.example.everytime_mock.src.Boards.interfaces.BoardActivityView;
import com.example.everytime_mock.src.Boards.interfaces.HotBoardRetrofitInterface;
import com.example.everytime_mock.src.Boards.interfaces.InPostRetrofitInterface;
import com.example.everytime_mock.src.Boards.models.BoardResponse;
import com.example.everytime_mock.src.Main.frag_home.models.HotPostResponse;
import com.example.everytime_mock.src.Main.frag_home.models.RealTimeHotPostResponse;
import com.example.everytime_mock.src.Main.frag_home.models.RecentLectureReviewResponse;
import com.example.everytime_mock.src.Main.interfaces.InPostActivityView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class InPostService {
    private final InPostActivityView mInPostActivityView;

    InPostService(final InPostActivityView inPostActivityView) {
        this.mInPostActivityView = inPostActivityView;
    }

    void getRealTimeHotBoard() {
        final InPostRetrofitInterface inPostRetrofitInterface = getRetrofit().create(InPostRetrofitInterface.class);
        inPostRetrofitInterface.getRealTimeHotPost(X_ACCESS_TOKEN).enqueue(new Callback<RealTimeHotPostResponse>() {
            @Override
            public void onResponse(Call<RealTimeHotPostResponse> call, Response<RealTimeHotPostResponse> response) {
                final RealTimeHotPostResponse realTimeHotPostResponse = response.body();
                if (realTimeHotPostResponse == null) {
                    mInPostActivityView.validateFailure(null);
                    return;
                }
                mInPostActivityView.realtimeHotPostSuccess(realTimeHotPostResponse);
            }

            @Override
            public void onFailure(Call<RealTimeHotPostResponse> call, Throwable t) {
                mInPostActivityView.validateFailure(null);
            }
        });
    }

    void getHotBoard() {
        final InPostRetrofitInterface inPostRetrofitInterface = getRetrofit().create(InPostRetrofitInterface.class);
        inPostRetrofitInterface.getHotBoard(X_ACCESS_TOKEN, "hot-content").enqueue(new Callback<BoardResponse>() {
            @Override
            public void onResponse(Call<BoardResponse> call, Response<BoardResponse> response) {
                final BoardResponse boardResponse = response.body();
                if (boardResponse == null) {
                    mInPostActivityView.validateFailure(null);
                    return;
                }
                mInPostActivityView.hotPostSuccess(boardResponse);
            }

            @Override
            public void onFailure(Call<BoardResponse> call, Throwable t) {
                mInPostActivityView.validateFailure(null);
            }
        });
    }

    void getRecentLectureReview() {
        final InPostRetrofitInterface inPostRetrofitInterface = getRetrofit().create(InPostRetrofitInterface.class);
        inPostRetrofitInterface.getRecentLectureReview(X_ACCESS_TOKEN).enqueue(new Callback<RecentLectureReviewResponse>() {
            @Override
            public void onResponse(Call<RecentLectureReviewResponse> call, Response<RecentLectureReviewResponse> response) {
                final RecentLectureReviewResponse recentLectureReviewResponse = response.body();
                if (recentLectureReviewResponse == null) {
                    mInPostActivityView.validateFailure(null);
                    return;
                }
                mInPostActivityView.recentLectureReviewSuccess(recentLectureReviewResponse);
            }

            @Override
            public void onFailure(Call<RecentLectureReviewResponse> call, Throwable t) {
                mInPostActivityView.validateFailure(null);
            }
        });
    }
}
