package com.yusk.bookstore.rest;

import com.yusk.bookstore.dto.request.AddressPostRequestBody;
import com.yusk.bookstore.dto.response.AddressDTO;
import com.yusk.bookstore.mapper.AddressMapper;
import com.yusk.bookstore.model.Address;
import com.yusk.bookstore.model.Client;
import com.yusk.bookstore.service.AddressService;
import com.yusk.bookstore.service.ClientService;
import com.yusk.bookstore.service.ViaCepService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @Operation(security = { @SecurityRequirement(name = "bearer-auth") })
    public ResponseEntity<Address> insert(@PathVariable Integer clientId, @RequestBody @Valid AddressPostRequestBody addressDTO){
        Optional<Client> _client = clientService.searchById(clientId);
        if(_client.isPresent()){
            Address _address = AddressMapper.INSTANCE.toAddress(addressDTO);
            AddressDTO _addressDTO = viaCepService.getCep(addressDTO.getCep());
            AddressMapper.INSTANCE.updateAddress(_addressDTO, _address);
            _address.setClient(_client.get());
            Address response = addressService.save(_address);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{addressId}")
    @Operation(security = { @SecurityRequirement(name = "bearer-auth") })
    public ResponseEntity<Address> searchById(@PathVariable Integer addressId) {
        Optional<Address> _address = addressService.searchById(addressId);
        if(_address.isPresent()){
            return ResponseEntity.ok(_address.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{addressId}")
    @Operation(security = { @SecurityRequirement(name = "bearer-auth") })
    public ResponseEntity<Address> update(@PathVariable Integer addressId, @RequestBody AddressPostRequestBody addressDTO) {
        Optional<Address> _address = addressService.searchById(addressId);
        if(_address.isPresent()){
            if (addressDTO.getCep() != null) {
                AddressDTO _addressDTO = viaCepService.getCep(addressDTO.getCep());
                AddressMapper.INSTANCE.updateAddress(_addressDTO, _address.get());
            }
            AddressMapper.INSTANCE.updateAddress(addressDTO, _address.get());
            return ResponseEntity.ok(addressService.save(_address.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{addressId}")
    @Operation(security = { @SecurityRequirement(name = "bearer-auth") })
    public ResponseEntity<String> delete(@PathVariable Integer addressId){
        Optional<Address> _address = addressService.searchById(addressId);
        if(_address.isPresent()){
            Integer id = _address.get().getId();
            addressService.delete(addressId);
            return ResponseEntity.ok("Address " + id + " removed successfully");
        }
        return ResponseEntity.notFound().build();
    }

}
