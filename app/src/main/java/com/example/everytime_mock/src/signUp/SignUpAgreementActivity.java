package com.example.everytime_mock.src.SignUp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ScrollView;

import androidx.annotation.Nullable;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.BaseActivity;
import com.example.everytime_mock.src.SignUp.interfaces.SignUpAgreementActivityView;

public class SignUpAgreementActivity extends BaseActivity implements SignUpAgreementActivityView {

    private ScrollView parentScrollView, childScrollView_1, childScrollView_2, childScrollView_3, childScrollView_4, childScrollView_5, childScrollView_6;
    private CheckBox chkAll, chk_1, chk_2, chk_3, chk_4, chk_5, chk_6;
    private Button btn_signUp_1_goNext;

    private void initCheckBoxes() {
        chkAll = findViewById(R.id.chk_sign_up_agreement_all);
        chk_1 = findViewById(R.id.chk_sign_up_agreement_1);
        chk_2 = findViewById(R.id.chk_sign_up_agreement_2);
        chk_3 = findViewById(R.id.chk_sign_up_agreement_3);
        chk_4 = findViewById(R.id.chk_sign_up_agreement_4);
        chk_5 = findViewById(R.id.chk_sign_up_agreement_5);
        chk_6 = findViewById(R.id.chk_sign_up_agreement_6);
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
        btn_signUp_1_goNext = findViewById(R.id.btn_signUp_1_phoneCertification);
        btn_signUp_1_goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk_1.isChecked() && chk_2.isChecked() && chk_3.isChecked()){
                    Intent intent = new Intent(SignUpAgreementActivity.this, SignUpInputFormActivity.class);
                    startActivity(intent);
                }else{
                    showCustomToast("필수항목에 모두 동의해주세요");
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_agreement);

        initCheckBoxes();
        initScrollViews();
        initButtons();
    }


    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();
//        mTvHelloWorld.setText(text);
    }

    @Override
    public void validateFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    public void customOnClick(View view) {
        switch (view.getId()) {
            case R.id.chk_sign_up_agreement_all:
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
                break;
            case R.id.chk_sign_up_agreement_1:
                if (chk_1.isChecked() && chk_2.isChecked() && chk_3.isChecked() && chk_4.isChecked() && chk_5.isChecked() && chk_6.isChecked()){
                    chkAll.setChecked(true);
                }else if (chkAll.isChecked() && !chk_1.isChecked()){
                    chkAll.setChecked(false);
                }
                break;
            case R.id.chk_sign_up_agreement_2:
                if (chk_1.isChecked() && chk_2.isChecked() && chk_3.isChecked() && chk_4.isChecked() && chk_5.isChecked() && chk_6.isChecked()){
                    chkAll.setChecked(true);
                }else if (chkAll.isChecked() && !chk_2.isChecked()){
                    chkAll.setChecked(false);
                }
                break;
            case R.id.chk_sign_up_agreement_3:
                if (chk_1.isChecked() && chk_2.isChecked() && chk_3.isChecked() && chk_4.isChecked() && chk_5.isChecked() && chk_6.isChecked()){
                    chkAll.setChecked(true);
                }else if (chkAll.isChecked() && !chk_3.isChecked()){
                    chkAll.setChecked(false);
                }
                break;
            case R.id.chk_sign_up_agreement_4:
                if (chk_1.isChecked() && chk_2.isChecked() && chk_3.isChecked() && chk_4.isChecked() && chk_5.isChecked() && chk_6.isChecked()){
                    chkAll.setChecked(true);
                }else if (chkAll.isChecked() && !chk_4.isChecked()){
                    chkAll.setChecked(false);
                }
                break;
            case R.id.chk_sign_up_agreement_5:
                if (chk_1.isChecked() && chk_2.isChecked() && chk_3.isChecked() && chk_4.isChecked() && chk_5.isChecked() && chk_6.isChecked()){
                    chkAll.setChecked(true);
                }else if (chkAll.isChecked() && !chk_5.isChecked()){
                    chkAll.setChecked(false);
                }
                break;
            case R.id.chk_sign_up_agreement_6:
                if (chk_1.isChecked() && chk_2.isChecked() && chk_3.isChecked() && chk_4.isChecked() && chk_5.isChecked() && chk_6.isChecked()){
                    chkAll.setChecked(true);
                }else if (chkAll.isChecked() && !chk_6.isChecked()){
                    chkAll.setChecked(false);
                }
                break;
            default:
                break;
        }
    }
}
