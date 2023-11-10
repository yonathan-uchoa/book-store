package com.yusk.bookstore.service;

import com.yusk.bookstore.dto.response.AddressDTO;
import com.yusk.bookstore.dto.request.AddressPostRequestBody;
import com.yusk.bookstore.model.Address;

import java.util.Optional;

public interface AddressService {
    Address save (Address address);
    Optional<AddressDTO> update(Integer id, AddressDTO addressDTO);
    Optional<Address> searchById(Integer id);
    void delete(Integer id);
}
