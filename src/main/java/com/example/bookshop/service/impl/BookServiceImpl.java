package com.example.bookshop.service.impl;

import com.example.bookshop.dto.request.BookDtoRequest;
import com.example.bookshop.dto.response.BookDtoResponse;
import com.example.bookshop.dto.response.ResponseDto;
import com.example.bookshop.exception.BookNotFound;
import com.example.bookshop.model.Book;
import com.example.bookshop.repository.BookRepository;
import com.example.bookshop.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<BookDtoResponse> findAll() {
        return bookRepository.findAll().stream()
                .map(book->modelMapper.map(book,BookDtoResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookDtoResponse findById(Long id) {
        return modelMapper.map(bookRepository.findById(id).orElseThrow(BookNotFound::new),BookDtoResponse.class);
    }

    @Override
    public ResponseDto insert(BookDtoRequest bookDto) {
        return bookRepository.insert(modelMapper.map(bookDto,Book.class))>0
                ?new ResponseDto("Book created succesfully!"):
                new ResponseDto("Book created failed!");
    }

    @Override
    public ResponseDto update(BookDtoRequest bookDto) {
        return bookRepository.update(modelMapper.map(bookDto,Book.class))>0
                ?new ResponseDto("Book updated succesfully!"):
                new ResponseDto("Book updated failed!");
    }

    @Override
    public ResponseDto delete(Long id) {
        return bookRepository.delete(id)>0
                ?new ResponseDto("Book deleted succesfully!"):
                new ResponseDto("Book deleted failed!");
    }
}
