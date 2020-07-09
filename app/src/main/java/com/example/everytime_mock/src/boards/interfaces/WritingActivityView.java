package com.example.everytime_mock.src.boards.interfaces;

import com.example.everytime_mock.src.boards.models.WritingResponse;

public interface WritingActivityView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void WritingSuccess(WritingResponse WritingResponse);
}