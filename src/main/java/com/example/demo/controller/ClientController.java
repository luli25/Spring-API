package com.example.demo.controller;

import com.example.demo.ClientService;
import com.example.demo.model.dto.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/Client")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping("/Client")
    public void addClient(@RequestBody Client client) {
        clientService.addClient(client);
    }

}
