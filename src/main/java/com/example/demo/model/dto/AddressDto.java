package com.example.demo.model.dto;

import java.io.Serializable;

public class AddressDto implements Serializable {

    private int number;
    private String street;
    private String city;
    private int zipcode;

    public AddressDto() {

    }

    public AddressDto(int number, String street, String city, int zipcode) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
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
        return "AddressDto{" +
                "number=" + number +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }
}
