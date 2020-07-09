package com.example.everytime_mock.src.main.frag_board.interfaces;

import com.example.everytime_mock.src.main.frag_board.models.FavoriteBoardResponse;

public interface FragBoardView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void favoriteBoardSuccess(FavoriteBoardResponse favoriteBoardResponse);
}