package com.example.demo.repositories;


import com.example.demo.model.dto.ClientDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<ClientDto, String>{
}
