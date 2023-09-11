package com.yusk.bookstore.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class Book {
    private String key;
    private String type;
    private String title;
    private Set<String> author_name;
    private Set<String> author_alternative_name;
    public Integer ratings_average;
    public String cover_edition_key;
}
