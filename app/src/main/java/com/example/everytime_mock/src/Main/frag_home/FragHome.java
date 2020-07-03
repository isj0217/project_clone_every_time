package com.example.everytime_mock.src.Main.models;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.Main.frag_home.FavoriteBoardAdapter;
import com.example.everytime_mock.src.Main.frag_home.FavoriteBoardItem;
import com.example.everytime_mock.src.Main.frag_home.frag_home_interfaces.FragHomeView;

import java.util.ArrayList;

public class FragHome extends Fragment implements FragHomeView {
    ViewGroup viewGroup;

    private ArrayList<FavoriteBoardItem> favorite_board_item_list;
    private FavoriteBoardAdapter favorite_board_adapter;
    private RecyclerView rv_favorite_board;
    private LinearLayoutManager linear_layout_manager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.frag_home, container, false);

        rv_favorite_board = viewGroup.findViewById(R.id.rv_home_favorite_board_list);

        linear_layout_manager = new LinearLayoutManager(viewGroup.getContext());
        rv_favorite_board.setLayoutManager(linear_layout_manager);

        favorite_board_item_list = new ArrayList<>();
        favorite_board_adapter = new FavoriteBoardAdapter(favorite_board_item_list);
        rv_favorite_board.setAdapter(favorite_board_adapter);

        tryGetFavoriteBoard();

        for (int i = 0; i < 8; i++){
            FavoriteBoardItem fbi = new FavoriteBoardItem("자유게시판", "...", R.drawable.new_red);
            favorite_board_item_list.add(fbi);
        }
        favorite_board_adapter.notifyDataSetChanged();

        return viewGroup;
    }

    private void tryGetFavoriteBoard() {

        final FavoriteBoardService favoriteBoardService = new FavoriteBoardService();
        favoriteBoardService;

    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
