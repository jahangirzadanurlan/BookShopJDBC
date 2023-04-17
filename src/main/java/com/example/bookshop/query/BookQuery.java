package com.example.bookshop.query;

public class BookQuery {
    public static final String BOOK_LIST="SELECT * FROM book";
    public static final String BOOK_FIND_BY_ID="SELECT * FROM book WHERE id=?";
    public static final String INSERT_BOOK="INSERT INTO book(name,author) VALUES(?,?)";
    public static final String UPDATE_BOOK_BY_ID="UPDATE book SET name=?,author=? WHERE idn= ?";
    public static final String DELETE_BY_ID="DELETE FROM booK";

}
