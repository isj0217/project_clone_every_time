package com.example.everytime_mock.src.boards.in_post;

import android.os.Bundle;
import android.widget.TextView;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.BaseActivity;
import com.example.everytime_mock.src.boards.models.BoardResponse;
import com.example.everytime_mock.src.main.frag_home.models.RealTimeHotPostResponse;
import com.example.everytime_mock.src.main.frag_home.models.RecentLectureReviewResponse;
import com.example.everytime_mock.src.main.interfaces.InPostActivityView;

import java.sql.SQLOutput;


public class InPostActivity extends BaseActivity implements InPostActivityView {

    private TextView tv_in_post_nickname, tv_in_post_time, tv_in_post_title, tv_in_post_content, tv_in_post_like_num, tv_in_post_comment_num, tv_in_post_scrap_num;

    private InPostService inPostService;
    private String clicked;

    private int m_clicked_free_index;
    private int m_clicked_secret_index;
    private int m_clicked_alumni_index;
    private int m_clicked_freshmen_index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_post);

        inPostService = new InPostService(this);

        textViewBinding();

        if (getIntent().getStringExtra("clicked") != null) {
            clicked = getIntent().getStringExtra("clicked");
        }else{
            clicked = "";
        }


        m_clicked_free_index = getIntent().getIntExtra("clicked_free_idx", -1);
        if (m_clicked_free_index != -1){
            inPostService.getExactFreePost();
        }






        switch (clicked) {
            case "realtime_hot_post_1":
            case "realtime_hot_post_2":
                inPostService.getRealTimeHotBoard();
                break;
            case "hot_post_1":
            case "hot_post_2":
            case "hot_post_3":
            case "hot_post_4":
                inPostService.getHotBoard();
                break;
            case "review_1":
            case "review_2":
            case "review_3":
            case "review_4":
                inPostService.getRecentLectureReview();
                break;
            case "frag_home_favorite_free_board":
                inPostService.getFreeBoard();
                break;
            case "frag_home_favorite_secret_board":
                inPostService.getSecretBoard();
                break;
            case "frag_home_favorite_alumni_board":
                inPostService.getAlumniBoard();
                break;
            case "frag_home_favorite_freshmen_board":
                inPostService.getFreshmenBoard();
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
        switch (clicked) {
            case "realtime_hot_post_1":
                tv_in_post_nickname.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(0).getContentWriter());
                tv_in_post_time.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(0).getWriteDay());
                tv_in_post_title.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(0).getContentTitle());
                tv_in_post_content.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(0).getContentInf());
                tv_in_post_like_num.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(0).getCountLike());
                tv_in_post_comment_num.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(0).getCountComment());
                tv_in_post_scrap_num.setText(Integer.toString(realTimeHotPostResponse.getRealTimeHotPostResults().get(0).getCountScrab()));
                break;
            case "realtime_hot_post_2":
                tv_in_post_nickname.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(1).getContentWriter());
                tv_in_post_time.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(1).getWriteDay());
                tv_in_post_title.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(1).getContentTitle());
                tv_in_post_content.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(1).getContentInf());
                tv_in_post_like_num.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(1).getCountLike());
                tv_in_post_comment_num.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(1).getCountComment());
                tv_in_post_scrap_num.setText(Integer.toString(realTimeHotPostResponse.getRealTimeHotPostResults().get(1).getCountScrab()));
                break;
        }

    }

    @Override
    public void hotPostSuccess(BoardResponse boardResponse) {
        switch (clicked) {
            case "hot_post_1":
                tv_in_post_nickname.setText(boardResponse.getBoardResults().get(0).getContentWriter());         // 글쓴이 서버에서 안넘어옴
                tv_in_post_time.setText(boardResponse.getBoardResults().get(0).getWriteDay());
                tv_in_post_title.setText(boardResponse.getBoardResults().get(0).getContentTitle());
                tv_in_post_content.setText(boardResponse.getBoardResults().get(0).getContentInf());
                tv_in_post_like_num.setText(Integer.toString(boardResponse.getBoardResults().get(0).getCountLike()));
                tv_in_post_comment_num.setText(Integer.toString(boardResponse.getBoardResults().get(0).getCountComment()));
                tv_in_post_scrap_num.setText("0");
                // scrap_num이 API에서 넘어오지 않아 임시로 0으로 설정함
                break;
            case "hot_post_2":
                tv_in_post_nickname.setText(boardResponse.getBoardResults().get(1).getContentWriter());         // 글쓴이 서버에서 안넘어옴
                tv_in_post_time.setText(boardResponse.getBoardResults().get(1).getWriteDay());
                tv_in_post_title.setText(boardResponse.getBoardResults().get(1).getContentTitle());
                tv_in_post_content.setText(boardResponse.getBoardResults().get(1).getContentInf());
                tv_in_post_like_num.setText(Integer.toString(boardResponse.getBoardResults().get(1).getCountLike()));
                tv_in_post_comment_num.setText(Integer.toString(boardResponse.getBoardResults().get(1).getCountComment()));
                tv_in_post_scrap_num.setText("0");
                // scrap_num이 API에서 넘어오지 않아 임시로 0으로 설정함
                break;
            case "hot_post_3":
                tv_in_post_nickname.setText(boardResponse.getBoardResults().get(2).getContentWriter());         // 글쓴이 서버에서 안넘어옴
                tv_in_post_time.setText(boardResponse.getBoardResults().get(2).getWriteDay());
                tv_in_post_title.setText(boardResponse.getBoardResults().get(2).getContentTitle());
                tv_in_post_content.setText(boardResponse.getBoardResults().get(2).getContentInf());
                tv_in_post_like_num.setText(Integer.toString(boardResponse.getBoardResults().get(2).getCountLike()));
                tv_in_post_comment_num.setText(Integer.toString(boardResponse.getBoardResults().get(2).getCountComment()));
                tv_in_post_scrap_num.setText("0");
                // scrap_num이 API에서 넘어오지 않아 임시로 0으로 설정함
                break;
            case "hot_post_4":
                tv_in_post_nickname.setText(boardResponse.getBoardResults().get(3).getContentWriter());         // 글쓴이 서버에서 안넘어옴
                tv_in_post_time.setText(boardResponse.getBoardResults().get(3).getWriteDay());
                tv_in_post_title.setText(boardResponse.getBoardResults().get(3).getContentTitle());
                tv_in_post_content.setText(boardResponse.getBoardResults().get(3).getContentInf());
                tv_in_post_like_num.setText(Integer.toString(boardResponse.getBoardResults().get(3).getCountLike()));
                tv_in_post_comment_num.setText(Integer.toString(boardResponse.getBoardResults().get(3).getCountComment()));
                tv_in_post_scrap_num.setText("0");
                // scrap_num이 API에서 넘어오지 않아 임시로 0으로 설정함
                break;
        }
    }


    /**
     * 이건 레이아웃 따로 파야 함
     * */
    @Override
    public void recentLectureReviewSuccess(RecentLectureReviewResponse recentLectureReviewBoardResponse) {
        switch (clicked) {
            case "review_1":
//                tv_in_post_nickname.setText(recentLectureReviewBoardResponse.getRecentLectureReviewBoardResults().get(0).get().getRecentLectureReviewResults().get(0).getboardResponse.getBoardResults().get(0).getContentWriter());         // 글쓴이 서버에서 안넘어옴
//                tv_in_post_time.setText(boardResponse.getBoardResults().get(0).getWriteDay());
//                tv_in_post_title.setText(boardResponse.getBoardResults().get(0).getContentTitle());
//                tv_in_post_content.setText(boardResponse.getBoardResults().get(0).getContentInf());
//                tv_in_post_like_num.setText(Integer.toString(boardResponse.getBoardResults().get(0).getCountLike()));
//                tv_in_post_comment_num.setText(Integer.toString(boardResponse.getBoardResults().get(0).getCountComment()));
//                tv_in_post_scrap_num.setText("0");
//                // scrap_num이 API에서 넘어오지 않아 임시로 0으로 설정함
//                break;
//            case "review_2":
//                tv_in_post_nickname.setText(boardResponse.getBoardResults().get(1).getContentWriter());         // 글쓴이 서버에서 안넘어옴
//                tv_in_post_time.setText(boardResponse.getBoardResults().get(1).getWriteDay());
//                tv_in_post_title.setText(boardResponse.getBoardResults().get(1).getContentTitle());
//                tv_in_post_content.setText(boardResponse.getBoardResults().get(1).getContentInf());
//                tv_in_post_like_num.setText(Integer.toString(boardResponse.getBoardResults().get(1).getCountLike()));
//                tv_in_post_comment_num.setText(Integer.toString(boardResponse.getBoardResults().get(1).getCountComment()));
//                tv_in_post_scrap_num.setText("0");
//                // scrap_num이 API에서 넘어오지 않아 임시로 0으로 설정함
//                break;
//            case "review_3":
//                tv_in_post_nickname.setText(boardResponse.getBoardResults().get(2).getContentWriter());         // 글쓴이 서버에서 안넘어옴
//                tv_in_post_time.setText(boardResponse.getBoardResults().get(2).getWriteDay());
//                tv_in_post_title.setText(boardResponse.getBoardResults().get(2).getContentTitle());
//                tv_in_post_content.setText(boardResponse.getBoardResults().get(2).getContentInf());
//                tv_in_post_like_num.setText(Integer.toString(boardResponse.getBoardResults().get(2).getCountLike()));
//                tv_in_post_comment_num.setText(Integer.toString(boardResponse.getBoardResults().get(2).getCountComment()));
//                tv_in_post_scrap_num.setText("0");
//                // scrap_num이 API에서 넘어오지 않아 임시로 0으로 설정함
//                break;
//            case "review_4":
//                tv_in_post_nickname.setText(boardResponse.getBoardResults().get(3).getContentWriter());         // 글쓴이 서버에서 안넘어옴
//                tv_in_post_time.setText(boardResponse.getBoardResults().get(3).getWriteDay());
//                tv_in_post_title.setText(boardResponse.getBoardResults().get(3).getContentTitle());
//                tv_in_post_content.setText(boardResponse.getBoardResults().get(3).getContentInf());
//                tv_in_post_like_num.setText(Integer.toString(boardResponse.getBoardResults().get(3).getCountLike()));
//                tv_in_post_comment_num.setText(Integer.toString(boardResponse.getBoardResults().get(3).getCountComment()));
//                tv_in_post_scrap_num.setText("0");
//                // scrap_num이 API에서 넘어오지 않아 임시로 0으로 설정함
                break;
        }
    }

    @Override
    public void freeBoardSuccess(BoardResponse boardResponse) {
        switch (clicked) {
            case "frag_home_favorite_free_board":

                tv_in_post_nickname.setText(boardResponse.getBoardResults().get(0).getContentWriter());         // 글쓴이 서버에서 안넘어옴
                tv_in_post_time.setText(boardResponse.getBoardResults().get(0).getWriteDay());
                tv_in_post_title.setText(boardResponse.getBoardResults().get(0).getContentTitle());
                tv_in_post_content.setText(boardResponse.getBoardResults().get(0).getContentInf());
                tv_in_post_like_num.setText(Integer.toString(boardResponse.getBoardResults().get(0).getCountLike()));
                tv_in_post_comment_num.setText(Integer.toString(boardResponse.getBoardResults().get(0).getCountComment()));
                tv_in_post_scrap_num.setText("0");
                break;
            case "frag_home_favorite_secret_board":
                break;
            case "frag_home_favorite_alumni_board":
                break;
            case "frag_home_favorite_freshmen_board":
                break;
        }
    }

    @Override
    public void secretBoardSuccess(BoardResponse boardResponse) {
        switch (clicked) {
            case "frag_home_favorite_free_board":
                break;
            case "frag_home_favorite_secret_board":
                tv_in_post_nickname.setText(boardResponse.getBoardResults().get(0).getContentWriter());         // 글쓴이 서버에서 안넘어옴
                tv_in_post_time.setText(boardResponse.getBoardResults().get(0).getWriteDay());
                tv_in_post_title.setText(boardResponse.getBoardResults().get(0).getContentTitle());
                tv_in_post_content.setText(boardResponse.getBoardResults().get(0).getContentInf());
                tv_in_post_like_num.setText(Integer.toString(boardResponse.getBoardResults().get(0).getCountLike()));
                tv_in_post_comment_num.setText(Integer.toString(boardResponse.getBoardResults().get(0).getCountComment()));
                tv_in_post_scrap_num.setText("0");
                break;
            case "frag_home_favorite_alumni_board":
                break;
            case "frag_home_favorite_freshmen_board":
                break;
        }
    }

    @Override
    public void alumniBoardSuccess(BoardResponse boardResponse) {
        switch (clicked) {
            case "frag_home_favorite_free_board":
                break;
            case "frag_home_favorite_secret_board":
                break;
            case "frag_home_favorite_alumni_board":
                tv_in_post_nickname.setText(boardResponse.getBoardResults().get(0).getContentWriter());         // 글쓴이 서버에서 안넘어옴
                tv_in_post_time.setText(boardResponse.getBoardResults().get(0).getWriteDay());
                tv_in_post_title.setText(boardResponse.getBoardResults().get(0).getContentTitle());
                tv_in_post_content.setText(boardResponse.getBoardResults().get(0).getContentInf());
                tv_in_post_like_num.setText(Integer.toString(boardResponse.getBoardResults().get(0).getCountLike()));
                tv_in_post_comment_num.setText(Integer.toString(boardResponse.getBoardResults().get(0).getCountComment()));
                tv_in_post_scrap_num.setText("0");
                break;
            case "frag_home_favorite_freshmen_board":
                break;
        }

    }

    @Override
    public void freshmenBoardSuccess(BoardResponse boardResponse) {
        switch (clicked) {
            case "frag_home_favorite_free_board":
                break;
            case "frag_home_favorite_secret_board":
                break;
            case "frag_home_favorite_alumni_board":
                break;
            case "frag_home_favorite_freshmen_board":
                tv_in_post_nickname.setText(boardResponse.getBoardResults().get(0).getContentWriter());         // 글쓴이 서버에서 안넘어옴
                tv_in_post_time.setText(boardResponse.getBoardResults().get(0).getWriteDay());
                tv_in_post_title.setText(boardResponse.getBoardResults().get(0).getContentTitle());
                tv_in_post_content.setText(boardResponse.getBoardResults().get(0).getContentInf());
                tv_in_post_like_num.setText(Integer.toString(boardResponse.getBoardResults().get(0).getCountLike()));
                tv_in_post_comment_num.setText(Integer.toString(boardResponse.getBoardResults().get(0).getCountComment()));
                tv_in_post_scrap_num.setText("0");
                break;
        }
    }

    @Override
    public void exactFreePostSuccess(BoardResponse boardResponse) {
        tv_in_post_nickname.setText(boardResponse.getBoardResults().get(m_clicked_free_index).getContentWriter());         // 글쓴이 서버에서 안넘어옴
        tv_in_post_time.setText(boardResponse.getBoardResults().get(m_clicked_free_index).getWriteDay());
        tv_in_post_title.setText(boardResponse.getBoardResults().get(m_clicked_free_index).getContentTitle());
        tv_in_post_content.setText(boardResponse.getBoardResults().get(m_clicked_free_index).getContentInf());
        tv_in_post_like_num.setText(Integer.toString(boardResponse.getBoardResults().get(m_clicked_free_index).getCountLike()));
        tv_in_post_comment_num.setText(Integer.toString(boardResponse.getBoardResults().get(m_clicked_free_index).getCountComment()));
        tv_in_post_scrap_num.setText("0");
    }
}
