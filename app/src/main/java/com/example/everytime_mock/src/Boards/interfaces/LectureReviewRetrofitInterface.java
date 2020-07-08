package com.example.everytime_mock.src.Boards.interfaces;

import com.example.everytime_mock.src.Boards.models.BoardResponse;
import com.example.everytime_mock.src.Main.frag_home.models.HotPostResponse;
import com.example.everytime_mock.src.Main.frag_home.models.RealTimeHotPostResponse;
import com.example.everytime_mock.src.Main.frag_home.models.RecentLectureReviewResponse;
import com.example.everytime_mock.src.Main.models.DefaultResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface InPostRetrofitInterface {

    // 실시간 인기글 조회
    @GET("/popular-content")
    Call<RealTimeHotPostResponse> getRealTimeHotPost(@Header("x-access-token")String accessToken);

//    // HOT 게시물 조회
//    @GET("notice/contents?")
//    Call<BoardResponse> getHotPost(@Header("x-access-token")String accessToken);

    // HOT 게시물 게시판 조회
    @GET("/notice/contents?")
    Call<BoardResponse> getHotBoard(
            @Header("x-access-token") String accessToken,
            @Query("choice") String choice);

    // 최근 강의평 조회
    @GET("/new-class-comment")
    Call<RecentLectureReviewResponse> getRecentLectureReview(@Header("x-access-token")String accessToken);
}
