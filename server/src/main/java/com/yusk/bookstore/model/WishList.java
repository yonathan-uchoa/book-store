package com.yusk.bookstore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Set;

@Entity
@Table(name="wish_list")
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wish_list_id")
    private Integer id;

    @Column(name = "name")
    private String name;


    @ManyToMany(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Book> books;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JsonBackReference
    private Client client;

    @PreRemove
    private void clearReferences() {
        getBooks().clear();
        getClient().setWishList(null);
    }
}
