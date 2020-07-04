package com.example.everytime_mock.src.SignIn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.BaseActivity;
import com.example.everytime_mock.src.Main.MainActivity;
import com.example.everytime_mock.src.SignIn.interfaces.SignInActivityView;
import com.example.everytime_mock.src.SignIn.models.SignInResponse;
import com.example.everytime_mock.src.SignUp.SignUpAgreementActivity;

import static com.example.everytime_mock.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.everytime_mock.src.ApplicationClass.sSharedPreferences;

import java.util.HashMap;

public class SignInActivity extends BaseActivity implements SignInActivityView {

    private EditText et_mainLogin_userID;
    private EditText et_mainLogin_userPW;
    private Button btn_login;
    private Button btn_signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sSharedPreferences = getSharedPreferences("jwt", MODE_PRIVATE);
        String jwt = sSharedPreferences.getString("jwt", null);

        if (jwt == null) {
            setContentView(R.layout.activity_sign_in);

            et_mainLogin_userID = findViewById(R.id.et_logIn_id);
            et_mainLogin_userPW = findViewById(R.id.et_logIn_pw);
            btn_login = findViewById(R.id.btn_logIn_logIn);
            btn_signUp = findViewById(R.id.btn_logIn_signUp);

            // 로그인 버튼을 누를 때
            btn_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (et_mainLogin_userID.getText().toString().equals("") && et_mainLogin_userPW.getText().toString().equals("")) {
                        showCustomToast("아이디와 비밀번호를 입력해주세요");
                    } else if (et_mainLogin_userID.getText().toString().equals("")) {
                        showCustomToast("아이디를 입력해주세요");
                    } else if (et_mainLogin_userPW.getText().toString().equals("")) {
                        showCustomToast("비밀번호를 입력해주세요");
                    } else {
                        String inputID = et_mainLogin_userID.getText().toString();
                        String inputPW = et_mainLogin_userPW.getText().toString();

                        // todo
                        // 아이디와 비밀번호 칸을 모두 채운 경우에는 담아서 서버로 보낸다.

                        tryPostSignIn(inputID, inputPW);
                    }
                }
            });

            // 회원가입 버튼을 누를 때
            btn_signUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(SignInActivity.this, SignUpAgreementActivity.class);
                    startActivity(intent);
                }
            });

        }else{ // sSharedPreference가 비어있지 않다면 자동 로그인!!
            X_ACCESS_TOKEN = sSharedPreferences.getString ("jwt","");

            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }

    private void tryPostSignIn(String inputID, String inputPW) {
        showProgressDialog();

        HashMap<String, Object> params = new HashMap<>();
        params.put("userID", inputID);
        params.put("pw", inputPW);

        final SignInService signInService = new SignInService(this, params);
        signInService.postSignIn();
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

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void signInSuccess(SignInResponse signInResponse) {
        hideProgressDialog();

        switch (signInResponse.getCode()) {
            case 100:
                sSharedPreferences = getSharedPreferences("jwt", MODE_PRIVATE);
                SharedPreferences.Editor editor = sSharedPreferences.edit();
                editor.putString("jwt", signInResponse.getSignInResult().getJwt());
                editor.apply();

                X_ACCESS_TOKEN =sSharedPreferences.getString ("jwt","");

                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                showCustomToast("아이디와 비밀번호가 틀립니다");
                break;
        }
    }
}
