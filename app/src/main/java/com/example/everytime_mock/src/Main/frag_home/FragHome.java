package com.example.everytime_mock.src.Main.frag_home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.Boards.FreeBoardActivity;
import com.example.everytime_mock.src.Main.frag_home.models.HotPostResponse;
import com.example.everytime_mock.src.Main.frag_home.models.RealTimeHotPostResponse;
import com.example.everytime_mock.src.Main.frag_home.my_page.MyPageActivity;
import com.example.everytime_mock.src.Main.frag_home.interfaces.FragHomeView;
import com.example.everytime_mock.src.Main.frag_home.models.FavoriteBoardAdapter;
import com.example.everytime_mock.src.Main.frag_home.models.FavoriteBoardItem;

import java.util.ArrayList;

public class FragHome extends Fragment implements FragHomeView {
    ViewGroup viewGroup;

    private ArrayList<FavoriteBoardItem> favorite_board_item_list;
    private FavoriteBoardAdapter favorite_board_adapter;
    private RecyclerView rv_favorite_board;
    private LinearLayoutManager linear_layout_manager;

    private TextView tv_frag_home_realtime_hot_post_1_user_name,
            tv_frag_home_realtime_hot_post_1_date,
            tv_frag_home_realtime_hot_post_1_title,
            tv_frag_home_realtime_hot_post_1_content,
            tv_frag_home_realtime_hot_post_1_board_type,
            tv_frag_home_realtime_hot_post_1_like_num,
            tv_frag_home_realtime_hot_post_1_comment_num;

    private TextView tv_frag_home_realtime_hot_post_2_user_name,
            tv_frag_home_realtime_hot_post_2_date,
            tv_frag_home_realtime_hot_post_2_title,
            tv_frag_home_realtime_hot_post_2_content,
            tv_frag_home_realtime_hot_post_2_board_type,
            tv_frag_home_realtime_hot_post_2_like_num,
            tv_frag_home_realtime_hot_post_2_comment_num;

    private TextView tv_frag_home_hot_post_1_title, tv_frag_home_hot_post_1_time, tv_frag_home_hot_post_1_like_num, tv_frag_home_hot_post_1_comment_num;
    private TextView tv_frag_home_hot_post_2_title, tv_frag_home_hot_post_2_time, tv_frag_home_hot_post_2_like_num, tv_frag_home_hot_post_2_comment_num;
    private TextView tv_frag_home_hot_post_3_title, tv_frag_home_hot_post_3_time, tv_frag_home_hot_post_3_like_num, tv_frag_home_hot_post_3_comment_num;
    private TextView tv_frag_home_hot_post_4_title, tv_frag_home_hot_post_4_time, tv_frag_home_hot_post_4_like_num, tv_frag_home_hot_post_4_comment_num;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.frag_home, container, false);

        viewBindRealTimeHotPost();
        viewBindHotPost();



        ImageView myPage = viewGroup.findViewById(R.id.iv_frag_home_my_page);
        myPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MyPageActivity.class);
                startActivity(intent);
            }
        });

        ImageView search = viewGroup.findViewById(R.id.iv_frag_home_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FreeBoardActivity.class);
                startActivity(intent);
            }
        });




        rv_favorite_board = viewGroup.findViewById(R.id.rv_home_favorite_board_list);

        linear_layout_manager = new LinearLayoutManager(viewGroup.getContext());
        rv_favorite_board.setLayoutManager(linear_layout_manager);

        favorite_board_item_list = new ArrayList<>();
        favorite_board_adapter = new FavoriteBoardAdapter(favorite_board_item_list);
        rv_favorite_board.setAdapter(favorite_board_adapter);

        tryGetFavoriteBoard();
        //todo
