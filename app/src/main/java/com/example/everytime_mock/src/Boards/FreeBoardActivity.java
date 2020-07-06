package com.example.everytime_mock.src.Boards;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.BaseActivity;
import com.example.everytime_mock.src.Boards.interfaces.FreeBoardActivityView;
import com.example.everytime_mock.src.Boards.models.BoardAdapter;
import com.example.everytime_mock.src.Boards.models.FreeBoardResponse;
import com.example.everytime_mock.src.Boards.models.PostItem;

import java.util.ArrayList;

public class FreeBoardActivity extends BaseActivity implements FreeBoardActivityView {

    private ArrayList<PostItem> m_post_item_list;
    private BoardAdapter free_board_adapter;
    private RecyclerView rv_free_board;
    private LinearLayoutManager linear_layout_manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_board);

        m_post_item_list = new ArrayList<>();

        free_board_adapter = new BoardAdapter(m_post_item_list);
        rv_free_board = findViewById(R.id.rv_free_board_post_list);

        linear_layout_manager = new LinearLayoutManager(getApplicationContext());
        rv_free_board.setLayoutManager(linear_layout_manager);

        m_post_item_list = new ArrayList<>();
        free_board_adapter = new BoardAdapter(m_post_item_list);
        rv_free_board.setAdapter(free_board_adapter);

        tryGetFreeBoard();


    }

    private void tryGetFreeBoard() {
        showProgressDialog();

        final FreeBoardService freeBoardService = new FreeBoardService(this);
        freeBoardService.getFreeBoard();
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void freeBoardSuccess(FreeBoardResponse freeBoardResponse) {
        hideProgressDialog();

        switch (freeBoardResponse.getCode()) {
            case 100:
                /**
                 * PostItem 형식의 ArrayList에 모두 넣어두고 어댑터를 이용해서 하나하나 레이아웃에 갖다 붙이자!!
                 * */
                int num_of_posts_in_free_board = freeBoardResponse.getFreeBoardResults().size();
                for (int i = 0; i < num_of_posts_in_free_board; i++){
                    PostItem postItem = new PostItem();

                    postItem.setTitle(freeBoardResponse.getFreeBoardResults().get(i).getContentTitle());
                    postItem.setContent(freeBoardResponse.getFreeBoardResults().get(i).getContentInf());
                    postItem.setTime(freeBoardResponse.getFreeBoardResults().get(i).getWriteDay());
                    postItem.setWriter(freeBoardResponse.getFreeBoardResults().get(i).getContentWriter());
                    postItem.setLike_num(freeBoardResponse.getFreeBoardResults().get(i).getCountLike());
                    postItem.setComment_num(freeBoardResponse.getFreeBoardResults().get(i).getCountComment());

                    m_post_item_list.add(postItem);
                }
                free_board_adapter.notifyDataSetChanged();

                /**
                 * 다 넣었으니 이제 어댑터로 갖다 붙이자!!!
                 * */

//                for (int i = 0; i < num_of_posts_in_free_board; i++){
//                    PostItem temp_post_item  = m_post_item_list.get(i);
//                    board_adapter.notifyDataSetChanged();
//                }



                break;
        }
    }
}
