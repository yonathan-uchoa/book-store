package com.yusk.bookstore.service;

import com.yusk.bookstore.dto.AddressDTO;
import com.yusk.bookstore.model.Address;

import java.util.Optional;

public interface AddressService {
    Address insert (Address address);
    Optional<AddressDTO> update(Integer id, AddressDTO addressDTO);
    Optional<AddressDTO> searchById(Integer id);

    void delete(Integer id);
}
