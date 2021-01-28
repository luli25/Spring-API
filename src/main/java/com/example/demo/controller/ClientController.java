package com.example.demo.controller;

import com.example.demo.ClientService;
import com.example.demo.model.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/ClientDto")
    public List<ClientDto> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping("/ClientDto")
    public void addClient(@RequestBody ClientDto clientDto) {
        clientService.addClient(clientDto);
    }

}
