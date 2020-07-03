package com.example.everytime_mock.src.Home;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.BaseActivity;
import com.example.everytime_mock.src.Home.interfaces.HomeActivityView;
import com.example.everytime_mock.src.Home.models.FragmentHome;
import com.example.everytime_mock.src.Home.models.FragmentBoard;
import com.example.everytime_mock.src.Home.models.FragmentTimeTable;
import com.example.everytime_mock.src.Home.models.FragmentNotification;
import com.example.everytime_mock.src.Home.models.FragmentCampusPick;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends BaseActivity implements HomeActivityView {

    BottomNavigationView bottomNavigationView;
    FragmentHome fragmentHome_home;
    FragmentBoard fragmentBoard_board;
    FragmentTimeTable fragmentTimeTable_timetable;
    FragmentNotification fragmentNotification_notification;
    FragmentCampusPick fragmentCampusPick_campuspick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // activity_home
        bottomNavigationView = findViewById(R.id.bottomNavigationView); //프래그먼트 생성

        fragmentHome_home = new FragmentHome();
        fragmentBoard_board = new FragmentBoard();
        fragmentTimeTable_timetable = new FragmentTimeTable();
        fragmentNotification_notification = new FragmentNotification();
        fragmentCampusPick_campuspick = new FragmentCampusPick(); //제일 처음 띄워줄 뷰를 세팅해줍니다. commit();까지 해줘야 합니다.

        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragmentHome_home).commitAllowingStateLoss(); //bottomnavigationview의 아이콘을 선택 했을때 원하는 프래그먼트가 띄워질 수 있도록 리스너를 추가합니다.

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) { //menu_bottom.xml에서 지정해줬던 아이디 값을 받아와서 각 아이디값마다 다른 이벤트를 발생시킵니다.
                    case R.id.tab1: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragmentHome_home).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.tab2: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragmentBoard_board).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.tab3: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragmentTimeTable_timetable).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.tab4: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragmentNotification_notification).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.tab5: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragmentCampusPick_campuspick).commitAllowingStateLoss();
                        return true;
                    }
                    default:
                        return false;
                }
            }
        });

















        // 여기까지 activity_home

    }

    private void tryGetTest() {
        showProgressDialog();

        final HomeService homeService = new HomeService(this);
        homeService.getTest();
    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();
    }

    @Override
    public void validateFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    public void customOnClick(View view) {
        switch (view.getId()) {
//            case R.id.main_btn_hello_world:
//                tryGetTest();
//                break;
            default:
                break;
        }
    }
}
