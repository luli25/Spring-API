package com.example.demo.controller;

import com.example.demo.model.dto.ClientDto;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public void addClient(@RequestBody @DateTimeFormat(pattern = "yyyy-MM-dd") ClientDto clientDto) {
        clientService.addClient(clientDto);
    }

    @PutMapping("Client/{name}")
    public void updateClient(@PathVariable String name, @RequestBody @DateTimeFormat(pattern = "yyyy-MM-dd") ClientDto clientDto) {
        clientService.updateClient(name, clientDto);
    }

    @DeleteMapping("Client/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable String name) {
        clientService.deleteClient(name);
    }

}
