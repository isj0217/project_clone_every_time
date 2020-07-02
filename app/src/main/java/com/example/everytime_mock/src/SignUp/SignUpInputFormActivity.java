package com.example.everytime_mock.src.signup2_inputForms;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.BaseActivity;
import com.example.everytime_mock.src.signup1_agreement.interfaces.SignUpInputFormActivityView;
import com.example.everytime_mock.src.signup2_inputForms.models.SignUpResponse;

import java.util.HashMap;

public class SignUpInputForm2_Activity extends BaseActivity implements SignUpInputFormActivityView {

    // logIn화면
//    Button btn_signUp;

    // signUp 화면 1
    Spinner spinner_entranceYear;
//    EditText et_univName;
    String mSelectedEntranceYear;

    // signUp 화면 2
    private EditText et_signup2_ID, et_signup2_PW, et_signup2_PW_again, et_signup2_email, et_signup2_nickName, et_signup2_univName, et_signup2_univYear, et_signup2_phoneNum;
    private Button btn_signUp;
    private Signup2_Service signup2_service;

    private void initEditTexts() {
        et_signup2_ID = findViewById(R.id.et_signup2_id);
        et_signup2_PW = findViewById(R.id.et_signup2_pw);
        et_signup2_PW_again = findViewById(R.id.et_signup2_pw_again);
        et_signup2_email = findViewById(R.id.et_signup2_email);
        et_signup2_nickName = findViewById(R.id.et_signup2_nickName);
        et_signup2_univName = findViewById(R.id.et_signup2_univName);
        et_signup2_univYear = findViewById(R.id.et_signup2_univYear);
        et_signup2_phoneNum = findViewById(R.id.et_signup2_phoneNum);
    }
    private void initButton() {
        btn_signUp = findViewById(R.id.btn_signup2_signUp);
        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_signup2_ID.getText().toString().equals("") ||
                    et_signup2_PW.getText().toString().equals("") ||
                    et_signup2_PW_again.getText().toString().equals("") ||
                    et_signup2_email.getText().toString().equals("") ||
                    et_signup2_nickName.getText().toString().equals("") ||
                    et_signup2_univName.getText().toString().equals("") ||
                    et_signup2_univYear.getText().toString().equals("") ||
                    et_signup2_phoneNum.getText().toString().equals("")){
                    showCustomToast("모든 칸에 정보를 입력해주세요");
                }else if(!et_signup2_PW.getText().toString().equals(et_signup2_PW_again.getText().toString())){
                    showCustomToast("두 비밀번호가 일치하지 않습니다");
                }else{
                    String inputID = et_signup2_ID.getText().toString();
                    String inputPW = et_signup2_PW.getText().toString();
                    String inputPWAgain = et_signup2_PW_again.getText().toString();
                    String inputEmail = et_signup2_email.getText().toString();
                    String inputNickName = et_signup2_nickName.getText().toString();
                    String inputUnivName = et_signup2_univName.getText().toString();
                    String inputUnivYear = et_signup2_univYear.getText().toString();
                    String inputPhoneNum = et_signup2_phoneNum.getText().toString();

                    // todo
                    /**
                     * 사용자가 입력한 8개의 String들을 쿼리로 묶어서 서버로 보내고 싶은데
                     * 이번에 받은 템플릿에서 그 과정을 어떻게 하는지 전혀 감이 안옵니다 ㅠㅠ
                     * */

                    tryPostSignUp();
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2_information_forms);
        signup2_service = new Signup2_Service(this);

        initEditTexts();
        initButton();

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

    private void tryPostSignUp() {
        showProgressDialog();

        HashMap<String, Object> params = new HashMap<>();
        params.put("userID", "jackson1116");
        params.put("pw", "1111");
        params.put("userNickname", "1199");
        params.put("phoneNum", "01012345678");
        params.put("univName", "솦퀘대학교");
        params.put("univYear", "2015");
        params.put("email", "js@sleep.co.kr");

        final Signup2_Service signup2_service = new Signup2_Service(this, params);
        signup2_service.postSignUp();

//        final Signup_1_Service mainService = new Signup_1_Service(this);
//        mainService.getTest();
    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();
        showCustomToast(text);
    }

    @Override
    public void validateFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    @Override
    public void signUpSuccess(SignUpResponse.SignUpResult signUpResult) {
//        hideProgressDialog();
        System.out.println("받은 jwt값: " +signUpResult.getJwt());
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
