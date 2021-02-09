package com.example.demo.model.dto;

import java.io.Serializable;

public class ClientDto implements Serializable {

    private String name;

    public ClientDto() {
    }

    public ClientDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
