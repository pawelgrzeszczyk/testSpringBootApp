package com.grzeszczyk.client.services;

import com.google.common.collect.Lists;
import com.grzeszczyk.Client;
import com.grzeszczyk.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(Client client) {
        Client savedClient = clientRepository.save(client);
        return savedClient;
    }

    public Client find(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            return client.get();
        }
        return null;
    }

    public List<Client> findAll() {
        Iterable<Client> clientsIterable = clientRepository.findAll();
        List<Client> clientsList = Lists.newArrayList(clientsIterable);
        return clientsList;
    }

    public Client update(Client client) {
        Client updatedClient = clientRepository.save(client);
        return updatedClient;
    }

    public void delete(Long id) {

        clientRepository.deleteById(id);
    }
}
