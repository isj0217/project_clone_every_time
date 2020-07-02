package com.example.everytime_mock.src.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
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
import com.example.everytime_mock.src.signup1_agreement.Signup1_Activity;
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
//    Button btn_signUp;

    // signUp 화면 1
    Spinner spinner_entranceYear;
    EditText et_univName;
    String mSelectedEntranceYear;

    // signUp 화면 2
    ScrollView parentScrollView, childScrollView_1, childScrollView_2, childScrollView_3, childScrollView_4, childScrollView_5, childScrollView_6;


    // main_login
    private EditText et_mainLogin_userID;
    private EditText et_mainLogin_userPW;
    private Button btn_login;
    private Button btn_signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_log_in);

        et_mainLogin_userID = findViewById(R.id.et_logIn_id);
        et_mainLogin_userPW = findViewById(R.id.et_logIn_pw);
        btn_login = findViewById(R.id.btn_logIn_logIn);
        btn_signUp = findViewById(R.id.btn_logIn_signUp);

        // 로그인 버튼을 누를 때
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_mainLogin_userID.getText().toString().equals("") && et_mainLogin_userPW.getText().toString().equals("")){
                    showCustomToast("아이디와 비밀번호를 입력해주세요");
                }else if (et_mainLogin_userID.getText().toString().equals("")){
                    showCustomToast("아이디를 입력해주세요");
                }else if (et_mainLogin_userPW.getText().toString().equals("")){
                    showCustomToast("비밀번호를 입력해주세요");
                }else{
                    String inputID = et_mainLogin_userID.getText().toString();
                    String inputPW = et_mainLogin_userPW.getText().toString();

                    // todo
                    // 아이디와 비밀번호 칸을 모두 채운 경우에는 담아서 서버로 보낸다.

                }
            }
        });

        // 회원가입 버튼을 누를 때
        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // todo
                // 회원가입 액티비티로 보낸다.

                Intent intent = new Intent(MainActivity.this, Signup1_Activity.class);
                startActivity(intent);
//                finish();
            }
        });
















//        signUp 화면 2
//        parentScrollView = findViewById(R.id.parent_scrollView);
//        childScrollView_1 = findViewById(R.id.child_scrollView_1);
//        childScrollView_2 = findViewById(R.id.child_scrollView_2);
//        childScrollView_3 = findViewById(R.id.child_scrollView_3);
//        childScrollView_4 = findViewById(R.id.child_scrollView_4);
//        childScrollView_5 = findViewById(R.id.child_scrollView_5);
//        childScrollView_6 = findViewById(R.id.child_scrollView_6);
//
//        childScrollView_1.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_UP)
//                    parentScrollView.requestDisallowInterceptTouchEvent(false);
//                else
//                    parentScrollView.requestDisallowInterceptTouchEvent(true);
//                return false;
//            }
//        });
//
//        childScrollView_2.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_UP)
//                    parentScrollView.requestDisallowInterceptTouchEvent(false);
//                else
//                    parentScrollView.requestDisallowInterceptTouchEvent(true);
//                return false;
//            }
//        });
//
//        childScrollView_3.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_UP)
//                    parentScrollView.requestDisallowInterceptTouchEvent(false);
//                else
//                    parentScrollView.requestDisallowInterceptTouchEvent(true);
//                return false;
//            }
//        });
//
//        childScrollView_4.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_UP)
//                    parentScrollView.requestDisallowInterceptTouchEvent(false);
//                else
//                    parentScrollView.requestDisallowInterceptTouchEvent(true);
//                return false;
//            }
//        });
//
//        childScrollView_5.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_UP)
//                    parentScrollView.requestDisallowInterceptTouchEvent(false);
//                else
//                    parentScrollView.requestDisallowInterceptTouchEvent(true);
//                return false;
//            }
//        });
//
//        childScrollView_6.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_UP)
//                    parentScrollView.requestDisallowInterceptTouchEvent(false);
//                else
//                    parentScrollView.requestDisallowInterceptTouchEvent(true);
//                return false;
//            }
//        });











        // signUp 화면 1
//        spinner_entranceYear = findViewById(R.id.spinner_signUp_entranceYear);
//        ArrayAdapter entranceYearAdapter = ArrayAdapter.createFromResource(this, R.array.entranceYears, android.R.layout.simple_spinner_dropdown_item);
//        entranceYearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner_entranceYear.setAdapter(entranceYearAdapter);
//
//        spinner_entranceYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                mSelectedEntranceYear = (String)spinner_entranceYear.getItemAtPosition(position);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {}
//        });



















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
