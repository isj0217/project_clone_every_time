package com.example.everytime_mock.src.Boards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.BaseActivity;
import com.example.everytime_mock.src.Boards.interfaces.LectureReviewInSubjectActivityView;
import com.example.everytime_mock.src.Boards.models.ReviewResponse;

public class LectureReviewInSubjectActivity extends BaseActivity implements LectureReviewInSubjectActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_review_in_subject);
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void ReviewSuccess(ReviewResponse reviewResponse) {

    }
}
