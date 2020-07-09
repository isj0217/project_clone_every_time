package com.example.everytime_mock.src.Boards.interfaces;

import com.example.everytime_mock.src.Boards.models.BoardResponse;
import com.example.everytime_mock.src.Boards.models.RecentLectureReviewBoardResponse;
import com.example.everytime_mock.src.Boards.models.ReviewDetailResponse;
import com.example.everytime_mock.src.Boards.models.ReviewResponse;
import com.example.everytime_mock.src.Main.frag_home.models.RealTimeHotPostResponse;
import com.example.everytime_mock.src.Main.frag_home.models.RecentLectureReviewResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LectureReviewRetrofitInterface {

    // 실시간 인기글 조회
    @GET("/popular-content")
    Call<RealTimeHotPostResponse> getRealTimeHotPost(@Header("x-access-token") String accessToken);

//    // HOT 게시물 조회
//    @GET("notice/contents?")
//    Call<BoardResponse> getHotPost(@Header("x-access-token")String accessToken);

    // HOT 게시물 게시판 조회
    @GET("/notice/contents?")
    Call<BoardResponse> getHotBoard(
            @Header("x-access-token") String accessToken,
            @Query("choice") String choice);

    @GET("/class-comment")
    Call<ReviewResponse> getReview(@Header("x-access-token") String accessToken);

    @GET("/class/{classIdx}/class-comment")
    Call<ReviewDetailResponse> getReviewDetail(@Header("x-access-token") String accessToken,
                                               @Path("classIdx") int classIdx);

    // 최근 강의평 조회
    @GET("/new-class-comment")
    Call<RecentLectureReviewResponse> getRecentLectureReview(@Header("x-access-token") String accessToken);
}
