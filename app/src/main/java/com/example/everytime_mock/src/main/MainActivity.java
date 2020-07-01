package com.example.everytime_mock.src.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.BaseActivity;
import com.example.everytime_mock.src.main.interfaces.MainActivityView;
import com.example.everytime_mock.src.main.models.Fragment1;
import com.example.everytime_mock.src.main.models.Fragment2;
import com.example.everytime_mock.src.main.models.Fragment3;
import com.example.everytime_mock.src.main.models.Fragment4;
import com.example.everytime_mock.src.main.models.Fragment5;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity implements MainActivityView {
    private TextView mTvHelloWorld;

    BottomNavigationView bottomNavigationView;
    Fragment1 fragment1_home;
    Fragment2 fragment2_board;
    Fragment3 fragment3_timetable;
    Fragment4 fragment4_notification;
    Fragment5 fragment5_campuspick;

    // logIn화면
    Button btn_signUp;

    // signUp 화면 1
    Spinner spinner_entranceYear;
    String mSelectedEntranceYear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_choose_univ);



        // signUp 화면 1
        spinner_entranceYear = findViewById(R.id.spinner_signUp_entranceYear);
        ArrayAdapter entranceYearAdapter = ArrayAdapter.createFromResource(this, R.array.entranceYears, android.R.layout.simple_spinner_dropdown_item);
        entranceYearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_entranceYear.setAdapter(entranceYearAdapter);

        spinner_entranceYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSelectedEntranceYear = (String)spinner_entranceYear.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

















        // activity_main

        bottomNavigationView = findViewById(R.id.bottomNavigationView); //프래그먼트 생성

        fragment1_home = new Fragment1();
        fragment2_board = new Fragment2();
        fragment3_timetable = new Fragment3();
        fragment4_notification = new Fragment4();
        fragment5_campuspick = new Fragment5(); //제일 처음 띄워줄 뷰를 세팅해줍니다. commit();까지 해줘야 합니다.

//        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment1_home).commitAllowingStateLoss(); //bottomnavigationview의 아이콘을 선택 했을때 원하는 프래그먼트가 띄워질 수 있도록 리스너를 추가합니다.

//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                switch (menuItem.getItemId()) { //menu_bottom.xml에서 지정해줬던 아이디 값을 받아와서 각 아이디값마다 다른 이벤트를 발생시킵니다.
//                    case R.id.tab1: {
//                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment1_home).commitAllowingStateLoss();
//                        return true;
//                    }
//                    case R.id.tab2: {
//                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment2_board).commitAllowingStateLoss();
//                        return true;
//                    }
//                    case R.id.tab3: {
//                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment3_timetable).commitAllowingStateLoss();
//                        return true;
//                    }
//                    case R.id.tab4: {
//                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment4_notification).commitAllowingStateLoss();
//                        return true;
//                    }
//                    case R.id.tab5: {
//                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment5_campuspick).commitAllowingStateLoss();
//                        return true;
//                    }
//                    default:
//                        return false;
//                }
//            }
//        });

        // 여기까지 activity_main



//        mTvHelloWorld = findViewById(R.id.main_tv_hello_world);
    }

    private void tryGetTest() {
        showProgressDialog();

        final MainService mainService = new MainService(this);
        mainService.getTest();
    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();
        mTvHelloWorld.setText(text);
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
