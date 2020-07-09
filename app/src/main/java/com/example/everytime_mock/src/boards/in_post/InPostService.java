package com.example.everytime_mock.src.boards.in_post;

import android.util.Log;

import com.example.everytime_mock.src.boards.general_boards.alumni_board.interfaces.AlumniBoardRetrofitInterface;
import com.example.everytime_mock.src.boards.general_boards.free_board.interfaces.FreeBoardRetrofitInterface;
import com.example.everytime_mock.src.boards.general_boards.freshmen_board.interfaces.FreshmenBoardRetrofitInterface;
import com.example.everytime_mock.src.boards.in_post.interfaces.InPostRetrofitInterface;
import com.example.everytime_mock.src.boards.general_boards.secret_board.interfaces.SecretBoardRetrofitInterface;
import com.example.everytime_mock.src.boards.in_post.models.CommentResponse;
import com.example.everytime_mock.src.boards.models.common_board.CommonBoardResponse;
import com.example.everytime_mock.src.main.frag_home.models.RealTimeHotPostResponse;
import com.example.everytime_mock.src.main.frag_home.models.RecentLectureReviewResponse;
import com.example.everytime_mock.src.boards.in_post.interfaces.InPostActivityView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class InPostService {
    private final InPostActivityView mInPostActivityView;

    InPostService(final InPostActivityView inPostActivityView) {
        this.mInPostActivityView = inPostActivityView;
    }

    void getRealTimeHotBoard() {
        final InPostRetrofitInterface inPostRetrofitInterface = getRetrofit().create(InPostRetrofitInterface.class);
        inPostRetrofitInterface.getRealTimeHotPost(X_ACCESS_TOKEN).enqueue(new Callback<RealTimeHotPostResponse>() {
            @Override
            public void onResponse(Call<RealTimeHotPostResponse> call, Response<RealTimeHotPostResponse> response) {
                final RealTimeHotPostResponse realTimeHotPostResponse = response.body();
                if (realTimeHotPostResponse == null) {
                    mInPostActivityView.validateFailure(null);
                    return;
                }
                mInPostActivityView.realtimeHotPostSuccess(realTimeHotPostResponse);
            }

            @Override
            public void onFailure(Call<RealTimeHotPostResponse> call, Throwable t) {
                mInPostActivityView.validateFailure(null);
            }
        });
    }

    void getHotBoard() {
        final InPostRetrofitInterface inPostRetrofitInterface = getRetrofit().create(InPostRetrofitInterface.class);
        inPostRetrofitInterface.getHotBoard(X_ACCESS_TOKEN, "hot-content").enqueue(new Callback<CommonBoardResponse>() {
            @Override
            public void onResponse(Call<CommonBoardResponse> call, Response<CommonBoardResponse> response) {
                final CommonBoardResponse commonBoardResponse = response.body();
                if (commonBoardResponse == null) {
                    mInPostActivityView.validateFailure(null);
                    return;
                }
                mInPostActivityView.hotPostSuccess(commonBoardResponse);
            }

            @Override
            public void onFailure(Call<CommonBoardResponse> call, Throwable t) {
                mInPostActivityView.validateFailure(null);
            }
        });
    }

    void getRecentLectureReview() {
        final InPostRetrofitInterface inPostRetrofitInterface = getRetrofit().create(InPostRetrofitInterface.class);
        inPostRetrofitInterface.getRecentLectureReview(X_ACCESS_TOKEN).enqueue(new Callback<RecentLectureReviewResponse>() {
            @Override
            public void onResponse(Call<RecentLectureReviewResponse> call, Response<RecentLectureReviewResponse> response) {
                final RecentLectureReviewResponse recentLectureReviewResponse = response.body();
                if (recentLectureReviewResponse == null) {
                    mInPostActivityView.validateFailure(null);
                    return;
                }
                mInPostActivityView.recentLectureReviewSuccess(recentLectureReviewResponse);
            }

            @Override
            public void onFailure(Call<RecentLectureReviewResponse> call, Throwable t) {
                mInPostActivityView.validateFailure(null);
            }
        });
    }

    void getFreeBoard() {
        final FreeBoardRetrofitInterface freeBoardRetrofitInterface = getRetrofit().create(FreeBoardRetrofitInterface.class);
        freeBoardRetrofitInterface.getFreeBoard(X_ACCESS_TOKEN).enqueue(new Callback<CommonBoardResponse>() {
            @Override
            public void onResponse(Call<CommonBoardResponse> call, Response<CommonBoardResponse> response) {
                final CommonBoardResponse commonBoardResponse = response.body();
                if (commonBoardResponse == null) {
                    mInPostActivityView.validateFailure(null);
                    return;
                }
                mInPostActivityView.freeBoardSuccess(commonBoardResponse);
            }

            @Override
            public void onFailure(Call<CommonBoardResponse> call, Throwable t) {
                mInPostActivityView.validateFailure(null);
            }
        });
    }

    void getSecretBoard() {
        final SecretBoardRetrofitInterface secretBoardRetrofitInterface = getRetrofit().create(SecretBoardRetrofitInterface.class);
        secretBoardRetrofitInterface.getSecretBoard(X_ACCESS_TOKEN).enqueue(new Callback<CommonBoardResponse>() {
            @Override
            public void onResponse(Call<CommonBoardResponse> call, Response<CommonBoardResponse> response) {
                final CommonBoardResponse commonBoardResponse = response.body();
                if (commonBoardResponse == null) {
                    mInPostActivityView.validateFailure(null);
                    return;
                }
                mInPostActivityView.secretBoardSuccess(commonBoardResponse);
            }

            @Override
            public void onFailure(Call<CommonBoardResponse> call, Throwable t) {
                mInPostActivityView.validateFailure(null);
            }
        });
    }

    void getAlumniBoard() {
        final AlumniBoardRetrofitInterface alumniBoardRetrofitInterface = getRetrofit().create(AlumniBoardRetrofitInterface.class);
        alumniBoardRetrofitInterface.getAlumniBoard(X_ACCESS_TOKEN).enqueue(new Callback<CommonBoardResponse>() {
            @Override
            public void onResponse(Call<CommonBoardResponse> call, Response<CommonBoardResponse> response) {
                final CommonBoardResponse commonBoardResponse = response.body();
                if (commonBoardResponse == null) {
                    mInPostActivityView.validateFailure(null);
                    return;
                }
                mInPostActivityView.alumniBoardSuccess(commonBoardResponse);
            }

            @Override
            public void onFailure(Call<CommonBoardResponse> call, Throwable t) {
                mInPostActivityView.validateFailure(null);
            }
        });
    }

    void getFreshmenBoard() {
        final FreshmenBoardRetrofitInterface freshmenBoardRetrofitInterface = getRetrofit().create(FreshmenBoardRetrofitInterface.class);
        freshmenBoardRetrofitInterface.getFreshmenBoard(X_ACCESS_TOKEN).enqueue(new Callback<CommonBoardResponse>() {
            @Override
            public void onResponse(Call<CommonBoardResponse> call, Response<CommonBoardResponse> response) {
                final CommonBoardResponse commonBoardResponse = response.body();
                if (commonBoardResponse == null) {
                    mInPostActivityView.validateFailure(null);
                    return;
                }
                mInPostActivityView.freshmenBoardSuccess(commonBoardResponse);
            }

            @Override
            public void onFailure(Call<CommonBoardResponse> call, Throwable t) {
                mInPostActivityView.validateFailure(null);
            }
        });
    }

    void getExactFreePost() {
        final FreeBoardRetrofitInterface freeBoardRetrofitInterface = getRetrofit().create(FreeBoardRetrofitInterface.class);
        freeBoardRetrofitInterface.getFreeBoard(X_ACCESS_TOKEN).enqueue(new Callback<CommonBoardResponse>() {
            @Override
            public void onResponse(Call<CommonBoardResponse> call, Response<CommonBoardResponse> response) {
                final CommonBoardResponse commonBoardResponse = response.body();
                if (commonBoardResponse == null) {
                    mInPostActivityView.validateFailure(null);
                    return;
                }
                mInPostActivityView.exactFreePostSuccess(commonBoardResponse);
            }

            @Override
            public void onFailure(Call<CommonBoardResponse> call, Throwable t) {
                mInPostActivityView.validateFailure(null);
            }
        });
    }

    void getExactSecretPost() {
        final SecretBoardRetrofitInterface secretBoardRetrofitInterface = getRetrofit().create(SecretBoardRetrofitInterface.class);
        secretBoardRetrofitInterface.getSecretBoard(X_ACCESS_TOKEN).enqueue(new Callback<CommonBoardResponse>() {
            @Override
            public void onResponse(Call<CommonBoardResponse> call, Response<CommonBoardResponse> response) {
                final CommonBoardResponse commonBoardResponse = response.body();
                if (commonBoardResponse == null) {
                    mInPostActivityView.validateFailure(null);
                    return;
                }
                mInPostActivityView.exactSecretPostSuccess(commonBoardResponse);
            }

            @Override
            public void onFailure(Call<CommonBoardResponse> call, Throwable t) {
                mInPostActivityView.validateFailure(null);
            }
        });
    }

    void getExactAlumniPost() {
        final AlumniBoardRetrofitInterface alumniBoardRetrofitInterface = getRetrofit().create(AlumniBoardRetrofitInterface.class);
        alumniBoardRetrofitInterface.getAlumniBoard(X_ACCESS_TOKEN).enqueue(new Callback<CommonBoardResponse>() {
            @Override
            public void onResponse(Call<CommonBoardResponse> call, Response<CommonBoardResponse> response) {
                final CommonBoardResponse commonBoardResponse = response.body();
                if (commonBoardResponse == null) {
                    mInPostActivityView.validateFailure(null);
                    return;
                }
                mInPostActivityView.exactAlumniPostSuccess(commonBoardResponse);
            }

            @Override
            public void onFailure(Call<CommonBoardResponse> call, Throwable t) {
                mInPostActivityView.validateFailure(null);
            }
        });
    }

    void getExactFreshmenPost() {
        final FreshmenBoardRetrofitInterface freshmenBoardRetrofitInterface = getRetrofit().create(FreshmenBoardRetrofitInterface.class);
        freshmenBoardRetrofitInterface.getFreshmenBoard(X_ACCESS_TOKEN).enqueue(new Callback<CommonBoardResponse>() {
            @Override
            public void onResponse(Call<CommonBoardResponse> call, Response<CommonBoardResponse> response) {
                final CommonBoardResponse commonBoardResponse = response.body();
                if (commonBoardResponse == null) {
                    mInPostActivityView.validateFailure(null);
                    return;
                }
                mInPostActivityView.exactFreshmenPostSuccess(commonBoardResponse);
            }

            @Override
            public void onFailure(Call<CommonBoardResponse> call, Throwable t) {
                mInPostActivityView.validateFailure(null);
            }
        });
    }

    void getFreeComment(int contentIndex) {
        final InPostRetrofitInterface inFreePostRetrofitInterface = getRetrofit().create(InPostRetrofitInterface.class);
        inFreePostRetrofitInterface.getFreeComment(X_ACCESS_TOKEN, contentIndex).enqueue(new Callback<CommentResponse>() {

            private static final String TAG = "getFreeComment";
            @Override
            public void onResponse(Call<CommentResponse> call, Response<CommentResponse> response) {
                final CommentResponse commentResponse = response.body();
                if (commentResponse == null) {
                    Log.d(TAG, "onResponse: response지만 실패");
                    mInPostActivityView.validateFailure(null);
                    return;
                }
                Log.d(TAG, "성공");
                mInPostActivityView.freeCommentSuccess(commentResponse);
            }

            @Override
            public void onFailure(Call<CommentResponse> call, Throwable t) {
                Log.d(TAG, "통신실패");
                mInPostActivityView.validateFailure(null);
            }
        });
    }

    void getSecretComment(int contentIndex) {
        final InPostRetrofitInterface inFreePostRetrofitInterface = getRetrofit().create(InPostRetrofitInterface.class);
        inFreePostRetrofitInterface.getSecretComment(X_ACCESS_TOKEN, contentIndex).enqueue(new Callback<CommentResponse>() {

            @Override
            public void onResponse(Call<CommentResponse> call, Response<CommentResponse> response) {
                final CommentResponse commentResponse = response.body();
                if (commentResponse == null) {
                    mInPostActivityView.validateFailure(null);
                    return;
                }
                mInPostActivityView.secretCommentSuccess(commentResponse);
            }

            @Override
            public void onFailure(Call<CommentResponse> call, Throwable t) {
                mInPostActivityView.validateFailure(null);
            }
        });
    }

    void getAlumniComment(int contentIndex) {
        final InPostRetrofitInterface inFreePostRetrofitInterface = getRetrofit().create(InPostRetrofitInterface.class);
        inFreePostRetrofitInterface.getAlumniComment(X_ACCESS_TOKEN, contentIndex).enqueue(new Callback<CommentResponse>() {

            @Override
            public void onResponse(Call<CommentResponse> call, Response<CommentResponse> response) {
                final CommentResponse commentResponse = response.body();
                if (commentResponse == null) {
                    mInPostActivityView.validateFailure(null);
                    return;
                }
                mInPostActivityView.alumniCommentSuccess(commentResponse);
            }

            @Override
            public void onFailure(Call<CommentResponse> call, Throwable t) {
                mInPostActivityView.validateFailure(null);
            }
        });
    }

    void getFreshmenComment(int contentIndex) {
        final InPostRetrofitInterface inFreePostRetrofitInterface = getRetrofit().create(InPostRetrofitInterface.class);
        inFreePostRetrofitInterface.getFreshmenComment(X_ACCESS_TOKEN, contentIndex).enqueue(new Callback<CommentResponse>() {

            @Override
            public void onResponse(Call<CommentResponse> call, Response<CommentResponse> response) {
                final CommentResponse commentResponse = response.body();
                if (commentResponse == null) {
                    mInPostActivityView.validateFailure(null);
                    return;
                }
                mInPostActivityView.freshmenCommentSuccess(commentResponse);
            }

            @Override
            public void onFailure(Call<CommentResponse> call, Throwable t) {
                mInPostActivityView.validateFailure(null);
            }
        });
    }


}

