package com.yusk.bookstore.controller;

import com.yusk.bookstore.model.Address;
import com.yusk.bookstore.model.Client;
import com.yusk.bookstore.service.AddressService;
import com.yusk.bookstore.service.ClientService;
import com.yusk.bookstore.service.ViaCepService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("address")
public class AddressRestController {
    @Autowired
    AddressService addressService;
    @Autowired
    ClientService clientService;
    @Autowired
    ViaCepService viaCepService;

    @PostMapping("/{clientId}")
    public ResponseEntity<?> insert(@PathVariable Integer clientId, @RequestBody @Valid Address address){
        Optional<Client> _client = clientService.searchById(clientId);
        if(_client.isPresent()){
            Address _address = viaCepService.getCep(address.getCep());
            _address.setClient(_client.get());
            addressService.insert(_address);
            return ResponseEntity.ok(_address);
        }

        return ResponseEntity.notFound().build();
    }
}
