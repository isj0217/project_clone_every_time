package com.example.everytime_mock.src.boards.interfaces;

import com.example.everytime_mock.src.boards.models.review_detail.ReviewDetailResponse;
import com.example.everytime_mock.src.boards.models.review.ReviewResponse;

public interface LectureReviewInSubjectActivityView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void reviewSuccess(ReviewResponse reviewResponse);

    void reviewDetailSuccess(ReviewDetailResponse reviewDetailResponse);
}