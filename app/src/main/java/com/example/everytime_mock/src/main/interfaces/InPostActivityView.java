package com.example.everytime_mock.src.main.interfaces;

import com.example.everytime_mock.src.boards.models.common_board.CommonBoardResponse;
import com.example.everytime_mock.src.main.frag_home.models.RealTimeHotPostResponse;
import com.example.everytime_mock.src.main.frag_home.models.RecentLectureReviewResponse;

public interface InPostActivityView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void realtimeHotPostSuccess(RealTimeHotPostResponse realTimeHotPostResponse);

    void hotPostSuccess(CommonBoardResponse hotCommonBoardResponse);

    void recentLectureReviewSuccess(RecentLectureReviewResponse recentLectureReviewResponse);

    void freeBoardSuccess(CommonBoardResponse commonBoardResponse);

    void secretBoardSuccess(CommonBoardResponse commonBoardResponse);

    void alumniBoardSuccess(CommonBoardResponse commonBoardResponse);

    void freshmenBoardSuccess(CommonBoardResponse commonBoardResponse);

    void exactFreePostSuccess(CommonBoardResponse commonBoardResponse);

    void exactSecretPostSuccess(CommonBoardResponse commonBoardResponse);

    void exactAlumniPostSuccess(CommonBoardResponse commonBoardResponse);

    void exactFreshmenPostSuccess(CommonBoardResponse commonBoardResponse);
}