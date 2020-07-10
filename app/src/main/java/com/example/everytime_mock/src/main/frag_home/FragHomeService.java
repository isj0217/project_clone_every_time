package com.example.everytime_mock.src.main.frag_home;

import com.example.everytime_mock.src.boards.general_boards.alumni_board.interfaces.AlumniBoardRetrofitInterface;
import com.example.everytime_mock.src.boards.general_boards.free_board.interfaces.FreeBoardRetrofitInterface;
import com.example.everytime_mock.src.boards.general_boards.freshmen_board.interfaces.FreshmenBoardRetrofitInterface;
import com.example.everytime_mock.src.boards.general_boards.secret_board.interfaces.SecretBoardRetrofitInterface;
import com.example.everytime_mock.src.boards.models.common_board.CommonBoardResponse;
import com.example.everytime_mock.src.main.frag_home.interfaces.FragHomeRetrofitInterface;
import com.example.everytime_mock.src.main.frag_home.interfaces.FragHomeView;
import com.example.everytime_mock.src.main.frag_home.models.AdvertisementResponse;
import com.example.everytime_mock.src.main.frag_home.models.HotPostResponse;
import com.example.everytime_mock.src.main.frag_home.models.RealTimeHotPostResponse;
import com.example.everytime_mock.src.main.frag_home.models.RecentLectureReviewResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

public class FragHomeService {
    private final FragHomeView mFragHomeView;

    FragHomeService(final FragHomeView fragHomeView) {
        this.mFragHomeView = fragHomeView;
    }

    void getFirstFreeBoardPost() {
        final FreeBoardRetrofitInterface freeBoardRetrofitInterface = getRetrofit().create(FreeBoardRetrofitInterface.class);
        freeBoardRetrofitInterface.getFreeBoard(X_ACCESS_TOKEN).enqueue(new Callback<CommonBoardResponse>() {
            @Override
            public void onResponse(Call<CommonBoardResponse> call, Response<CommonBoardResponse> response) {
                final CommonBoardResponse commonBoardResponse = response.body();
                if (commonBoardResponse == null) {
                    mFragHomeView.validateFailure(null);
                    return;
                }
                mFragHomeView.getFreeBoardSuccess(commonBoardResponse);
            }

            @Override
            public void onFailure(Call<CommonBoardResponse> call, Throwable t) {
                mFragHomeView.validateFailure(null);
            }
        });
    }

    void getFirstSecretBoardPost() {
        final SecretBoardRetrofitInterface secretBoardRetrofitInterface = getRetrofit().create(SecretBoardRetrofitInterface.class);
        secretBoardRetrofitInterface.getSecretBoard(X_ACCESS_TOKEN).enqueue(new Callback<CommonBoardResponse>() {
            @Override
            public void onResponse(Call<CommonBoardResponse> call, Response<CommonBoardResponse> response) {
                final CommonBoardResponse commonBoardResponse = response.body();
                if (commonBoardResponse == null) {
                    mFragHomeView.validateFailure(null);
                    return;
                }
                mFragHomeView.getSecretBoardSuccess(commonBoardResponse);
            }

            @Override
            public void onFailure(Call<CommonBoardResponse> call, Throwable t) {
                mFragHomeView.validateFailure(null);
            }
        });
    }

    void getFirstAlumniBoardPost() {
        final AlumniBoardRetrofitInterface alumniBoardRetrofitInterface = getRetrofit().create(AlumniBoardRetrofitInterface.class);
        alumniBoardRetrofitInterface.getAlumniBoard(X_ACCESS_TOKEN).enqueue(new Callback<CommonBoardResponse>() {
            @Override
            public void onResponse(Call<CommonBoardResponse> call, Response<CommonBoardResponse> response) {
                final CommonBoardResponse commonBoardResponse = response.body();
                if (commonBoardResponse == null) {
                    mFragHomeView.validateFailure(null);
                    return;
                }
                mFragHomeView.getAlumniBoardSuccess(commonBoardResponse);
            }

            @Override
            public void onFailure(Call<CommonBoardResponse> call, Throwable t) {
                mFragHomeView.validateFailure(null);
            }
        });
    }

