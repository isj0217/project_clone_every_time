package com.example.everytime_mock.src.Main.frag_board;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    /**
     * 프래그먼트 교체를 보여주는 처리
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FragBoardAll.newInstance();
            case 1:
                return FragBoardInformation.newInstance();
            case 2:
                return FragBoardAdvertisement.newInstance();
            case 3:
                return FragBoardGroup.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }


    /**
     * 상단의 탭 레이아웃 인디케이터쪽에 텍스트를 선언해주는 곳
     */
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "전체";
            case 1:
                return "정보";
            case 2:
                return "홍보";
            case 3:
                return "단체";
            default:
                return null;
        }
    }
}
