package com.example.everytime_mock.src.Boards;

import com.example.everytime_mock.src.Boards.interfaces.LectureReviewInSubjectActivityView;
import com.example.everytime_mock.src.Boards.interfaces.LectureReviewRetrofitInterface;
import com.example.everytime_mock.src.Boards.models.ReviewDetailResponse;
import com.example.everytime_mock.src.Boards.models.ReviewResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class LectureReviewInSubjectService {
    private final LectureReviewInSubjectActivityView mLectureReviewInSubjectActivityView;

    LectureReviewInSubjectService(final LectureReviewInSubjectActivityView lectureReviewInSubjectActivityView) {
        this.mLectureReviewInSubjectActivityView = lectureReviewInSubjectActivityView;
    }

    void getReview() {
        final LectureReviewRetrofitInterface lectureReviewRetrofitInterface = getRetrofit().create(LectureReviewRetrofitInterface.class);
        lectureReviewRetrofitInterface.getReview(X_ACCESS_TOKEN).enqueue(new Callback<ReviewResponse>() {
            @Override
            public void onResponse(Call<ReviewResponse> call, Response<ReviewResponse> response) {
                final ReviewResponse reviewResponse = response.body();
                if (reviewResponse == null) {
                    mLectureReviewInSubjectActivityView.validateFailure(null);
                    return;
                }
                mLectureReviewInSubjectActivityView.reviewSuccess(reviewResponse);
            }

            @Override
            public void onFailure(Call<ReviewResponse> call, Throwable t) {
                mLectureReviewInSubjectActivityView.validateFailure(null);
            }
        });
    }

    void getReviewDetail(int index) {
        final LectureReviewRetrofitInterface lectureReviewRetrofitInterface = getRetrofit().create(LectureReviewRetrofitInterface.class);
        lectureReviewRetrofitInterface.getReviewDetail(X_ACCESS_TOKEN, index).enqueue(new Callback<ReviewDetailResponse>() {
            @Override
            public void onResponse(Call<ReviewDetailResponse> call, Response<ReviewDetailResponse> response) {
                final ReviewDetailResponse reviewDetailResponse = response.body();
                if (reviewDetailResponse == null) {
                    mLectureReviewInSubjectActivityView.validateFailure(null);
                    return;
                }
                mLectureReviewInSubjectActivityView.reviewDetailSuccess(reviewDetailResponse);
            }

            @Override
            public void onFailure(Call<ReviewDetailResponse> call, Throwable t) {
                mLectureReviewInSubjectActivityView.validateFailure(null);
            }
        });
    }


}

