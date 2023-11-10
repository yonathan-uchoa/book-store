package com.yusk.bookstore.service;

import com.yusk.bookstore.model.WishList;

import java.util.Map;
import java.util.Optional;

public interface WishListService {

    Iterable<WishList> searchAll();
    Optional<WishList> searchById(Integer id);
    WishList save(WishList wishList);
    void delete(Integer id);
    Boolean addOrRemoveBook(WishList wishList, Integer bookId, String addOrRemove);
}

