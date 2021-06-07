package com.example.demo.controller;

import com.example.demo.model.Address;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/address")
public class AddressController {

    @Autowired
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(value = "/all")
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public Address FindById(@PathVariable("id")int id) {
        return addressService.findById(id);
    }

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAddress(@RequestBody Address address) {
        addressService.createAddress(address);
    }
}
