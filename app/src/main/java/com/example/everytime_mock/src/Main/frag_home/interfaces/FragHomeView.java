package com.example.everytime_mock.src.Main.frag_home.interfaces;

import com.example.everytime_mock.src.Main.frag_home.models.HotPostResponse;
import com.example.everytime_mock.src.Main.frag_home.models.RealTimeHotPostResponse;

public interface FragHomeView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void realTimeHotPostSuccess(RealTimeHotPostResponse realTimeHotPostResponse);

    void hotPostSuccess(HotPostResponse hotPostResponse);
}