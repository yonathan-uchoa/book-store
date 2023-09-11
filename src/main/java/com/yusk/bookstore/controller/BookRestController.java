package com.yusk.bookstore.controller;

import com.yusk.bookstore.model.BookSearch;
import com.yusk.bookstore.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("library")
public class BookRestController {
    @Autowired
    LibraryService libraryService;

    @GetMapping
    public ResponseEntity<BookSearch> bookList(@RequestParam String q, @RequestParam String mode) {
        BookSearch books = libraryService.getBooks(q, mode);
        return new ResponseEntity<>(books, HttpStatus.ACCEPTED);
    }
}
