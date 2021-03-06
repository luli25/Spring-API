package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.model.dto.ClientDto;
import com.example.demo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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
        clientDto.setLastname(client.getLastname());
        clientDto.setAge(client.getAge());
        clientDto.setBirthday(client.getBirthday());
        return clientDto;
    }

    // Dto to Entity
    public Client toEntity(ClientDto clientDto) {
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setLastname(clientDto.getLastname());
        client.setAge(clientDto.getAge());
        client.setBirthday(clientDto.getBirthday());
        return client;
    }

    public List<ClientDto> getAllClients() {
        return ((List<Client>)clientRepo.findAll()).stream().map(this::entityToDto)
                .collect(Collectors.toList());
    }

    public ClientDto findByName(String name) {
        return entityToDto(clientRepo.findById(name)
                .orElseThrow(NoSuchElementException::new));
    }

    public Client addClient(ClientDto clientDto) {
        Client client = toEntity(clientDto);
        return clientRepo.save(client);
    }

    public Client updateClient(String name, ClientDto clientDto) {
        Client client = toEntity(clientDto);
        return clientRepo.save(client);
    }

    public void deleteClient(String name) {
        clientRepo.deleteById(name);
    }

}
