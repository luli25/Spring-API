package com.example.demo;

import com.example.demo.model.Client;
import com.example.demo.model.dto.ClientDto;
import com.example.demo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private final ClientRepository clientRepo;

    public ClientService(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }

    // Entity to Dto
    public ClientDto entityToDto(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setName(client.getName());
        return clientDto;
    }

    public List<ClientDto> getAllClients() {
        return ((List<Client>)clientRepo.findAll()).stream().map(this::entityToDto)
                .collect(Collectors.toList());
    }

    public ClientDto findByName(String name) {
        return entityToDto(clientRepo.findById(name).orElse(clientRepo.save(new Client(name))));
    }

    public void addClient(Client client) {
        clientRepo.save(client);
    }

}
