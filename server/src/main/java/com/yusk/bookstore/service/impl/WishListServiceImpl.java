package com.yusk.bookstore.service.impl;

import com.yusk.bookstore.model.Book;
import com.yusk.bookstore.model.Client;
import com.yusk.bookstore.model.WishList;
import com.yusk.bookstore.repository.BookRepository;
import com.yusk.bookstore.repository.ClientRepository;
import com.yusk.bookstore.repository.WishListRepository;
import com.yusk.bookstore.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class WishListServiceImpl implements WishListService {

    @Autowired
    private WishListRepository wishListRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Iterable<WishList> searchAll() {
        return wishListRepository.findAll();
    }

    @Override
    public Optional<WishList> searchById(Integer id) {return wishListRepository.findById(id);
    }

    @Override
    public WishList save(WishList wishList) {
        return wishListRepository.save(wishList);
    }
    @Override
    public void delete(Integer id) {
        wishListRepository.deleteById(id);
    }
    @Override
    public Boolean addOrRemoveBook(WishList wishList, Integer bookId, String addOrRemove) {
        Optional<Book> _book = bookRepository.findById(bookId);
        if(_book.isEmpty())
            return false;
        if(addOrRemove.equals("add"))
            wishList.getBooks().add(_book.get());
        else
            wishList.getBooks().remove(_book.get());
        wishListRepository.save(wishList);
        return true;
    }
}
