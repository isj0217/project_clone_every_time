package com.example.everytime_mock.src.Main.frag_board;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.everytime_mock.R;
import com.google.android.material.tabs.TabLayout;

public class FragBoard extends Fragment {
    ViewGroup viewGroup;
    private FragmentPagerAdapter fragmentPagerAdapter;

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

        return viewGroup;
    }
}
