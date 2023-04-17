package com.example.bookshop.repository;

import com.example.bookshop.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    int insert(Book book);
    int update(Book book);
    int delete(Long id);
}
