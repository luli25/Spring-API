package com.example.demo;


import com.example.demo.model.dto.Client;
import com.example.demo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepo;

    public List<Client> getAllClients() {
        List<Client> clientList = new ArrayList<>();
        clientRepo.findAll().forEach(clientList::add);
        return clientList;
    }

    public void addClient(Client client) {
        clientRepo.save(client);
    }


}
