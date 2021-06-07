package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "client_address")
public class Address {
    @Id
    private int id;
    private int number;
    private String street;
    private String city;
    private int zipcode;

    public Address() {}

    public Address(int id, int number, String street, String city, int zipcode) {
        this.id = id;
        this.number = number;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", number=" + number +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }
}
