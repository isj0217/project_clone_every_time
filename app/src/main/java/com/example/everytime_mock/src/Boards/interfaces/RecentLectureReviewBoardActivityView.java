package com.example.everytime_mock.src.Boards.interfaces;

import com.example.everytime_mock.src.Boards.models.BoardResponse;

public interface BoardActivityView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void boardSuccess(BoardResponse boardResponse);
}