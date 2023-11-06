package com.yusk.bookstore.service;

import com.yusk.bookstore.dto.ClientDTO;
import com.yusk.bookstore.model.Client;

import java.util.Optional;

public interface ClientService {
    Iterable<Client> searchAll();

    Optional<ClientDTO> searchById(Integer id);

    void insert(Client client);

    Optional<Client> update(Integer id, Client client);

    void delete(Integer id);
}
