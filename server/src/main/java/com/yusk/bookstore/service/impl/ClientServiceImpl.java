package com.yusk.bookstore.service.impl;

import com.yusk.bookstore.dto.ClientDTO;
import com.yusk.bookstore.mapper.ClientMapper;
import com.yusk.bookstore.model.Client;
import com.yusk.bookstore.repository.ClientRepository;
import com.yusk.bookstore.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
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
    public Optional<ClientDTO> searchByIdDTO(Integer id) {
        Optional<Client> findUser = clientRepository.findById(id);
        Optional<ClientDTO> response = Optional.empty();
        if(findUser.isPresent())
            response = Optional.of(ClientMapper.INSTANCE.clientToDTO(findUser.get()));
        return response;
    }
    @Override
    public Optional<Client> searchById(Integer id) {
        return clientRepository.findById(id);
    }
    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }
    @Override
    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }
}
