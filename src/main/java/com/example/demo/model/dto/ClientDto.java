package com.example.demo.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class ClientDto implements Serializable {

    private String name;
    private String lastname;
    private int age;
    private LocalDate birthday;

    public ClientDto() {
    }

    public ClientDto(String name, String lastname, int age, LocalDate birthday) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