//        여기서 직접 받아와서 넣어보자!!!

        for (int i = 0; i < 8; i++){
            FavoriteBoardItem fbi = new FavoriteBoardItem("자유게시판", "...", R.drawable.new_red);
            favorite_board_item_list.add(fbi);
        }
        favorite_board_adapter.notifyDataSetChanged();


        tryGetRealTimeHotPost();
        tryGetHotPost();

        return viewGroup;
    }

    private void tryGetHotPost() {
        final HotPostService hotPostService = new HotPostService(this);
        hotPostService.getHotPost();
    }

    private void tryGetRealTimeHotPost() {
        final RealTimeHotPostService realTimeHotPostService = new RealTimeHotPostService(this);
        realTimeHotPostService.getRealTimeHotPost();
    }


    private void tryGetFavoriteBoard() {

//        final FavoriteBoardService favoriteBoardService = new FavoriteBoardService(this);
//        favoriteBoardService.getFavoriteBoard();
    }







    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    public void viewBindRealTimeHotPost() {
        tv_frag_home_realtime_hot_post_1_user_name =viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_1_user_name);
        tv_frag_home_realtime_hot_post_1_date = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_1_date);
        tv_frag_home_realtime_hot_post_1_title = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_1_title);
        tv_frag_home_realtime_hot_post_1_content = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_1_content);
        tv_frag_home_realtime_hot_post_1_board_type = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_1_board_type);
        tv_frag_home_realtime_hot_post_1_like_num = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_1_like_num);
        tv_frag_home_realtime_hot_post_1_comment_num = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_1_comment_num);

        tv_frag_home_realtime_hot_post_2_user_name = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_2_user_name);
        tv_frag_home_realtime_hot_post_2_date = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_2_date);
        tv_frag_home_realtime_hot_post_2_title = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_2_title);
        tv_frag_home_realtime_hot_post_2_content = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_2_content);
        tv_frag_home_realtime_hot_post_2_board_type = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_2_board_type);
        tv_frag_home_realtime_hot_post_2_like_num = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_2_like_num);
        tv_frag_home_realtime_hot_post_2_comment_num = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_2_comment_num);
    }
    public void viewBindHotPost() {
        tv_frag_home_hot_post_1_title = viewGroup.findViewById(R.id.tv_frag_home_hot_post_1_title);
        tv_frag_home_hot_post_1_time = viewGroup.findViewById(R.id.tv_frag_home_hot_post_1_time);
        tv_frag_home_hot_post_1_like_num = viewGroup.findViewById(R.id.tv_frag_home_hot_post_1_like_num);
        tv_frag_home_hot_post_1_comment_num = viewGroup.findViewById(R.id.tv_frag_home_hot_post_1_comment_num);

        tv_frag_home_hot_post_2_title = viewGroup.findViewById(R.id.tv_frag_home_hot_post_2_title);
        tv_frag_home_hot_post_2_time = viewGroup.findViewById(R.id.tv_frag_home_hot_post_2_time);
        tv_frag_home_hot_post_2_like_num = viewGroup.findViewById(R.id.tv_frag_home_hot_post_2_like_num);
        tv_frag_home_hot_post_2_comment_num = viewGroup.findViewById(R.id.tv_frag_home_hot_post_2_comment_num);

        tv_frag_home_hot_post_3_title = viewGroup.findViewById(R.id.tv_frag_home_hot_post_3_title);
        tv_frag_home_hot_post_3_time = viewGroup.findViewById(R.id.tv_frag_home_hot_post_3_time);
        tv_frag_home_hot_post_3_like_num = viewGroup.findViewById(R.id.tv_frag_home_hot_post_3_like_num);
        tv_frag_home_hot_post_3_comment_num = viewGroup.findViewById(R.id.tv_frag_home_hot_post_3_comment_num);

        tv_frag_home_hot_post_4_title = viewGroup.findViewById(R.id.tv_frag_home_hot_post_4_title);
        tv_frag_home_hot_post_4_time = viewGroup.findViewById(R.id.tv_frag_home_hot_post_4_time);
        tv_frag_home_hot_post_4_like_num = viewGroup.findViewById(R.id.tv_frag_home_hot_post_4_like_num);
        tv_frag_home_hot_post_4_comment_num = viewGroup.findViewById(R.id.tv_frag_home_hot_post_4_comment_num);
    }

    @Override
    public void realTimeHotPostSuccess(RealTimeHotPostResponse realTimeHotPostResponse) {
        switch (realTimeHotPostResponse.getCode()){
            case 100:
                tv_frag_home_realtime_hot_post_1_user_name.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(0).getContentWriter());
                tv_frag_home_realtime_hot_post_1_date.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(0).getWriteDay());
                tv_frag_home_realtime_hot_post_1_title.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(0).getContentTitle());
                tv_frag_home_realtime_hot_post_1_content.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(0).getContentInf());
                tv_frag_home_realtime_hot_post_1_board_type.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(0).getNoticeName());
                tv_frag_home_realtime_hot_post_1_like_num.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(0).getCountLike());
                tv_frag_home_realtime_hot_post_1_comment_num.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(0).getCountComment());

                tv_frag_home_realtime_hot_post_2_user_name.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(1).getContentWriter());
                tv_frag_home_realtime_hot_post_2_date.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(1).getWriteDay());
                tv_frag_home_realtime_hot_post_2_title.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(1).getContentTitle());
                tv_frag_home_realtime_hot_post_2_content.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(1).getContentInf());
                tv_frag_home_realtime_hot_post_2_board_type.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(1).getNoticeName());
                tv_frag_home_realtime_hot_post_2_like_num.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(1).getCountLike());
                tv_frag_home_realtime_hot_post_2_comment_num.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(1).getCountComment());
                break;
        }
    }

    @Override
    public void hotPostSuccess(HotPostResponse hotPostResponse) {
        switch (hotPostResponse.getCode()) {

            case 100:
                int num_of_hot_posts = hotPostResponse.getHotPostResults().size();

                switch (num_of_hot_posts){
                    case 0:
                        break;
                    case 1:
                        tv_frag_home_hot_post_1_title.setText(hotPostResponse.getHotPostResults().get(0).getContentTitle());
                        tv_frag_home_hot_post_1_time.setText(hotPostResponse.getHotPostResults().get(0).getWriteDay());
                        tv_frag_home_hot_post_1_like_num.setText(hotPostResponse.getHotPostResults().get(0).getCountLike());
                        tv_frag_home_hot_post_1_comment_num.setText(hotPostResponse.getHotPostResults().get(0).getCountComment());
                        break;
                    case 2:
                        tv_frag_home_hot_post_1_title.setText(hotPostResponse.getHotPostResults().get(0).getContentTitle());
                        tv_frag_home_hot_post_1_time.setText(hotPostResponse.getHotPostResults().get(0).getWriteDay());
                        tv_frag_home_hot_post_1_like_num.setText(hotPostResponse.getHotPostResults().get(0).getCountLike());
                        tv_frag_home_hot_post_1_comment_num.setText(hotPostResponse.getHotPostResults().get(0).getCountComment());

                        tv_frag_home_hot_post_2_title.setText(hotPostResponse.getHotPostResults().get(1).getContentTitle());
                        tv_frag_home_hot_post_2_time.setText(hotPostResponse.getHotPostResults().get(1).getWriteDay());
                        tv_frag_home_hot_post_2_like_num.setText(hotPostResponse.getHotPostResults().get(1).getCountLike());
                        tv_frag_home_hot_post_2_comment_num.setText(hotPostResponse.getHotPostResults().get(1).getCountComment());
                        break;
                    case 3:
                        tv_frag_home_hot_post_1_title.setText(hotPostResponse.getHotPostResults().get(0).getContentTitle());
                        tv_frag_home_hot_post_1_time.setText(hotPostResponse.getHotPostResults().get(0).getWriteDay());
                        tv_frag_home_hot_post_1_like_num.setText(hotPostResponse.getHotPostResults().get(0).getCountLike());
                        tv_frag_home_hot_post_1_comment_num.setText(hotPostResponse.getHotPostResults().get(0).getCountComment());

                        tv_frag_home_hot_post_2_title.setText(hotPostResponse.getHotPostResults().get(1).getContentTitle());
                        tv_frag_home_hot_post_2_time.setText(hotPostResponse.getHotPostResults().get(1).getWriteDay());
                        tv_frag_home_hot_post_2_like_num.setText(hotPostResponse.getHotPostResults().get(1).getCountLike());
                        tv_frag_home_hot_post_2_comment_num.setText(hotPostResponse.getHotPostResults().get(1).getCountComment());

                        tv_frag_home_hot_post_3_title.setText(hotPostResponse.getHotPostResults().get(2).getContentTitle());
                        tv_frag_home_hot_post_3_time.setText(hotPostResponse.getHotPostResults().get(2).getWriteDay());
                        tv_frag_home_hot_post_3_like_num.setText(hotPostResponse.getHotPostResults().get(2).getCountLike());
                        tv_frag_home_hot_post_3_comment_num.setText(hotPostResponse.getHotPostResults().get(2).getCountComment());
                    default:
                        tv_frag_home_hot_post_1_title.setText(hotPostResponse.getHotPostResults().get(0).getContentTitle());
                        tv_frag_home_hot_post_1_time.setText(hotPostResponse.getHotPostResults().get(0).getWriteDay());
                        tv_frag_home_hot_post_1_like_num.setText(hotPostResponse.getHotPostResults().get(0).getCountLike());
                        tv_frag_home_hot_post_1_comment_num.setText(hotPostResponse.getHotPostResults().get(0).getCountComment());

                        tv_frag_home_hot_post_2_title.setText(hotPostResponse.getHotPostResults().get(1).getContentTitle());
                        tv_frag_home_hot_post_2_time.setText(hotPostResponse.getHotPostResults().get(1).getWriteDay());
                        tv_frag_home_hot_post_2_like_num.setText(hotPostResponse.getHotPostResults().get(1).getCountLike());
                        tv_frag_home_hot_post_2_comment_num.setText(hotPostResponse.getHotPostResults().get(1).getCountComment());

                        tv_frag_home_hot_post_3_title.setText(hotPostResponse.getHotPostResults().get(2).getContentTitle());
                        tv_frag_home_hot_post_3_time.setText(hotPostResponse.getHotPostResults().get(2).getWriteDay());
                        tv_frag_home_hot_post_3_like_num.setText(hotPostResponse.getHotPostResults().get(2).getCountLike());
                        tv_frag_home_hot_post_3_comment_num.setText(hotPostResponse.getHotPostResults().get(2).getCountComment());

                        tv_frag_home_hot_post_4_title.setText(hotPostResponse.getHotPostResults().get(3).getContentTitle());
                        tv_frag_home_hot_post_4_time.setText(hotPostResponse.getHotPostResults().get(3).getWriteDay());
                        tv_frag_home_hot_post_4_like_num.setText(hotPostResponse.getHotPostResults().get(3).getCountLike());
                        tv_frag_home_hot_post_4_comment_num.setText(hotPostResponse.getHotPostResults().get(3).getCountComment());
                        break;
                }
        }
    }


}
