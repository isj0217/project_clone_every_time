package com.example.everytime_mock.src.main.frag_home.my_page;

import android.util.Log;

import com.example.everytime_mock.src.main.frag_home.my_page.interfaces.MyPageActivityView;
import com.example.everytime_mock.src.main.frag_home.my_page.interfaces.MyPageRetrofitInterface;
import com.example.everytime_mock.src.main.frag_home.my_page.models.MyPageResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.everytime_mock.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.everytime_mock.src.ApplicationClass.getRetrofit;

class MyPageService {
    private final MyPageActivityView mMyPageActivityView;
    private HashMap<String, Object> mParams;

    private static final String TAG = "MyPageService";

    MyPageService(final MyPageActivityView myPageActivityView) {
        this.mMyPageActivityView = myPageActivityView;
    }

    void getMyPage() {
        final MyPageRetrofitInterface myPageRetrofitInterface = getRetrofit().create(MyPageRetrofitInterface.class);

        myPageRetrofitInterface.getMyPage(X_ACCESS_TOKEN).enqueue(new Callback<MyPageResponse>() {
            @Override
            public void onResponse(Call<MyPageResponse> call, Response<MyPageResponse> response) {

                final MyPageResponse myPageResponse = response.body();
                if (myPageResponse == null) {
                    System.out.println("mypageResponse가 null입니다.");
                    Log.d(TAG, "onResponse: null");
                    mMyPageActivityView.validateFailure(null);
                    return;
                }
                Log.d(TAG, "onResponse: success" + myPageResponse.getMyPageResult().get(0).getUserNickname());
                mMyPageActivityView.myPageSuccess(myPageResponse);
            }

            @Override
            public void onFailure(Call<MyPageResponse> call, Throwable t) {
                System.out.println("통신 실패");
                Log.d(TAG, "onFailure: ");
                mMyPageActivityView.validateFailure(null);
            }
        });
    }
}
