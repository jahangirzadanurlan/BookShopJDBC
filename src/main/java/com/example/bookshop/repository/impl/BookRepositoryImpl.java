package com.example.bookshop.repository.impl;

import com.example.bookshop.exception.BookNotFound;
import com.example.bookshop.model.Book;
import com.example.bookshop.query.BookQuery;
import com.example.bookshop.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query(BookQuery.BOOK_LIST,
                ((rs, rowNum) -> Book.builder()
                        .name(rs.getString("name"))
                        .author(rs.getString("author"))
                        .id(rs.getLong("id"))
                        .build()
                ));
    }

    @Override
    public Optional<Book> findById(Long id) {
        return jdbcTemplate.query(BookQuery.BOOK_FIND_BY_ID,
                new Object[]{id},
                (rs, rowNum) -> Book.builder()
                        .name(rs.getString("name"))
                        .author(rs.getString("author"))
                        .id(rs.getLong("id"))
                        .build())
                .stream()
                .findFirst();
    }

    @Override
    public int insert(Book book) {
        return jdbcTemplate.update(BookQuery.INSERT_BOOK,
                book.getName(),book.getAuthor());
    }

    @Override
    public int update(Book book) {
        return jdbcTemplate.update(BookQuery.UPDATE_BOOK_BY_ID,
                book.getName(),book.getAuthor(),book.getId());
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update(BookQuery.DELETE_BY_ID,id);
    }
}
