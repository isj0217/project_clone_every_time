package com.example.everytime_mock.src.Main;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.BaseActivity;
import com.example.everytime_mock.src.Main.interfaces.MainActivityView;
import com.example.everytime_mock.src.Main.frag_home.FragHome;
import com.example.everytime_mock.src.Main.models.FragBoard;
import com.example.everytime_mock.src.Main.models.FragTimeTable;
import com.example.everytime_mock.src.Main.models.FragNotification;
import com.example.everytime_mock.src.Main.models.FragCampusPick;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity implements MainActivityView {

    BottomNavigationView bottomNavigationView;
    FragHome fragHome_home;
    FragBoard frag2Board_board;
    FragTimeTable fragTimeTable_timetable;
    FragNotification fragNotification_notification;
    FragCampusPick fragCampusPick_campuspick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // activity_main
        bottomNavigationView = findViewById(R.id.bottomNavigationView); //프래그먼트 생성

        fragHome_home = new FragHome();
        frag2Board_board = new FragBoard();
        fragTimeTable_timetable = new FragTimeTable();
        fragNotification_notification = new FragNotification();
        fragCampusPick_campuspick = new FragCampusPick();

        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragHome_home).commitAllowingStateLoss(); //bottomnavigationview의 아이콘을 선택 했을때 원하는 프래그먼트가 띄워질 수 있도록 리스너를 추가합니다.

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) { //menu_bottom.xml에서 지정해줬던 아이디 값을 받아와서 각 아이디값마다 다른 이벤트를 발생시킵니다.
                    case R.id.tab1: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragHome_home).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.tab2: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, frag2Board_board).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.tab3: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragTimeTable_timetable).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.tab4: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragNotification_notification).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.tab5: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragCampusPick_campuspick).commitAllowingStateLoss();
                        return true;
                    }
                    default:
                        return false;
                }
            }
        });

















        // 여기까지 activity_main

    }

    private void tryGetTest() {
        showProgressDialog();

        final MainService mainService = new MainService(this);
        mainService.getTest();
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
