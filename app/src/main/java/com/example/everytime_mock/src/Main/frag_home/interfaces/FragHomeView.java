package com.example.everytime_mock.src.Main.frag_home.interfaces;

import com.example.everytime_mock.src.Main.frag_home.models.AdvertisementResponse;
import com.example.everytime_mock.src.Main.frag_home.models.HotPostResponse;
import com.example.everytime_mock.src.Main.frag_home.models.RealTimeHotPostResponse;
import com.example.everytime_mock.src.Main.frag_home.models.RecentLectureReviewResponse;

public interface FragHomeView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void advertisementSuccess(AdvertisementResponse advertisementResponse);

    void realTimeHotPostSuccess(RealTimeHotPostResponse realTimeHotPostResponse);

    void hotPostSuccess(HotPostResponse hotPostResponse);

    void recentLectureReviewSuccess(RecentLectureReviewResponse recentLectureReviewResponse);
}