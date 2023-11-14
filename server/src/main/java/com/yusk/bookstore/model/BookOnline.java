package com.yusk.bookstore.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookOnline {
    String key;
    String title;
    Float ratings_average;
    String[] author_name;
    String[] subject;
    String cover_i;

}
