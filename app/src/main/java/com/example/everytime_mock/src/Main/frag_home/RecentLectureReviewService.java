package com.example.everytime_mock.src.Main.frag_home;

import com.example.everytime_mock.src.Main.frag_home.interfaces.FragHomeRetrofitInterface;
import com.example.everytime_mock.src.Main.frag_home.interfaces.FragHomeView;
import com.example.everytime_mock.src.Main.frag_home.models.RecentLectureReviewResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class RecentLectureReviewService {
    private final FragHomeView mFragHomeView;

    RecentLectureReviewService(final FragHomeView fragHomeView) {
        this.mFragHomeView = fragHomeView;
    }

    void getRecentLectureReview() {
        final FragHomeRetrofitInterface fragHomeRetrofitInterface = getRetrofit().create(FragHomeRetrofitInterface.class);
        fragHomeRetrofitInterface.getRecentLectureReview(X_ACCESS_TOKEN).enqueue(new Callback<RecentLectureReviewResponse>() {
            @Override
            public void onResponse(Call<RecentLectureReviewResponse> call, Response<RecentLectureReviewResponse> response) {
                final RecentLectureReviewResponse recentLectureReviewResponse = response.body();
                if (recentLectureReviewResponse == null) {
                    mFragHomeView.validateFailure(null);
                    return;
                }
                mFragHomeView.recentLectureReviewSuccess(recentLectureReviewResponse);
            }

            @Override
            public void onFailure(Call<RecentLectureReviewResponse> call, Throwable t) {
                mFragHomeView.validateFailure(null);
            }
        });
    }
}
