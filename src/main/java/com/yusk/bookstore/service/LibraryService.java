package com.yusk.bookstore.service;

import com.yusk.bookstore.model.BookSearch;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="openlibrary", url="https://openlibrary.org/search.json")
public interface LibraryService {
    @GetMapping
    BookSearch getBooks(@RequestParam String q, @RequestParam String mode);
}
