package com.example.demo.controller;

import com.example.demo.service.ClientService;
import com.example.demo.model.Client;
import com.example.demo.model.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/Client")
    public List<ClientDto> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping(value = "/Client/{name}")
    public ClientDto findByName(@PathVariable String name) {
        return clientService.findByName(name);
    }

    @PostMapping("/Client")
    public void addClient(@RequestBody @DateTimeFormat(pattern = "yyyy-MM-dd") Client client) {
        clientService.addClient(client);
    }

}
