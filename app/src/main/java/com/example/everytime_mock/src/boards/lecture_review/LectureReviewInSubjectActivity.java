package com.example.everytime_mock.src.boards.lecture_review;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.BaseActivity;
import com.example.everytime_mock.src.boards.interfaces.LectureReviewInSubjectActivityView;
import com.example.everytime_mock.src.boards.models.review_detail.ReviewDetailResponse;
import com.example.everytime_mock.src.boards.models.review.ReviewResponse;

public class LectureReviewInSubjectActivity extends BaseActivity implements LectureReviewInSubjectActivityView {

    private String clicked;
    private TextView tv_lecture_review_in_subject_subject, tv_lecture_review_in_subject_professor, tv_lecture_review_in_subject_semester,
            tv_lecture_review_in_subject_rate, tv_lecture_review_in_subject_assignment_amount, tv_lecture_review_in_subject_group_meeting,
            tv_lecture_review_in_subject_grade_ratio, tv_lecture_review_in_subject_attendance, tv_lecture_review_in_subject_num_of_test;
    private ImageView iv_lecture_review_in_subject_rate;

    public void bindViews() {
        tv_lecture_review_in_subject_subject = findViewById(R.id.tv_lecture_review_in_subject_subject);
        tv_lecture_review_in_subject_professor = findViewById(R.id.tv_lecture_review_in_subject_professor);
        tv_lecture_review_in_subject_semester = findViewById(R.id.tv_lecture_review_in_subject_semester);
        tv_lecture_review_in_subject_rate = findViewById(R.id.tv_lecture_review_in_subject_rate);
        tv_lecture_review_in_subject_assignment_amount = findViewById(R.id.tv_lecture_review_in_subject_assignment_amount);
        tv_lecture_review_in_subject_group_meeting = findViewById(R.id.tv_lecture_review_in_subject_group_meeting);
        tv_lecture_review_in_subject_grade_ratio = findViewById(R.id.tv_lecture_review_in_subject_grade_ratio);
        tv_lecture_review_in_subject_attendance = findViewById(R.id.tv_lecture_review_in_subject_attendance);
        tv_lecture_review_in_subject_num_of_test = findViewById(R.id.tv_lecture_review_in_subject_num_of_test);
        iv_lecture_review_in_subject_rate = findViewById(R.id.iv_lecture_review_in_subject_rate);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_review_in_subject);

        bindViews();

        clicked = getIntent().getStringExtra("clicked");

        LectureReviewInSubjectService lectureReviewInSubjectService = new LectureReviewInSubjectService(this);
        lectureReviewInSubjectService.getReview();

        switch (clicked) {
            case "review_1":
                lectureReviewInSubjectService.getReviewDetail(1);
                break;
            case "review_2":
                lectureReviewInSubjectService.getReviewDetail(2);
                break;
            case "review_3":
                lectureReviewInSubjectService.getReviewDetail(3);
                break;
            case "review_4":
                lectureReviewInSubjectService.getReviewDetail(4);
                break;
        }

    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    public int convertDoubleRateToInt(double double_rate) {
        int int_rate = 0;

        if (double_rate <= 0.5){
            int_rate = 1;
        }else if (double_rate <= 1){
            int_rate = 2;
        }else if (double_rate <= 1.5){
            int_rate = 3;
        }else if (double_rate <= 2){
            int_rate = 4;
        }else if (double_rate <= 2.5){
            int_rate = 5;
        }else if (double_rate <= 3){
            int_rate = 6;
        }else if (double_rate <= 3.5){
            int_rate = 7;
        }else if (double_rate <= 4){
            int_rate = 8;
        }else if (double_rate <= 4.5){
            int_rate = 9;
        }else if (double_rate <= 5){
            int_rate = 10;
        }
        return int_rate;
    }

