package com.example.everytime_mock.src.boards.hot_board;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.BaseActivity;
import com.example.everytime_mock.src.boards.writing.WritingActivity;
import com.example.everytime_mock.src.boards.interfaces.BoardActivityView;
import com.example.everytime_mock.src.boards.models.adapters.FreeBoardAdapter;
import com.example.everytime_mock.src.boards.models.common_board.CommonBoardResponse;
import com.example.everytime_mock.src.boards.models.items.PostItem;

import java.util.ArrayList;

public class HotBoardActivity extends BaseActivity implements BoardActivityView, PopupMenu.OnMenuItemClickListener {

    private ArrayList<PostItem> m_post_item_list;
    private FreeBoardAdapter hot_board_adapter;
    private RecyclerView rv_hot_board;
    private LinearLayoutManager linear_layout_manager;

    private static final String TAG = "HotBoardActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_board);

        m_post_item_list = new ArrayList<>();

        hot_board_adapter = new FreeBoardAdapter(m_post_item_list);
        rv_hot_board = findViewById(R.id.rv_hot_board_post_list);

        linear_layout_manager = new LinearLayoutManager(getApplicationContext());
        rv_hot_board.setLayoutManager(linear_layout_manager);

        m_post_item_list = new ArrayList<>();
        hot_board_adapter = new FreeBoardAdapter(m_post_item_list);
        rv_hot_board.setAdapter(hot_board_adapter);

        tryGetHotBoard();


    }

    private void tryGetHotBoard() {
        showProgressDialog();

        final HotBoardService hotBoardService = new HotBoardService(this);
        hotBoardService.getHotBoard();
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

        Log.d(TAG, "boardSuccess: code: " + commonBoardResponse.getCode());

        switch (commonBoardResponse.getCode()) {

            case 113:
                /**
                 * PostItem 형식의 ArrayList에 모두 넣어두고 어댑터를 이용해서 하나하나 레이아웃에 갖다 붙이자!!
                 * */

//                System.out.println(boardResponse.getBoardResults().get(0).getContentTitle());

                int num_of_posts_in_hot_board = commonBoardResponse.getCommonBoardResults().size();

                for (int i = 0; i < num_of_posts_in_hot_board; i++){
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
                hot_board_adapter.notifyDataSetChanged();

                break;

        }
    }

    public void customOnClick(View view) {
        switch (view.getId()){
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
                Intent intent = new Intent(HotBoardActivity.this, WritingActivity.class);
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
