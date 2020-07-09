package com.example.everytime_mock.src.main.frag_home.models;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.everytime_mock.R;

import java.util.ArrayList;

public class FavoriteBoardAdapter extends RecyclerView.Adapter<FavoriteBoardAdapter.CustomViewHolder> {

    private ArrayList<FavoriteBoardItem> favorite_board_item_list;

    public FavoriteBoardAdapter(ArrayList<FavoriteBoardItem> favorite_board_item_list) {
        this.favorite_board_item_list = favorite_board_item_list;
    }

    @NonNull
    @Override
    public FavoriteBoardAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.board_list, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteBoardAdapter.CustomViewHolder holder, int position) {
        holder.tv_board_name.setText(favorite_board_item_list.get(position).getTv_board_name());
        holder.tv_board_title.setText(favorite_board_item_list.get(position).getTv_board_title());
        holder.is_new.setImageResource(favorite_board_item_list.get(position).getIs_new());

        holder.itemView.setTag(position);

        /**
         * click 리스너 달 거면 여기에 달 것
         * */

    }

    @Override
    public int getItemCount() {
        return (null != favorite_board_item_list ? favorite_board_item_list.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView tv_board_name;
        protected TextView tv_board_title;
        protected ImageView is_new;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_board_name = itemView.findViewById(R.id.board_name);
            this.tv_board_title = itemView.findViewById(R.id.board_title);
            this.is_new = itemView.findViewById(R.id.iv_is_new);
        }
    }
}
