package com.example.everytime_mock.src.Boards;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.BaseActivity;
import com.example.everytime_mock.src.Boards.interfaces.BoardActivityView;
import com.example.everytime_mock.src.Boards.models.BoardAdapter;
import com.example.everytime_mock.src.Boards.models.BoardResponse;
import com.example.everytime_mock.src.Boards.models.PostItem;

import java.util.ArrayList;

public class AlumniBoardActivity extends BaseActivity implements BoardActivityView, PopupMenu.OnMenuItemClickListener {

    private ArrayList<PostItem> m_post_item_list;
    private BoardAdapter alumni_board_adapter;
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
        alumni_board_adapter = new BoardAdapter(m_post_item_list);
        rv_alumni_board.setAdapter(alumni_board_adapter);

        tryGetAluniBoard();


    }

    private void tryGetAluniBoard() {
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
    public void boardSuccess(BoardResponse boardResponse) {
        hideProgressDialog();

        switch (boardResponse.getCode()) {
            case 100:
                /**
                 * PostItem 형식의 ArrayList에 모두 넣어두고 어댑터를 이용해서 하나하나 레이아웃에 갖다 붙이자!!
                 * */
                int num_of_posts_in_alumni_board = boardResponse.getBoardResults().size();
                for (int i = 0; i < num_of_posts_in_alumni_board; i++){
                    PostItem postItem = new PostItem();

                    postItem.setTitle(boardResponse.getBoardResults().get(i).getContentTitle());
                    postItem.setContent(boardResponse.getBoardResults().get(i).getContentInf());
                    postItem.setTime(boardResponse.getBoardResults().get(i).getWriteDay());
                    postItem.setWriter(boardResponse.getBoardResults().get(i).getContentWriter());
                    postItem.setLike_num(boardResponse.getBoardResults().get(i).getCountLike());
                    postItem.setComment_num(boardResponse.getBoardResults().get(i).getCountComment());

                    m_post_item_list.add(postItem);
                }
                alumni_board_adapter.notifyDataSetChanged();

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
                Intent intent = new Intent(AlumniBoardActivity.this, WritingActivity.class);
                intent.putExtra("boardName", 3);
                startActivity(intent);
                return true;
            case R.id.remove_from_favorite:
                return true;
            default:
                return false;
        }
    }
}
