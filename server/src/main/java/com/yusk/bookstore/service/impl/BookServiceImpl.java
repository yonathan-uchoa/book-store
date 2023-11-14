package com.yusk.bookstore.service.impl;

import com.yusk.bookstore.model.Book;
import com.yusk.bookstore.repository.BookRepository;
import com.yusk.bookstore.service.BookService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Iterable<Book> searchAll() {
        return bookRepository.findAll();
    }
    @Override
    public Optional<Book> searchById(Integer id) {
        return bookRepository.findById(id);
    }
    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Iterable<Book> findByTitleContaining(String infix){
        return bookRepository.findByTitleContaining(infix);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isEmpty())
            return;
        Book _book = book.get();
        _book.getWishLists().forEach(wishList -> {
            wishList.getBooks().remove(_book);
        });
        bookRepository.deleteById(id);
    }
}
