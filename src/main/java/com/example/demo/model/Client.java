package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Clients")
public class Client {

    @Id
    private String name;
    private String lastname;
    private int age;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    public Client(String name, String lastname, int age, LocalDate birthday) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.birthday = birthday;
    }

    public Client() {
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
        return "Client{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
