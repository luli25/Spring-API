package com.example.demo.controller;

import com.example.demo.ClientService;
import com.example.demo.model.Client;
import com.example.demo.model.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/Client")
    public List<ClientDto> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/Client/{name}")
    public ClientDto getClient(@PathVariable String name) {
        return clientService.getClient(name);
    }

    @PostMapping("/Client")
    public void addClient(@RequestBody Client client) {
        clientService.addClient(client);
    }

}
