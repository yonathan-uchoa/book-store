package com.yusk.bookstore.service.impl;

import com.yusk.bookstore.dto.response.AddressDTO;
import com.yusk.bookstore.dto.request.AddressPostRequestBody;
import com.yusk.bookstore.mapper.AddressMapper;
import com.yusk.bookstore.model.Address;
import com.yusk.bookstore.model.Client;
import com.yusk.bookstore.repository.AddressRepository;
import com.yusk.bookstore.repository.ClientRepository;
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

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Optional<AddressDTO> update(Integer id, AddressDTO addressDTO) {
        Optional<Address> addressData = addressRepository.findById(id);
        if(addressData.isPresent()) {
            Address _address = AddressMapper.INSTANCE.dtoToAddress(addressDTO);
            addressRepository.save(_address);
            return Optional.of(addressDTO);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Address> searchById(Integer id) {
        return addressRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        addressRepository.deleteById(id);
    }
}
