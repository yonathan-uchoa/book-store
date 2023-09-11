package com.yusk.bookstore.controller;

import com.yusk.bookstore.model.Client;
import com.yusk.bookstore.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("client")
public class ClientRestController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<Client>> searchAll() {
        return ResponseEntity.ok(clientService.searchAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> searchById(@PathVariable Integer id) {
        Optional<Client> user = clientService.searchById(id);
        if(user.isPresent())
            return ResponseEntity.ok(user.get());
       return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody @Valid Client client){
        clientService.insert(client);
        return ResponseEntity.ok(client);
    }
}
