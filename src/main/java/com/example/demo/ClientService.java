package com.example.demo;

import com.example.demo.model.dto.ClientDto;
import com.example.demo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepo;

    public List<ClientDto> getAllClients() {
        List<ClientDto> clients = new ArrayList<>();
        clientRepo.findAll().forEach(clients::add);
        return clients;
    }

    public void addClient(ClientDto clientDto) {
        clientRepo.save(clientDto);
    }
}
