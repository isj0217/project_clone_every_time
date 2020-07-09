package com.example.everytime_mock.src.main.interfaces;

import com.example.everytime_mock.src.boards.models.BoardResponse;
import com.example.everytime_mock.src.main.frag_home.models.RealTimeHotPostResponse;
import com.example.everytime_mock.src.main.frag_home.models.RecentLectureReviewResponse;

public interface InPostActivityView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void realtimeHotPostSuccess(RealTimeHotPostResponse realTimeHotPostResponse);

    void hotPostSuccess(BoardResponse hotBoardResponse);

    void recentLectureReviewSuccess(RecentLectureReviewResponse recentLectureReviewResponse);

    void freeBoardSuccess(BoardResponse boardResponse);

    void secretBoardSuccess(BoardResponse boardResponse);

    void alumniBoardSuccess(BoardResponse boardResponse);

    void freshmenBoardSuccess(BoardResponse boardResponse);

    void exactFreePostSuccess(BoardResponse boardResponse);
}