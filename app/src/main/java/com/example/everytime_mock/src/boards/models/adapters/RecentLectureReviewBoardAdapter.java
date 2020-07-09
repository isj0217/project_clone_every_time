package com.example.everytime_mock.src.boards.models;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.everytime_mock.R;

import java.util.ArrayList;

public class RecentLectureReviewBoardAdapter extends RecyclerView.Adapter<RecentLectureReviewBoardAdapter.CustomViewHolder> {

    private ArrayList<ReviewItem> review_item_list;

    public RecentLectureReviewBoardAdapter(ArrayList<ReviewItem> review_item_list) {
        this.review_item_list = review_item_list;
    }

    @NonNull
    @Override
    public RecentLectureReviewBoardAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_summarized_review, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecentLectureReviewBoardAdapter.CustomViewHolder holder, int position) {

        int int_rate = 0;

        int_rate = convertDoubleRateToDiscreteInt(review_item_list.get(position).getClassStar());
        switch (int_rate){
            case 1:
                holder.iv_summarized_review_rate.setImageResource(R.drawable.star_rate_0_half);
                break;
            case 2:
                holder.iv_summarized_review_rate.setImageResource(R.drawable.star_rate_1);
                break;
            case 3:
                holder.iv_summarized_review_rate.setImageResource(R.drawable.star_rate_1_half);
                break;
            case 4:
                holder.iv_summarized_review_rate.setImageResource(R.drawable.star_rate_2);
                break;
            case 5:
                holder.iv_summarized_review_rate.setImageResource(R.drawable.star_rate_2_half);
                break;
            case 6:
                holder.iv_summarized_review_rate.setImageResource(R.drawable.star_rate_3);
                break;
            case 7:
                holder.iv_summarized_review_rate.setImageResource(R.drawable.star_rate_3_half);
                break;
            case 8:
                holder.iv_summarized_review_rate.setImageResource(R.drawable.star_rate_4);
                break;
            case 9:
                holder.iv_summarized_review_rate.setImageResource(R.drawable.star_rate_4_half);
                break;
            case 10:
                holder.iv_summarized_review_rate.setImageResource(R.drawable.star_rate_5);
                break;


        }

        holder.tv_summarized_review_subject.setText(review_item_list.get(position).getClassName());
        holder.tv_summarized_review_professor.setText(review_item_list.get(position).getProfessor());
        holder.tv_summarized_review_semester.setText(review_item_list.get(position).getClassStudent());
        holder.tv_summarized_review_content.setText(review_item_list.get(position).getClassCommentInf());

        holder.itemView.setTag(position);

        /**
         * click 리스너 달 거면 여기에 달 것
         * */

    }

    @Override
    public int getItemCount() {
        return (null != review_item_list ? review_item_list.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView tv_summarized_review_subject;
        protected TextView tv_summarized_review_professor;
        protected ImageView iv_summarized_review_rate;
        protected TextView tv_summarized_review_semester;
        protected TextView tv_summarized_review_content;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_summarized_review_subject = itemView.findViewById(R.id.tv_summarized_review_subject);
            this.tv_summarized_review_professor = itemView.findViewById(R.id.tv_summarized_review_professor);
            this.iv_summarized_review_rate = itemView.findViewById(R.id.iv_summarized_review_rate);
            this.tv_summarized_review_semester = itemView.findViewById(R.id.tv_summarized_review_semester);
            this.tv_summarized_review_content = itemView.findViewById(R.id.tv_summarized_review_content);
        }
    }
    public int convertDoubleRateToDiscreteInt(double double_rate){
        int int_rate = 0;

        if (double_rate <= 0.5) {
            int_rate = 1;
        }else if (double_rate <= 1) {
            int_rate = 2;
        }
        else if (double_rate <= 1.5) {
            int_rate = 3;
        }
        else if (double_rate <= 2) {
            int_rate = 4;
        }
        else if (double_rate <= 2.5) {
            int_rate = 5;
        }
        else if (double_rate <= 3) {
            int_rate = 6;
        }
        else if (double_rate <= 3.5) {
            int_rate = 7;
        }
        else if (double_rate <= 4) {
            int_rate = 8;
        }
        else if (double_rate <= 4.5) {
            int_rate = 9;
        }
        else if (double_rate <= 5) {
            int_rate = 10;
        }
        return int_rate;
    }

}
