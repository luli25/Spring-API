package com.example.demo.service;

import com.example.demo.model.Address;
import com.example.demo.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AddressService {

    @Autowired
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAll() {
        return (List<Address>)addressRepository.findAll();
    }

    public Address findById(int id) {
        return addressRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public void createAddress(Address address) {
        addressRepository.save(address);
    }

    public Address updateAddress(int id, Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddress(int id) {
        addressRepository.deleteById(id);
    }
}
