package com.example.everytime_mock.src.Boards.interfaces;

import com.example.everytime_mock.src.Boards.models.WritingResponse;

public interface WritingActivityView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void WritingSuccess(WritingResponse WritingResponse);
}