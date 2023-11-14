package com.yusk.bookstore.repository;

import com.yusk.bookstore.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {
    // @Query("select b from Books where ")
}
