package com.example.bookshop.exception;

import com.example.bookshop.enums.Exceptions;

public class BookNotFound extends RuntimeException{
    public BookNotFound(){
        super(Exceptions.BOOK_NOT_FOUND_EXCEPTION.getMessage());
    }
}
