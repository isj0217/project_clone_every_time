package com.example.everytime_mock.src.signup1_agreement;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.BaseActivity;
import com.example.everytime_mock.src.home.HomeActivity;
import com.example.everytime_mock.src.signup1_agreement.interfaces.SignUpAgreementActivityView;
import com.example.everytime_mock.src.signup2_inputForms.SignUpInputForm2_Activity;

public class SignUpAgreementActivity extends BaseActivity implements SignUpAgreementActivityView {
    private TextView mTvHelloWorld;

    // logIn화면
//    Button btn_signUp;

    // signUp 화면 (없애기로 한 화면)
    Spinner spinner_entranceYear;
    EditText et_univName;
    String mSelectedEntranceYear;

    // signUp 화면 1
    private ScrollView parentScrollView, childScrollView_1, childScrollView_2, childScrollView_3, childScrollView_4, childScrollView_5, childScrollView_6;
    private CheckBox chkAll, chk_1, chk_2, chk_3, chk_4, chk_5, chk_6;
    private Button btn_signUp_1_phoneCertification, btn_signUp_1_gotoSignUp_2;

    private void initCheckBoxes() {
        chkAll = findViewById(R.id.chk_all);
        chk_1 = findViewById(R.id.chk_1);
        chk_2 = findViewById(R.id.chk_2);
        chk_3 = findViewById(R.id.chk_3);
        chk_4 = findViewById(R.id.chk_4);
        chk_5 = findViewById(R.id.chk_5);
        chk_6 = findViewById(R.id.chk_6);

        chkAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chkAll.isChecked()){
                    chk_1.setChecked(true);
                    chk_2.setChecked(true);
                    chk_3.setChecked(true);
                    chk_4.setChecked(true);
                    chk_5.setChecked(true);
                    chk_6.setChecked(true);
                }else if(!chkAll.isChecked()){
                    chk_1.setChecked(false);
                    chk_2.setChecked(false);
                    chk_3.setChecked(false);
                    chk_4.setChecked(false);
                    chk_5.setChecked(false);
                    chk_6.setChecked(false);
                }
            }
        });

        chk_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk_1.isChecked() && chk_2.isChecked() && chk_3.isChecked() && chk_4.isChecked() && chk_5.isChecked() && chk_6.isChecked()){
                    chkAll.setChecked(true);
                }else if (chkAll.isChecked() && !chk_1.isChecked()){
                    chkAll.setChecked(false);
                }
            }
        });

        chk_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk_1.isChecked() && chk_2.isChecked() && chk_3.isChecked() && chk_4.isChecked() && chk_5.isChecked() && chk_6.isChecked()){
                    chkAll.setChecked(true);
                }else if (chkAll.isChecked() && !chk_2.isChecked()){
                    chkAll.setChecked(false);
                }
            }
        });

        chk_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk_1.isChecked() && chk_2.isChecked() && chk_3.isChecked() && chk_4.isChecked() && chk_5.isChecked() && chk_6.isChecked()){
                    chkAll.setChecked(true);
                }else if (chkAll.isChecked() && !chk_3.isChecked()){
                    chkAll.setChecked(false);
                }
            }
        });

        chk_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk_1.isChecked() && chk_2.isChecked() && chk_3.isChecked() && chk_4.isChecked() && chk_5.isChecked() && chk_6.isChecked()){
                    chkAll.setChecked(true);
                }else if (chkAll.isChecked() && !chk_4.isChecked()){
                    chkAll.setChecked(false);
                }
            }
        });

        chk_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk_1.isChecked() && chk_2.isChecked() && chk_3.isChecked() && chk_4.isChecked() && chk_5.isChecked() && chk_6.isChecked()){
                    chkAll.setChecked(true);
                }else if (chkAll.isChecked() && !chk_5.isChecked()){
                    chkAll.setChecked(false);
                }
            }
        });

        chk_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk_1.isChecked() && chk_2.isChecked() && chk_3.isChecked() && chk_4.isChecked() && chk_5.isChecked() && chk_6.isChecked()){
                    chkAll.setChecked(true);
                }else if (chkAll.isChecked() && !chk_6.isChecked()){
                    chkAll.setChecked(false);
                }
            }
        });
    }
    private void initScrollViews() {
        parentScrollView = findViewById(R.id.parent_scrollView);
        childScrollView_1 = findViewById(R.id.child_scrollView_1);
        childScrollView_2 = findViewById(R.id.child_scrollView_2);
        childScrollView_3 = findViewById(R.id.child_scrollView_3);
        childScrollView_4 = findViewById(R.id.child_scrollView_4);
        childScrollView_5 = findViewById(R.id.child_scrollView_5);
        childScrollView_6 = findViewById(R.id.child_scrollView_6);

        childScrollView_1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP)
                    parentScrollView.requestDisallowInterceptTouchEvent(false);
                else
                    parentScrollView.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        childScrollView_2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP)
                    parentScrollView.requestDisallowInterceptTouchEvent(false);
                else
                    parentScrollView.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        childScrollView_3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP)
                    parentScrollView.requestDisallowInterceptTouchEvent(false);
                else
                    parentScrollView.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        childScrollView_4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP)
                    parentScrollView.requestDisallowInterceptTouchEvent(false);
                else
                    parentScrollView.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        childScrollView_5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP)
                    parentScrollView.requestDisallowInterceptTouchEvent(false);
                else
                    parentScrollView.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        childScrollView_6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP)
                    parentScrollView.requestDisallowInterceptTouchEvent(false);
                else
                    parentScrollView.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
    }
    private void initButtons() {
        btn_signUp_1_phoneCertification = findViewById(R.id.btn_signUp_1_phoneCertification);
        btn_signUp_1_phoneCertification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showCustomToast("아직 개발중입니다");
                Intent intent = new Intent(SignUpAgreementActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btn_signUp_1_gotoSignUp_2 = findViewById(R.id.btn_signUp_1_gotoSignUp_2);
        btn_signUp_1_gotoSignUp_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (chk_1.isChecked() && chk_2.isChecked() && chk_3.isChecked()){
                    Intent intent = new Intent(SignUpAgreementActivity.this, SignUpInputForm2_Activity.class);
                    startActivity(intent);
//                    finish();
                }else{
                    showCustomToast("필수항목에 모두 동의해주세요");
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1_agreement);

        initCheckBoxes();
        initScrollViews();
        initButtons();








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

//        bottomNavigationView = findViewById(R.id.bottomNavigationView); //프래그먼트 생성
//
//        fragment1_home = new Fragment1();
//        fragment2_board = new Fragment2();
//        fragment3_timetable = new Fragment3();
//        fragment4_notification = new Fragment4();
//        fragment5_campuspick = new Fragment5(); //제일 처음 띄워줄 뷰를 세팅해줍니다. commit();까지 해줘야 합니다.

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

//    private void tryGetTest() {
//        showProgressDialog();
//
//        final Signup_1_Service mainService = new Signup_1_Service(this);
//        mainService.getTest();
//    }

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
            case R.id.chk_2:
                //
                break;
            default:
                break;
        }
    }
}
