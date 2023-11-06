package com.yusk.bookstore.repository;

import com.yusk.bookstore.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishLIstRepository extends JpaRepository<WishList, Integer> {
}
