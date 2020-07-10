package com.example.everytime_mock.src.boards.general_boards.alumni_board;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.BaseActivity;
import com.example.everytime_mock.src.boards.models.adapters.AlumniBoardAdapter;
import com.example.everytime_mock.src.boards.writing.WritingActivity;
import com.example.everytime_mock.src.boards.interfaces.BoardActivityView;
import com.example.everytime_mock.src.boards.models.common_board.CommonBoardResponse;
import com.example.everytime_mock.src.boards.models.items.PostItem;

import java.util.ArrayList;

public class AlumniBoardActivity extends BaseActivity implements BoardActivityView, PopupMenu.OnMenuItemClickListener {

    private ArrayList<PostItem> m_post_item_list;
    private AlumniBoardAdapter alumni_board_adapter;
    private RecyclerView rv_alumni_board;
    private LinearLayoutManager linear_layout_manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumni_board);

        rv_alumni_board = findViewById(R.id.rv_alumni_board_post_list);

        linear_layout_manager = new LinearLayoutManager(getApplicationContext());
        rv_alumni_board.setLayoutManager(linear_layout_manager);

        m_post_item_list = new ArrayList<>();
        alumni_board_adapter = new AlumniBoardAdapter(m_post_item_list);
        rv_alumni_board.setAdapter(alumni_board_adapter);

        tryGetAlumniBoard();
    }

    private void tryGetAlumniBoard() {
        showProgressDialog();

        final AlumniBoardService alumniBoardService = new AlumniBoardService(this);
        alumniBoardService.getAlumniBoard();
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void boardSuccess(CommonBoardResponse commonBoardResponse) {
        hideProgressDialog();

        switch (commonBoardResponse.getCode()) {
            case 100:
                /**
                 * PostItem 형식의 ArrayList에 모두 넣어두고 어댑터를 이용해서 하나하나 레이아웃에 갖다 붙이자!!
                 * */
                int num_of_posts_in_alumni_board = commonBoardResponse.getCommonBoardResults().size();
                for (int i = 0; i < num_of_posts_in_alumni_board; i++){
                    PostItem postItem = new PostItem();

                    postItem.setContent_index(commonBoardResponse.getCommonBoardResults().get(i).getContentIdx());
                    postItem.setTitle(commonBoardResponse.getCommonBoardResults().get(i).getContentTitle());
                    postItem.setContent(commonBoardResponse.getCommonBoardResults().get(i).getContentInf());
                    postItem.setTime(commonBoardResponse.getCommonBoardResults().get(i).getWriteDay());
                    postItem.setWriter(commonBoardResponse.getCommonBoardResults().get(i).getContentWriter());
                    postItem.setLike_num(commonBoardResponse.getCommonBoardResults().get(i).getCountLike());
                    postItem.setComment_num(commonBoardResponse.getCommonBoardResults().get(i).getCountComment());

                    m_post_item_list.add(postItem);
                }
                alumni_board_adapter.notifyDataSetChanged();

                break;

        }
    }

    public void customOnClick(View view) {
        switch (view.getId()){
            case R.id.iv_alumni_board_go_back:
                onBackPressed();
                break;
            case R.id.iv_alumni_board_more:
                showPopUp(view);
                break;case R.id.iv_alumni_board_sync:
                restartActivity(AlumniBoardActivity.this);
                break;
        }

    }

    private void restartActivity(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, activity.getClass());
        activity.startActivity(intent);
        activity.finish();
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
                Intent intent = new Intent(AlumniBoardActivity.this, WritingActivity.class);
                intent.putExtra("boardName", 3);
                startActivity(intent);
                finish();
                return true;
            case R.id.remove_from_favorite:
                return true;
            default:
                return false;
        }
    }
}
