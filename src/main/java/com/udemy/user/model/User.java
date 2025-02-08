package com.udemy.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity(name ="user_details")
public class User {

    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("birth_date")
    private LocalDate birth_Date;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", Id=" + id +
                ", birthDate=" + birth_Date +
                '}';
    }

    public User() {
    }

    public User(String name, Integer id, LocalDate birth_Date) {
        this.name = name;
        id = id;
        this.birth_Date = birth_Date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        id = id;
    }

    public LocalDate getBirthDate() {
        return birth_Date;
    }

    public void setBirthDate(LocalDate birth_Date) {
        this.birth_Date = birth_Date;
    }
}
