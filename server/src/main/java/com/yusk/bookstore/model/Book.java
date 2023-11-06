package com.yusk.bookstore.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;

    private String title;

    @Column(name="genre")
    private String genre;

    @Column(name="price")
    private Float price;

    @Column(name="author")
    private String author;

    @Column(name="cover_url")
    private String coverUrl;

    private Float ratings_average;

    @ManyToMany
    @JoinTable(name = "Wish_list_books")
    private Set<WishList> wishLists;

}
