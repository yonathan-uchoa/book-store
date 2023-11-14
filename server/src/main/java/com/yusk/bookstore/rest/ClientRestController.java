package com.yusk.bookstore.rest;

import com.yusk.bookstore.dto.ClientDTO;
import com.yusk.bookstore.dto.request.ClientPostRequestBody;
import com.yusk.bookstore.dto.request.ClientPutRequestBody;
import com.yusk.bookstore.dto.response.ClientGetResponseBody;
import com.yusk.bookstore.mapper.ClientMapper;
import com.yusk.bookstore.model.Client;
import com.yusk.bookstore.model.Role;
import com.yusk.bookstore.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("client")
public class ClientRestController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    @Operation(security = { @SecurityRequirement(name = "bearer-auth") })
    public ResponseEntity<Iterable<Client>> searchAll() {
        return ResponseEntity.ok(clientService.searchAll());
    }

    @GetMapping("/{id}")
    @Operation(security = { @SecurityRequirement(name = "bearer-auth") })
    public ResponseEntity<?> searchById(@PathVariable Integer id) {
        Optional<Client> client = clientService.searchById(id);
        if(client.isPresent()) {
            ClientGetResponseBody response = ClientMapper.INSTANCE.toResponse(client.get());
            return ResponseEntity.ok(response);
        }
       return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(security = { @SecurityRequirement(name = "bearer-auth") })
    public ResponseEntity<Client> save(@RequestBody @Valid ClientPostRequestBody clientDTO){
        Client _client = ClientMapper.INSTANCE.toClient(clientDTO);
        clientService.save(_client);
        return ResponseEntity.status(HttpStatus.CREATED).body(_client);
    }

    @PutMapping("/{id}")
    @Operation(security = { @SecurityRequirement(name = "bearer-auth") })
    public ResponseEntity<ClientGetResponseBody> update(@PathVariable Integer id, @RequestBody ClientPutRequestBody clientDTO){
        Optional<Client> _client = clientService.searchById(id);

        if(_client.isPresent()){
            ClientMapper.INSTANCE.updateClient(clientDTO, _client.get());
            clientService.save(_client.get());
            ClientGetResponseBody response = ClientMapper.INSTANCE.toResponse(_client.get());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(security = { @SecurityRequirement(name = "bearer-auth") })
    public ResponseEntity<String> delete(@PathVariable Integer id){
        Optional<Client> _client = clientService.searchById(id);
        if(_client.isPresent()){
            String username = _client.get().getUsername();
            clientService.delete(id);
            return ResponseEntity.ok("client " + username + ", removed successful");
        }
        return ResponseEntity.notFound().build();
    }
}
