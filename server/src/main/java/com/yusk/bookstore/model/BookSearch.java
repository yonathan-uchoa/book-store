package com.yusk.bookstore.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class BookSearch {
    private Set<BookOnline> docs;
    private String numFound;
    private String q;
    private String start;
}
