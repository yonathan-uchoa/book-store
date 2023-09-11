package com.yusk.bookstore.service.impl;

import com.yusk.bookstore.model.Address;
import com.yusk.bookstore.model.Client;
import com.yusk.bookstore.repository.AddressRepository;
import com.yusk.bookstore.service.AddressService;
import com.yusk.bookstore.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ViaCepService viaCepService;


    @Override
    public void insert(Address address) {
        Address _address = viaCepService.getCep(address.getCep());
        _address.setClient(address.getClient());
        addressRepository.save(_address);
    }

    @Override
    public Optional<Address> update(Integer id, Address address) {
        Optional<Address> addressData = addressRepository.findById(id);
        if(addressData.isPresent()) {
            addressRepository.save(addressData.get());
        }
        return addressData;
    }
}
