package com.example.everytime_mock.src.boards.interfaces;

import com.example.everytime_mock.src.boards.models.recent_lecture_review_board.RecentLectureReviewBoardResponse;

public interface RecentLectureReviewBoardActivityView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void recentLectureReviewBoardSuccess(RecentLectureReviewBoardResponse recentLectureReviewBoardResponse);
}