    void getFirstFreshmenBoardPost() {
        final FreshmenBoardRetrofitInterface freshmenBoardRetrofitInterface = getRetrofit().create(FreshmenBoardRetrofitInterface.class);
        freshmenBoardRetrofitInterface.getFreshmenBoard(X_ACCESS_TOKEN).enqueue(new Callback<CommonBoardResponse>() {
            @Override
            public void onResponse(Call<CommonBoardResponse> call, Response<CommonBoardResponse> response) {
                final CommonBoardResponse commonBoardResponse = response.body();
                if (commonBoardResponse == null) {
                    mFragHomeView.validateFailure(null);
                    return;
                }
                mFragHomeView.getFreshmenBoardSuccess(commonBoardResponse);
            }

            @Override
            public void onFailure(Call<CommonBoardResponse> call, Throwable t) {
                mFragHomeView.validateFailure(null);
            }
        });
    }

    void getHotPost() {
        final FragHomeRetrofitInterface fragHomeRetrofitInterface = getRetrofit().create(FragHomeRetrofitInterface.class);
        fragHomeRetrofitInterface.getHotPost(X_ACCESS_TOKEN).enqueue(new Callback<HotPostResponse>() {
            @Override
            public void onResponse(Call<HotPostResponse> call, Response<HotPostResponse> response) {
                final HotPostResponse hotPostResponse = response.body();
                if (hotPostResponse == null) {
                    mFragHomeView.validateFailure(null);
                    return;
                }
                mFragHomeView.hotPostSuccess(hotPostResponse);
            }

            @Override
            public void onFailure(Call<HotPostResponse> call, Throwable t) {
                mFragHomeView.validateFailure(null);
            }
        });
    }

    void getRealTimeHotPost() {
        final FragHomeRetrofitInterface fragHomeRetrofitInterface = getRetrofit().create(FragHomeRetrofitInterface.class);
        fragHomeRetrofitInterface.getRealTimeHotPost(X_ACCESS_TOKEN).enqueue(new Callback<RealTimeHotPostResponse>() {
            @Override
            public void onResponse(Call<RealTimeHotPostResponse> call, Response<RealTimeHotPostResponse> response) {
                final RealTimeHotPostResponse realTimeHotPostResponse = response.body();
                if (realTimeHotPostResponse == null) {
                    mFragHomeView.validateFailure(null);
                    return;
                }
                mFragHomeView.realTimeHotPostSuccess(realTimeHotPostResponse);
            }

            @Override
            public void onFailure(Call<RealTimeHotPostResponse> call, Throwable t) {
                mFragHomeView.validateFailure(null);
            }
        });
    }

    void getAdvertisement() {
        final FragHomeRetrofitInterface fragHomeRetrofitInterface = getRetrofit().create(FragHomeRetrofitInterface.class);
        fragHomeRetrofitInterface.getAdvertisement(X_ACCESS_TOKEN).enqueue(new Callback<AdvertisementResponse>() {
            @Override
            public void onResponse(Call<AdvertisementResponse> call, Response<AdvertisementResponse> response) {
                final AdvertisementResponse advertisementResponse = response.body();
                if (advertisementResponse == null) {
                    mFragHomeView.validateFailure(null);
                    return;
                }
                mFragHomeView.advertisementSuccess(advertisementResponse);
            }

            @Override
            public void onFailure(Call<AdvertisementResponse> call, Throwable t) {
                mFragHomeView.validateFailure(null);
            }
        });
    }

    void getRecentLectureReview() {
        final FragHomeRetrofitInterface fragHomeRetrofitInterface = getRetrofit().create(FragHomeRetrofitInterface.class);
        fragHomeRetrofitInterface.getRecentLectureReview(X_ACCESS_TOKEN).enqueue(new Callback<RecentLectureReviewResponse>() {
            @Override
            public void onResponse(Call<RecentLectureReviewResponse> call, Response<RecentLectureReviewResponse> response) {
                final RecentLectureReviewResponse recentLectureReviewResponse = response.body();
                if (recentLectureReviewResponse == null) {
                    mFragHomeView.validateFailure(null);
                    return;
                }
                mFragHomeView.recentLectureReviewSuccess(recentLectureReviewResponse);
            }

            @Override
            public void onFailure(Call<RecentLectureReviewResponse> call, Throwable t) {
                mFragHomeView.validateFailure(null);
            }
        });
    }
}
