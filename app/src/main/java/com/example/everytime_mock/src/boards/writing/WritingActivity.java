package com.example.everytime_mock.src.boards.writing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.BaseActivity;
import com.example.everytime_mock.src.boards.general_boards.alumni_board.AlumniBoardActivity;
import com.example.everytime_mock.src.boards.general_boards.free_board.FreeBoardActivity;
import com.example.everytime_mock.src.boards.general_boards.freshmen_board.FreshmenBoardActivity;
import com.example.everytime_mock.src.boards.interfaces.WritingActivityView;
import com.example.everytime_mock.src.boards.models.WritingResponse;
import com.example.everytime_mock.src.boards.general_boards.secret_board.SecretBoardActivity;

import java.util.HashMap;


public class WritingActivity extends BaseActivity implements WritingActivityView {

    private int num_of_board_from;
    private Button btn_writing_complete;
    private EditText et_writing_title, et_writing_content;
    private CheckBox chk_writing_anonymous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);

        /**
         * 어떤 게시판에서 글쓰기로 넘어왔는지 알아야 해당 게시판에 글을 올릴 수 있다!!!
         * 1: 자유 게시판
         * 2: 비밀 게시판
         * 3: 졸업생 게시판
         * 4: 새내기 게시판
         * */
        Intent intent = getIntent();
        num_of_board_from = intent.getExtras().getInt("boardName");

        et_writing_title = findViewById(R.id.et_writing_title);
        et_writing_content = findViewById(R.id.et_writing_content);
        chk_writing_anonymous = findViewById(R.id.chk_writing_anonymous);

        btn_writing_complete = findViewById(R.id.btn_writing_complete);
        btn_writing_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_writing_title.getText().toString().equals("") && et_writing_content.getText().toString().equals("")) {
                    showCustomToast("제목과 내용을 입력하세요");
                } else if (et_writing_title.getText().toString().equals("")) {
                    showCustomToast("제목을 입력하세요");
                } else if (et_writing_content.getText().toString().equals("")) {
                    showCustomToast("내용을 입력하세요");
                } else {
                    String input_title = et_writing_title.getText().toString();
                    String input_content = et_writing_content.getText().toString();

                    // todo
                    // 아이디와 비밀번호 칸을 모두 채운 경우에는 담아서 서버로 보낸다.

                    tryPostWriting(input_title, input_content);
                }

            }
        });

    }

    private void tryPostWriting(String title, String content) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("contentTitle", title);
        params.put("contentInf", content);
        params.put("userStatus", chk_writing_anonymous.isChecked() ? 0 : 1);

        final WritingService writingService = new WritingService(this, num_of_board_from, params);
        writingService.postWriting();
    }


    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void WritingSuccess(WritingResponse writingResponse) {
        hideProgressDialog();

        switch (writingResponse.getCode()) {
            case 100:
                Intent intent;
                switch (num_of_board_from) {
                    case 1:
                        intent = new Intent(WritingActivity.this, FreeBoardActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 2:
                        intent = new Intent(WritingActivity.this, SecretBoardActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 3:
                        intent = new Intent(WritingActivity.this, AlumniBoardActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 4:
                        intent = new Intent(WritingActivity.this, FreshmenBoardActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    default:
                        break;
                }
        }


    }
}
