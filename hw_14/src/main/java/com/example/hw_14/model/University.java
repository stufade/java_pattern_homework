package com.example.hw_14.model;

import java.time.LocalDate;

public class University {
    private String name;
    private LocalDate creationDate;

    public University() {
    }

    public University(String name, LocalDate creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

}
