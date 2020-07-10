package com.example.everytime_mock.src.main.frag_home.interfaces;

import com.example.everytime_mock.src.boards.models.common_board.CommonBoardResponse;
import com.example.everytime_mock.src.main.frag_home.models.AdvertisementResponse;
import com.example.everytime_mock.src.main.frag_home.models.HotPostResponse;
import com.example.everytime_mock.src.main.frag_home.models.RealTimeHotPostResponse;
import com.example.everytime_mock.src.main.frag_home.models.RecentLectureReviewResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FragHomeRetrofitInterface {
    //    @GET("/test")
    @GET("/jwt")
    Call<RealTimeHotPostResponse> getTest();

    @GET("/ads")
    Call<AdvertisementResponse> getAdvertisement(@Header("x-access-token")String accessToken);

    // 실시간 인기글 조회
    @GET("/popular-content")
    Call<RealTimeHotPostResponse> getRealTimeHotPost(@Header("x-access-token")String accessToken);

    // HOT 게시물 조회
    @GET("/hot-content")
    Call<HotPostResponse> getHotPost(@Header("x-access-token")String accessToken);

    // 최근 강의평 조회
    @GET("/new-class-comment")
    Call<RecentLectureReviewResponse> getRecentLectureReview(@Header("x-access-token")String accessToken);

    // 자유게시판 첫 번째 게시물 조회
    @GET("/notice/1/contents")
    Call<CommonBoardResponse>getFirstFreeBoardPost(@Header("x-access-token")String accessToken);

    // 비밀게시판 첫 번째 게시물 조회
    @GET("/notice/2/contents")
    Call<CommonBoardResponse>getFirstSecretBoardPost(@Header("x-access-token")String accessToken);

    // 졸업생게시판 첫 번째 게시물 조회
    @GET("/notice/3/contents")
    Call<CommonBoardResponse>getFirstAlumniBoardPost(@Header("x-access-token")String accessToken);

    // 신입생게시판 첫 번째 게시물 조회
    @GET("/notice/4/contents")
    Call<CommonBoardResponse>getFirstFreshmenBoardPost(@Header("x-access-token")String accessToken);

    // 첫 번째 자유게시판 게시물의 contentIdx 조회
    @GET("/notice/1/contents")
    Call<CommonBoardResponse> getIndexOfFirstFreePost(@Header("x-access-token")String accessToken);

    // 첫 번째 비밀게시판 게시물의 contentIdx 조회
    @GET("/notice/2/contents")
    Call<CommonBoardResponse> getIndexOfFirstSecretPost(@Header("x-access-token")String accessToken);

    // 첫 번째 졸업생게시판 게시물의 contentIdx 조회
    @GET("/notice/3/contents")
    Call<CommonBoardResponse> getIndexOfFirstAlumniPost(@Header("x-access-token")String accessToken);

    // 첫 번째 새내기게시판 게시물의 contentIdx 조회
    @GET("/notice/4/contents")
    Call<CommonBoardResponse> getIndexOfFirstFreshmenPost(@Header("x-access-token")String accessToken);




    @GET("/test/{number}")
    Call<RealTimeHotPostResponse> getTestPathAndQuery(
            @Path("number") int number,
            @Query("content") final String content
//            @Header('X-ACCESS-TOKEN') final String
    );

    @POST("/test")
    Call<RealTimeHotPostResponse> postTest(@Body RequestBody params);
}
