package com.example.everytime_mock.src.main.frag_board;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.main.frag_board.interfaces.FragBoardView;
import com.example.everytime_mock.src.main.frag_board.models.FavoriteBoardResponse;
import com.google.android.material.tabs.TabLayout;

public class FragBoard extends Fragment implements FragBoardView {
    ViewGroup viewGroup;
    private FragmentPagerAdapter fragmentPagerAdapter;

    private ImageView iv_frag_board_all_pin_free, iv_frag_board_all_pin_secret, iv_frag_board_all_pin_alumni, iv_frag_board_all_pin_freshmen;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.frag_board_view_pager, container, false);

        ViewPager vp_frag_board = (ViewPager) viewGroup.findViewById(R.id.vp_frag_board);
//        fragmentPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager()); // 계속 화면이 사라지는 현상 발생
        fragmentPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());

        TabLayout tabLayout = viewGroup.findViewById(R.id.tabLayout);
        vp_frag_board.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(vp_frag_board);

        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#000000"));
//        tabLayout.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));
        tabLayout.setTabTextColors(Color.parseColor("#666666"), Color.parseColor("#000000"));


        iv_frag_board_all_pin_free = viewGroup.findViewById(R.id.iv_frag_board_all_pin_free);
        iv_frag_board_all_pin_secret = viewGroup.findViewById(R.id.iv_frag_board_all_pin_secret);
        iv_frag_board_all_pin_alumni = viewGroup.findViewById(R.id.iv_frag_board_all_pin_alumni);
        iv_frag_board_all_pin_freshmen = viewGroup.findViewById(R.id.iv_frag_board_all_pin_freshmen);

//        iv_frag_board_all_pin_free.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tryPostFavoriteBoard(1);
//            }
//        });
//
//        iv_frag_board_all_pin_secret.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tryPostFavoriteBoard(2);
//            }
//        });
//
//
//        iv_frag_board_all_pin_alumni.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tryPostFavoriteBoard(3);
//            }
//        });
//
//        iv_frag_board_all_pin_freshmen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tryPostFavoriteBoard(4);
//            }
//        });



        return viewGroup;
    }

    public void tryPostFavoriteBoard(int index) {
        FragBoardService fragBoardService = new FragBoardService(this);
        fragBoardService.postFavoriteBoard(index);
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void favoriteBoardSuccess(FavoriteBoardResponse favoriteBoardResponse) {
        switch (favoriteBoardResponse.getCode()) {
            case 100:
                System.out.println("추가 성공!!");
                // 즐겨찾기 추가 성공
                break;
            case 101:
                System.out.println("해제 성공!!");
                // 즐겨찾기 해제 성공
                break;

        }
    }
}
