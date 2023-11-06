package com.yusk.bookstore.rest;

import com.yusk.bookstore.dto.AddressDTO;
import com.yusk.bookstore.dto.ClientDTO;
import com.yusk.bookstore.mapper.ClientMapper;
import com.yusk.bookstore.model.Address;
import com.yusk.bookstore.service.AddressService;
import com.yusk.bookstore.service.ClientService;
import com.yusk.bookstore.service.ViaCepService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
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
        Optional<ClientDTO> _client = clientService.searchById(clientId);
        if(_client.isPresent()){
            address.setClient(ClientMapper.INSTANCE.dtoToClient(_client.get()));
            address = addressService.insert(address);
            return ResponseEntity.ok(address);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<?> searchById(@PathVariable Integer addressId){
        Optional<AddressDTO> _address = addressService.searchById(addressId);
        if(_address.isPresent()){
            return ResponseEntity.ok(_address);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<String> delete(@PathVariable Integer addressId){
        Optional<AddressDTO> _address = addressService.searchById(addressId);
        if(_address.isPresent()){
            addressService.delete(addressId);
            return ResponseEntity.ok("Address "+_address.get().getId()+" removed successfully");
        }
        return ResponseEntity.notFound().build();
    }

}
