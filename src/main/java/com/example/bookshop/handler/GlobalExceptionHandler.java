package com.example.bookshop.handler;

import com.example.bookshop.dto.response.ExceptionResponse;
import com.example.bookshop.enums.Exceptions;
import com.example.bookshop.exception.BookNotFound;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFound.class)
    public ExceptionResponse handle(){
        return ExceptionResponse.builder()
                .localDateTime(LocalDateTime.now())
                .message(Exceptions.BOOK_NOT_FOUND_EXCEPTION.getMessage())
                .build();
    }
}
