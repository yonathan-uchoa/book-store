package com.yusk.bookstore.service;

import com.yusk.bookstore.model.Book;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BookService {
    Iterable<Book> searchAll();
    Optional<Book> searchById(Integer id);
    Iterable<Book> findByTitleContaining(String infix);
    Book save(Book book);
    void delete(Integer id);
}
