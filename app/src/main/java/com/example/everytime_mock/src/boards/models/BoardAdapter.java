package com.example.everytime_mock.src.Boards.models;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.Main.frag_home.models.FavoriteBoardItem;

import java.util.ArrayList;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.CustomViewHolder> {

    private ArrayList<PostItem> post_item_list;

    public BoardAdapter(ArrayList<PostItem> post_item_list) {
        this.post_item_list = post_item_list;
    }

    @NonNull
    @Override
    public BoardAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_summarized_post, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BoardAdapter.CustomViewHolder holder, int position) {
        holder.tv_item_post_title.setText(post_item_list.get(position).getTitle());
        holder.tv_item_post_content.setText(post_item_list.get(position).getContent());
        holder.tv_item_post_time.setText(post_item_list.get(position).getTime());
        holder.tv_item_post_nickname.setText(post_item_list.get(position).getWriter());
        holder.tv_item_post_like_num.setText(Integer.toString(post_item_list.get(position).getLike_num()));
        holder.tv_item_post_comment_num.setText(Integer.toString(post_item_list.get(position).getComment_num()));

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

        protected TextView tv_item_post_title;
        protected TextView tv_item_post_content;
        protected TextView tv_item_post_time;
        protected TextView tv_item_post_nickname;
        protected TextView tv_item_post_like_num;
        protected TextView tv_item_post_comment_num;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_item_post_title = itemView.findViewById(R.id.tv_item_post_title);
            this.tv_item_post_content = itemView.findViewById(R.id.tv_item_post_content);
            this.tv_item_post_time = itemView.findViewById(R.id.tv_item_post_time);
            this.tv_item_post_nickname = itemView.findViewById(R.id.tv_item_post_nickname);
            this.tv_item_post_like_num = itemView.findViewById(R.id.tv_item_post_like_num);
            this.tv_item_post_comment_num = itemView.findViewById(R.id.tv_item_post_comment_num);
        }
    }
}
