package com.example.bookshop.controller;

import com.example.bookshop.dto.request.BookDtoRequest;
import com.example.bookshop.dto.response.BookDtoResponse;
import com.example.bookshop.dto.response.ResponseDto;
import com.example.bookshop.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
@Slf4j
public class BookController {
    private BookService bookService;

    @GetMapping
    public List<BookDtoResponse> books(){
        log.info("GET - /books -> request none");
        var response = bookService.findAll();
        log.info("GET - /books - response ->{}",response);
        return response;
    }

    @GetMapping("/{id}")
    public BookDtoResponse bookById(@PathVariable Long id){
        log.info("GET - /books/{} -> request",id);
        var response = bookService.findById(id);
        log.info("GET - /books/{} -> response -> {}",id,response);
        return response;
    }

    @PostMapping
    public ResponseDto insert(@RequestBody BookDtoRequest bookDto){
        log.info("GET - /books -> request ");
        var response = bookService.insert(bookDto);
        log.info("GET - /books -> response -> {} ",response);
        return response;
    }

    @PutMapping
    public ResponseDto update(@RequestBody BookDtoRequest bookDto){
        return bookService.update(bookDto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto deleteById(@PathVariable Long id){
        return bookService.delete(id);
    }
}
