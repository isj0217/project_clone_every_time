package com.example.everytime_mock.src.Boards.interfaces;

import com.example.everytime_mock.src.Boards.models.BoardResponse;
import com.example.everytime_mock.src.Boards.models.ReviewResponse;

public interface LectureReviewInSubjectActivityView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void ReviewSuccess(ReviewResponse reviewResponse);
}