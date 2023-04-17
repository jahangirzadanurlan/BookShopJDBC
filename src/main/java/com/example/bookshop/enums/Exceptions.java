package com.example.bookshop.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum Exceptions {
    BOOK_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "Book not found!");

    private HttpStatus httpStatus;
    private String message;

    private Exceptions(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
