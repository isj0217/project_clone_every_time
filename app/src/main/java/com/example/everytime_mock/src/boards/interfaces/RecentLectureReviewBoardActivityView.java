package com.example.everytime_mock.src.Boards.interfaces;

import com.example.everytime_mock.src.Boards.models.BoardResponse;
import com.example.everytime_mock.src.Boards.models.RecentLectureReviewBoardResponse;

public interface RecentLectureReviewBoardActivityView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void recentLectureReviewBoardSuccess(RecentLectureReviewBoardResponse recentLectureReviewBoardResponse);
}