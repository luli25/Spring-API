package com.example.demo;

import com.example.demo.model.dto.ClientDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ClientService {

    private List<ClientDto> clients = new ArrayList<>(Arrays.asList(
            new ClientDto("Marcos Rojo"),
            new ClientDto("Pablo Perez")
    ));

    public List<ClientDto> getAllClients() {
        return clients;
    }

    public void addClient(ClientDto clientDto) {
        clients.add(clientDto);
    }
}
