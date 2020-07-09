package com.example.everytime_mock.src.boards;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.BaseActivity;
import com.example.everytime_mock.src.boards.interfaces.RecentLectureReviewBoardActivityView;
import com.example.everytime_mock.src.boards.models.RecentLectureReviewBoardAdapter;
import com.example.everytime_mock.src.boards.models.RecentLectureReviewBoardResponse;
import com.example.everytime_mock.src.boards.models.ReviewItem;

import java.util.ArrayList;

public class RecentLectureReviewBoardActivity extends BaseActivity implements RecentLectureReviewBoardActivityView, PopupMenu.OnMenuItemClickListener {

    private ArrayList<ReviewItem> m_review_item_list;
    private RecentLectureReviewBoardAdapter recent_lecture_review_board_adapter;
    private RecyclerView rv_recent_lecture_review_board;
    private LinearLayoutManager linear_layout_manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_lecture_review_board);

        m_review_item_list = new ArrayList<>();

        recent_lecture_review_board_adapter = new RecentLectureReviewBoardAdapter(m_review_item_list);
        rv_recent_lecture_review_board = findViewById(R.id.rv_recent_lecture_review_board_post_list);

        linear_layout_manager = new LinearLayoutManager(getApplicationContext());
        rv_recent_lecture_review_board.setLayoutManager(linear_layout_manager);
        rv_recent_lecture_review_board.setAdapter(recent_lecture_review_board_adapter);

        tryGetRecentLectureReviewBoard();


    }

    private void tryGetRecentLectureReviewBoard() {
        showProgressDialog();

        final RecentLectureReviewBoardService recentLectureReviewBoardService = new RecentLectureReviewBoardService(this);
        recentLectureReviewBoardService.getRecentLectureReviewBoard();
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void recentLectureReviewBoardSuccess(RecentLectureReviewBoardResponse recentLectureReviewBoardResponse) {
        hideProgressDialog();

        switch (recentLectureReviewBoardResponse.getCode()) {
            case 100:
                /**
                 * PostItem 형식의 ArrayList에 모두 넣어두고 어댑터를 이용해서 하나하나 레이아웃에 갖다 붙이자!!
                 * */

                System.out.println(recentLectureReviewBoardResponse.getRecentLectureReviewBoardResults().get(0).getClassName());
                System.out.println(recentLectureReviewBoardResponse.getRecentLectureReviewBoardResults().get(0).getClassCommentInf());
                System.out.println(recentLectureReviewBoardResponse.getRecentLectureReviewBoardResults().get(0).getClassStar());


                int num_of_posts_in_recent_lecture_review_board = recentLectureReviewBoardResponse.getRecentLectureReviewBoardResults().size();
                for (int i = 0; i < num_of_posts_in_recent_lecture_review_board; i++) {
                    ReviewItem reviewItem = new ReviewItem();

                    reviewItem.setClassCommentIdx(recentLectureReviewBoardResponse.getRecentLectureReviewBoardResults().get(i).getClassCommentIdx());
                    reviewItem.setClassName(recentLectureReviewBoardResponse.getRecentLectureReviewBoardResults().get(i).getClassName());
                    reviewItem.setProfessor(recentLectureReviewBoardResponse.getRecentLectureReviewBoardResults().get(i).getProfessor());
                    reviewItem.setClassCommentInf(recentLectureReviewBoardResponse.getRecentLectureReviewBoardResults().get(i).getClassCommentInf());
                    reviewItem.setClassStudent(recentLectureReviewBoardResponse.getRecentLectureReviewBoardResults().get(i).getClassStudent());
                    reviewItem.setClassStar(recentLectureReviewBoardResponse.getRecentLectureReviewBoardResults().get(i).getClassStar());
                    reviewItem.setClassCommentLike(recentLectureReviewBoardResponse.getRecentLectureReviewBoardResults().get(i).getClassCommentLike());

                    m_review_item_list.add(reviewItem);
                }
                recent_lecture_review_board_adapter.notifyDataSetChanged();

                break;
        }
    }

    public void customOnClick(View view) {
        switch (view.getId()) {
            case R.id.iv_free_board_go_back:
                onBackPressed();
                break;
            case R.id.iv_free_board_more:
                showPopUp(view);
                break;
        }

    }

    public void showPopUp(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);

        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.menu_board);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.write_post:
                Intent intent = new Intent(RecentLectureReviewBoardActivity.this, WritingActivity.class);
                intent.putExtra("boardName", 1);
                startActivity(intent);
                return true;
            case R.id.remove_from_favorite:
                return true;
            default:
                return false;
        }
    }
}
