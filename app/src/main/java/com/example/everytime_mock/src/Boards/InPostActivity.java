package com.example.everytime_mock.src.Main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.BaseActivity;
import com.example.everytime_mock.src.Main.frag_home.models.HotPostResponse;
import com.example.everytime_mock.src.Main.frag_home.models.RealTimeHotPostResponse;
import com.example.everytime_mock.src.Main.frag_home.models.RecentLectureReviewResponse;
import com.example.everytime_mock.src.Main.interfaces.InPostActivityView;


public class InPostActivity extends BaseActivity implements InPostActivityView {

    private TextView tv_in_post_nickname, tv_in_post_time, tv_in_post_title, tv_in_post_content, tv_in_post_like_num, tv_in_post_comment_num, tv_in_post_scrap_num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_post);

        textViewBinding();

        String clicked = getIntent().getStringExtra("clicked");

        switch(clicked){
            case "realtime_hot_post_1":
                

                break;
            case "realtime_hot_post_2":
                break;
            case "hot_post_1":
                break;
            case "hot_post_2":
                break;
            case "hot_post_3":
                break;
            case "hot_post_4":
                break;
            case "review_1":
                break;
            case "review_2":
                break;
            case "review_3":
                break;
            case "review_4":
                break;
            default:
                break;
        }

    }

    public void textViewBinding() {
        tv_in_post_nickname = findViewById(R.id.tv_in_post_nickname);
        tv_in_post_time = findViewById(R.id.tv_in_post_time);
        tv_in_post_title = findViewById(R.id.tv_in_post_title);
        tv_in_post_content = findViewById(R.id.tv_in_post_content);
        tv_in_post_like_num = findViewById(R.id.tv_in_post_like_num);
        tv_in_post_comment_num = findViewById(R.id.tv_in_post_comment_num);
        tv_in_post_scrap_num = findViewById(R.id.tv_in_post_scrap_num);
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void realtimeHotPostSuccess(RealTimeHotPostResponse realTimeHotPostResponse) {

    }

    @Override
    public void hotPostSuccess(HotPostResponse hotPostResponse) {

    }

    @Override
    public void recentLectureReviewSuccess(RecentLectureReviewResponse recentLectureReviewResponse) {

    }
}
