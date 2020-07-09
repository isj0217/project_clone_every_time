package com.example.everytime_mock.src.boards.interfaces;

import com.example.everytime_mock.src.boards.models.BoardResponse;

public interface BoardActivityView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void boardSuccess(BoardResponse boardResponse);
}