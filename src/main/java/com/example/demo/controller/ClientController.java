package com.example.demo.controller;

import com.example.demo.ClientDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @GetMapping("/ClientDto")
    public ClientDto clientDto(@RequestParam(value = "name", defaultValue = "NN")String name) {
        return new ClientDto(name);
    }

}
