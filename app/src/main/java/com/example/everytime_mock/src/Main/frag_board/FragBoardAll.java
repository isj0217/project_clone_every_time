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
import com.example.everytime_mock.src.Boards.AlumniBoardActivity;
import com.example.everytime_mock.src.Boards.FreeBoardActivity;
import com.example.everytime_mock.src.Boards.FreshmenBoardActivity;
import com.example.everytime_mock.src.Boards.SecretBoardActivity;

public class FragBoardAll extends Fragment {

    private View view;

    public static FragBoardAll newInstance() {
        FragBoardAll fragBoardAll = new FragBoardAll();
        return fragBoardAll;
    }

    LinearLayout linear_layout_frag_board_all_go_to_free_board;
    LinearLayout linear_layout_frag_board_all_go_to_secret_board;
    LinearLayout linear_layout_frag_board_all_go_to_alumni_board;
    LinearLayout linear_layout_frag_board_all_go_to_freshmen_board;

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

        linear_layout_frag_board_all_go_to_secret_board = view.findViewById(R.id.linear_layout_frag_board_all_go_to_secret_board);
        linear_layout_frag_board_all_go_to_secret_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecretBoardActivity.class);
                startActivity(intent);
            }
        });

        linear_layout_frag_board_all_go_to_alumni_board = view.findViewById(R.id.linear_layout_frag_board_all_go_to_alumni_board);
        linear_layout_frag_board_all_go_to_alumni_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AlumniBoardActivity.class);
                startActivity(intent);
            }
        });

        linear_layout_frag_board_all_go_to_freshmen_board = view.findViewById(R.id.linear_layout_frag_board_all_go_to_freshmen_board);
        linear_layout_frag_board_all_go_to_freshmen_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FreshmenBoardActivity.class);
                startActivity(intent);
            }
        });






        return view;
    }

    public void customOnClick(View view) {
        switch (view.getId()) {
            case R.id.linear_layout_frag_board_all_go_to_free_board:
                Intent intent = new Intent(view.getContext(), FreeBoardActivity.class);
                startActivity(intent);
                break;
        }
    }   // 왜 안돌아가지????
}
