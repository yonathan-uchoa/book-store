package com.yusk.bookstore.service;

import com.yusk.bookstore.model.Address;

import java.util.Optional;

public interface AddressService {
    void insert (Address address);
    Optional<Address> update(Integer id, Address address);
}