    @Override
    public void reviewSuccess(ReviewResponse reviewResponse) {
        int int_rate;

        switch (clicked) {
            case "review_1":
                tv_lecture_review_in_subject_subject.setText(reviewResponse.getReviewResults().get(0).getClassName());
                tv_lecture_review_in_subject_professor.setText(reviewResponse.getReviewResults().get(0).getProfessor());
                tv_lecture_review_in_subject_semester.setText(reviewResponse.getReviewResults().get(0).getClassStudent());
                tv_lecture_review_in_subject_rate.setText(Double.toString(reviewResponse.getReviewResults().get(0).getClassStar()));

                int_rate = convertDoubleRateToInt(reviewResponse.getReviewResults().get(0).getClassStar());
                System.out.println("review1이고 " + int_rate);
                switch (int_rate){
                    case 1:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_0_half);
                        break;
                    case 2:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_1);
                        break;
                    case 3:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_1_half);
                        break;
                    case 4:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_2);
                        break;
                    case 5:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_2_half);
                        break;
                    case 6:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_3);
                        break;
                    case 7:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_3_half);
                        break;
                    case 8:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_4);
                        break;
                    case 9:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_4_half);
                        break;
                    case 10:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_5);
                        break;
                }

                break;
            case "review_2":
                tv_lecture_review_in_subject_subject.setText(reviewResponse.getReviewResults().get(1).getClassName());
                tv_lecture_review_in_subject_professor.setText(reviewResponse.getReviewResults().get(1).getProfessor());
                tv_lecture_review_in_subject_semester.setText(reviewResponse.getReviewResults().get(1).getClassStudent());
                tv_lecture_review_in_subject_rate.setText(Double.toString(reviewResponse.getReviewResults().get(1).getClassStar()));
                int_rate = convertDoubleRateToInt(reviewResponse.getReviewResults().get(1).getClassStar());
                System.out.println("review2이고 " + int_rate);
                switch (int_rate){
                    case 1:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_0_half);
                        break;
                    case 2:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_1);
                        break;
                    case 3:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_1_half);
                        break;
                    case 4:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_2);
                        break;
                    case 5:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_2_half);
                        break;
                    case 6:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_3);
                        break;
                    case 7:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_3_half);
                        break;
                    case 8:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_4);
                        break;
                    case 9:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_4_half);
                        break;
                    case 10:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_5);
                        break;
                }

                break;
            case "review_3":
                tv_lecture_review_in_subject_subject.setText(reviewResponse.getReviewResults().get(2).getClassName());
                tv_lecture_review_in_subject_professor.setText(reviewResponse.getReviewResults().get(2).getProfessor());
                tv_lecture_review_in_subject_semester.setText(reviewResponse.getReviewResults().get(2).getClassStudent());
                tv_lecture_review_in_subject_rate.setText(Double.toString(reviewResponse.getReviewResults().get(2).getClassStar()));
                int_rate = convertDoubleRateToInt(reviewResponse.getReviewResults().get(2).getClassStar());
                System.out.println("review3이고 " + int_rate);
                switch (int_rate){
                    case 1:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_0_half);
                        break;
                    case 2:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_1);
                        break;
                    case 3:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_1_half);
                        break;
                    case 4:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_2);
                        break;
                    case 5:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_2_half);
                        break;
                    case 6:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_3);
                        break;
                    case 7:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_3_half);
                        break;
                    case 8:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_4);
                        break;
                    case 9:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_4_half);
                        break;
                    case 10:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_5);
                        break;
                }

                break;
            case "review_4":
                tv_lecture_review_in_subject_subject.setText(reviewResponse.getReviewResults().get(3).getClassName());
                tv_lecture_review_in_subject_professor.setText(reviewResponse.getReviewResults().get(3).getProfessor());
                tv_lecture_review_in_subject_semester.setText(reviewResponse.getReviewResults().get(3).getClassStudent());
                tv_lecture_review_in_subject_rate.setText(Double.toString(reviewResponse.getReviewResults().get(3).getClassStar()));
                int_rate = convertDoubleRateToInt(reviewResponse.getReviewResults().get(3).getClassStar());
                System.out.println("review4이고 " + int_rate);
                switch (int_rate){
                    case 1:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_0_half);
                        break;
                    case 2:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_1);
                        break;
                    case 3:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_1_half);
                        break;
                    case 4:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_2);
                        break;
                    case 5:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_2_half);
                        break;
                    case 6:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_3);
                        break;
                    case 7:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_3_half);
                        break;
                    case 8:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_4);
                        break;
                    case 9:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_4_half);
                        break;
                    case 10:
                        iv_lecture_review_in_subject_rate.setImageResource(R.drawable.star_rate_5);
                        break;
                }
                break;
        }
    }

    @Override
    public void reviewDetailSuccess(ReviewDetailResponse reviewDetailResponse) {

        tv_lecture_review_in_subject_assignment_amount.setText(reviewDetailResponse.getReviewDetailResults().get(0).getSelectHw());
        tv_lecture_review_in_subject_group_meeting.setText(reviewDetailResponse.getReviewDetailResults().get(0).getSelectTeam());
        tv_lecture_review_in_subject_grade_ratio.setText(reviewDetailResponse.getReviewDetailResults().get(0).getSelectRate());
        tv_lecture_review_in_subject_attendance.setText(reviewDetailResponse.getReviewDetailResults().get(0).getSelectAtt());
        tv_lecture_review_in_subject_num_of_test.setText(reviewDetailResponse.getReviewDetailResults().get(0).getSelectTest());
    }
}
