package com.example.bookshop.service;

import com.example.bookshop.dto.request.BookDtoRequest;
import com.example.bookshop.dto.response.BookDtoResponse;
import com.example.bookshop.dto.response.ResponseDto;

import java.util.List;

public interface BookService {
    List<BookDtoResponse> findAll();
    BookDtoResponse findById(Long id);
    ResponseDto insert(BookDtoRequest book);
    ResponseDto update(BookDtoRequest book);
    ResponseDto delete(Long id);
}
