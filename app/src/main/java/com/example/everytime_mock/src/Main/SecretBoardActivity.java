package com.example.everytime_mock.src.Main;

import android.os.Bundle;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.BaseActivity;
import com.example.everytime_mock.src.Main.interfaces.FreeBoardActivityView;


public class FreeBoardActivity extends BaseActivity implements FreeBoardActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_free_board);
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
