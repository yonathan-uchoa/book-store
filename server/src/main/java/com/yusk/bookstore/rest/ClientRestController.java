package com.yusk.bookstore.rest;

import com.yusk.bookstore.dto.ClientDTO;
import com.yusk.bookstore.mapper.ClientMapper;
import com.yusk.bookstore.model.Client;
import com.yusk.bookstore.service.ClientService;
import feign.Response;
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
        Optional<ClientDTO> client = clientService.searchById(id);
        if(client.isPresent())
            return ResponseEntity.ok(client.get());
       return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody @Valid Client client){
        clientService.insert(client);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Integer id,@RequestBody @Valid Client client){
        Optional<ClientDTO> _client = clientService.searchById(id);
        if(_client.isPresent()){
            client.setId(id);
            clientService.insert(client);
            return ResponseEntity.ok(ClientMapper.INSTANCE.clientToDTO(client));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        Optional<ClientDTO> _client = clientService.searchById(id);
        if(_client.isPresent()){
            clientService.delete(id);
            return ResponseEntity.ok("client "+_client.getClass().getName()+", removed successful");
        }
        return ResponseEntity.notFound().build();
    }
}
