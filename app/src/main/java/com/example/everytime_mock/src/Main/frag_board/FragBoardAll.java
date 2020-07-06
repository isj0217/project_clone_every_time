package com.example.everytime_mock.src.Main.frag_board;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.Boards.FreeBoardActivity;

public class FragBoardAll extends Fragment {

    private View view;

    public static FragBoardAll newInstance() {
        FragBoardAll fragBoardAll = new FragBoardAll();
        return fragBoardAll;
    }

    LinearLayout linear_layout_frag_board_all_go_to_free_board;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_board_all, container, false);

        linear_layout_frag_board_all_go_to_free_board = view.findViewById(R.id.linear_layout_frag_board_all_go_to_free_board);
        linear_layout_frag_board_all_go_to_free_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FreeBoardActivity.class);
                startActivity(intent);
            }
        });






        return view;
    }

    public void customOnClick(View view) {
        switch (view.getId()) {
            case R.id.linear_layout_frag_board_all_go_to_free_board:
                Intent intent = new Intent(view.getContext(), FreeBoardActivity.class);
                break;
        }
    }   // 왜 안돌아가지????
}
