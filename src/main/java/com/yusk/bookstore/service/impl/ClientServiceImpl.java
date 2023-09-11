package com.yusk.bookstore.service.impl;

import com.yusk.bookstore.model.Client;
import com.yusk.bookstore.repository.ClientRepository;
import com.yusk.bookstore.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;


    @Override
    public Iterable<Client> searchAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> searchById(Integer id) {
        Optional<Client> findUser = clientRepository.findById(id);
        return findUser;
    }

    @Override
    public void insert(Client client) {
        System.out.println(client);
        clientRepository.save(client);
    }

    @Override
    public Optional<Client> update(Integer id, Client client) {
        Optional<Client> userData = clientRepository.findById(id);
        if(userData.isPresent()) {
            Client _client = userData.get();
            _client.setName(client.getName());
            _client.setPassword(client.getPassword());
            _client = clientRepository.save(_client);
            return Optional.of(_client);
        }
        return userData;
    }

    @Override
    public void delete(Integer id) {

    }
}
