package com.example.demo;

import com.example.demo.model.Client;
import com.example.demo.model.dto.ClientDto;
import com.example.demo.repositories.ClientRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
        return clientDto;
    }

    public List<ClientDto> getAllClients() {
        return ((List<Client>)clientRepo.findAll()).stream().map(this::entityToDto)
                .collect(Collectors.toList());
    }

    public ClientDto findByName(String name) {
        return entityToDto(clientRepo.findById(name).orElseThrow(NoSuchElementException::new));
    }

    public void addClient(Client client) {
        clientRepo.save(client);
    }

    // This class handles any NoSuchElementException throw by findByName method
    // and return a proper response
    @ControllerAdvice
    public static class NoSuchElementController {
        @ExceptionHandler(value = NoSuchElementException.class)
        public ResponseEntity<Object> exception(NoSuchElementException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
