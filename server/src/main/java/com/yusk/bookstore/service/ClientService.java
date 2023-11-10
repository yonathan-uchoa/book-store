package com.yusk.bookstore.service;

import com.yusk.bookstore.dto.ClientDTO;
import com.yusk.bookstore.model.Client;

import java.util.Map;
import java.util.Optional;

public interface ClientService {
    Iterable<Client> searchAll();
    Optional<ClientDTO> searchByIdDTO(Integer id);
    Optional<Client> searchById(Integer id);
    void save(Client client);
    void delete(Integer id);
}
