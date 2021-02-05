package com.example.demo.repositories;

import com.example.demo.model.dto.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, String> {
}
