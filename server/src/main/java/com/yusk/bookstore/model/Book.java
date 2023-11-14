package com.yusk.bookstore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yusk.bookstore.utils.StringSetConverter;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "genre", nullable = false)
    @Convert(converter = StringSetConverter.class)
    private Set<String> genre;

    @Column(name = "price")
    private Float price;

    @Column(name = "author", nullable = false)
    @Convert(converter = StringSetConverter.class)
    private Set<String> author;

    @Column(name = "cover_url")
    private String coverUrl;

    @ManyToMany(mappedBy = "books")
    @JsonBackReference
    private List<WishList> wishLists;


}
