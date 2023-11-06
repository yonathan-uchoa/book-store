package com.yusk.bookstore.service.impl;

import com.yusk.bookstore.dto.AddressDTO;
import com.yusk.bookstore.mapper.AddressMapper;
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
    public Address insert(Address address) {
        Address _address = address;
        address = viaCepService.getCep(address.getCep());
        address.setClient(_address.getClient());
        address.setComplemento(_address.getComplemento());
        address.setSurname(_address.getSurname());
        address.setNumber(_address.getNumber());
        addressRepository.save(address);
        return address;
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
    public Optional<AddressDTO> searchById(Integer id) {
        Optional<Address> findAddress = addressRepository.findById(id);
        Optional<AddressDTO> response = Optional.empty();
        if(findAddress.isPresent()){
            response = Optional.of(AddressMapper.INSTANCE.addressToDTO(findAddress.get()));
        }
        return response;
    }

    @Override
    public void delete(Integer id) {
        addressRepository.deleteById(id);
    }
}
