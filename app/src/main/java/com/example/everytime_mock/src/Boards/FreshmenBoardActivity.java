package com.example.everytime_mock.src.Main;

import android.os.Bundle;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.BaseActivity;
import com.example.everytime_mock.src.Main.interfaces.FreeBoardActivityView;
import com.example.everytime_mock.src.Main.interfaces.FreshmenBoardActivityView;


public class FreshmenBoardActivity extends BaseActivity implements FreshmenBoardActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freshmen_board);
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
