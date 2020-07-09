package com.example.everytime_mock.src.boards.models.adapters;

import android.app.Activity;
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

public class SecretBoardAdapter extends RecyclerView.Adapter<SecretBoardAdapter.CustomViewHolder> {

    private ArrayList<PostItem> post_item_list;

    private OnItemClickListener mListener = null ;

    public SecretBoardAdapter(ArrayList<PostItem> post_item_list) {
        this.post_item_list = post_item_list;
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    @NonNull
    @Override
    public SecretBoardAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_summarized_post_for_secret, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SecretBoardAdapter.CustomViewHolder holder, int position) {
        holder.tv_item_post_secret_nickname.setText("익명");
        holder.tv_item_post_secret_time.setText(post_item_list.get(position).getTime());
        holder.tv_item_post_secret_content.setText(post_item_list.get(position).getContent());
        holder.tv_item_post_secret_like_num.setText(Integer.toString(post_item_list.get(position).getLike_num()));
        holder.tv_item_post_secret_comment_num.setText(Integer.toString(post_item_list.get(position).getComment_num()));

        holder.itemView.setTag(position);

        /**
         * click 리스너 달 거면 여기에 달 것
         * */

    }

    @Override
    public int getItemCount() {
        return (null != post_item_list ? post_item_list.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView tv_item_post_secret_nickname;
        protected TextView tv_item_post_secret_time;
        protected TextView tv_item_post_secret_content;
        protected TextView tv_item_post_secret_like_num;
        protected TextView tv_item_post_secret_comment_num;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_item_post_secret_nickname = itemView.findViewById(R.id.tv_item_post_secret_nickname);
            this.tv_item_post_secret_time = itemView.findViewById(R.id.tv_item_post_secret_time);
            this.tv_item_post_secret_content = itemView.findViewById(R.id.tv_item_post_secret_content);
            this.tv_item_post_secret_like_num = itemView.findViewById(R.id.tv_item_post_secret_like_num);
            this.tv_item_post_secret_comment_num = itemView.findViewById(R.id.tv_item_post_secret_comment_num);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Context context = v.getContext();

                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){


                        System.out.println("보내기 전 pos: " + pos);

                        Intent intent = new Intent(v.getContext(), InPostActivity.class);
                        intent.putExtra("index_of_this_post", post_item_list.get(pos).getContent_index());
                        intent.putExtra("clicked_secret_pos", pos);
                        intent.putExtra("clicked_content_index", post_item_list.get(pos).getContent_index());

                        context.startActivity(intent);
                        ((Activity)context).finish();

                        if (mListener != null) {
                            mListener.onItemClick(v, pos);
                        }
                    }
                }
            });
        }
    }
}
