package com.example.everytime_mock.src.Main.frag_board;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.Boards.AlumniBoardActivity;
import com.example.everytime_mock.src.Boards.FreeBoardActivity;
import com.example.everytime_mock.src.Boards.FreshmenBoardActivity;
import com.example.everytime_mock.src.Boards.RecentLectureReviewBoardActivity;
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
    LinearLayout linear_layout_frag_board_all_go_to_lecture_review;

    private boolean pin_free, pin_secret, pin_alumni, pin_freshmen;

    private ImageView iv_frag_board_all_pin_free, iv_frag_board_all_pin_secret, iv_frag_board_all_pin_alumni, iv_frag_board_all_pin_freshmen;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_board_all, container, false);

        pin_free = true;
        pin_secret = true;
        pin_alumni = true;
        pin_freshmen = true;

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

        linear_layout_frag_board_all_go_to_lecture_review = view.findViewById(R.id.linear_layout_frag_board_all_go_to_lecture_review);
        linear_layout_frag_board_all_go_to_lecture_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RecentLectureReviewBoardActivity.class);
                startActivity(intent);
            }
        });

        iv_frag_board_all_pin_free = view.findViewById(R.id.iv_frag_board_all_pin_free);
        iv_frag_board_all_pin_free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pin_free){
                    iv_frag_board_all_pin_free.setImageResource(R.drawable.icon_pin_removed);
                    pin_free = false;
                }else{
                    iv_frag_board_all_pin_free.setImageResource(R.drawable.icon_pin);
                    pin_free = true;
                }
            }
        });

        iv_frag_board_all_pin_secret = view.findViewById(R.id.iv_frag_board_all_pin_secret);
        iv_frag_board_all_pin_secret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pin_secret){
                    iv_frag_board_all_pin_secret.setImageResource(R.drawable.icon_pin_removed);
                    pin_secret = false;
                }else{
                    iv_frag_board_all_pin_secret.setImageResource(R.drawable.icon_pin);
                    pin_secret = true;
                }
            }
        });

        iv_frag_board_all_pin_alumni = view.findViewById(R.id.iv_frag_board_all_pin_alumni);
        iv_frag_board_all_pin_alumni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pin_alumni){
                    iv_frag_board_all_pin_alumni.setImageResource(R.drawable.icon_pin_removed);
                    pin_alumni = false;
                }else{
                    iv_frag_board_all_pin_alumni.setImageResource(R.drawable.icon_pin);
                    pin_alumni = true;
                }
            }
        });

        iv_frag_board_all_pin_freshmen = view.findViewById(R.id.iv_frag_board_all_pin_freshmen);
        iv_frag_board_all_pin_freshmen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pin_freshmen){
                    iv_frag_board_all_pin_freshmen.setImageResource(R.drawable.icon_pin_removed);
                    pin_freshmen = false;
                }else{
                    iv_frag_board_all_pin_freshmen.setImageResource(R.drawable.icon_pin);
                    pin_freshmen = true;
                }
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
