package com.example.everytime_mock.src.boards.interfaces;

import com.example.everytime_mock.src.boards.models.ReviewDetailResponse;
import com.example.everytime_mock.src.boards.models.ReviewResponse;

public interface LectureReviewInSubjectActivityView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void reviewSuccess(ReviewResponse reviewResponse);

    void reviewDetailSuccess(ReviewDetailResponse reviewDetailResponse);
}