package com.example.everytime_mock.src.boards.in_post.models;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.boards.in_post.InPostActivity;
import com.example.everytime_mock.src.boards.models.items.PostItem;

import java.util.ArrayList;

public class FreeCommentAdapter extends RecyclerView.Adapter<FreeCommentAdapter.CustomViewHolder> {

    private ArrayList<CommentItem> comment_item_list;
    private OnItemClickListener mListener = null ;

    public FreeCommentAdapter(ArrayList<CommentItem> comment_item_list) {
        this.comment_item_list = comment_item_list;
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    @NonNull
    @Override
    public FreeCommentAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FreeCommentAdapter.CustomViewHolder holder, int position) {
        holder.tv_item_comment_commentInf.setText(comment_item_list.get(position).getCommentInf());
        holder.tv_item_comment_commentWriter.setText(comment_item_list.get(position).getCommentWriter());
        holder.tv_item_comment_commentWriteDay.setText(comment_item_list.get(position).getCommentWriteDay());

        holder.itemView.setTag(position);

        /**
         * click 리스너 달 거면 여기에 달 것
         * */

    }

    @Override
    public int getItemCount() {
        return (null != comment_item_list ? comment_item_list.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView tv_item_comment_commentInf;
        protected TextView tv_item_comment_commentWriter;

        protected TextView tv_item_comment_commentWriteDay;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            this.tv_item_comment_commentInf = itemView.findViewById(R.id.tv_item_comment_content);
            this.tv_item_comment_commentWriter = itemView.findViewById(R.id.tv_item_comment_nickname);
            this.tv_item_comment_commentWriteDay = itemView.findViewById(R.id.tv_item_comment_time);


        }
    }
}
