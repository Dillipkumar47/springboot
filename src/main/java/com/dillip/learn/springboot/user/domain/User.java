package com.dillip.learn.springboot.user.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;


public class User {
    private Integer id;
    @Size(min=2, message="Name should have at least 2 characters")
    private String name;
    @Past(message="Date of birth should be in the past")
    private LocalDate birthDate;

    public User() {

    }

    public User(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
