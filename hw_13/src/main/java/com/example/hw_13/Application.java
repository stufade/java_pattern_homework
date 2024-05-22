package com.example.hw_13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    @Value("${student.name}")
    private String studentName;

    @Value("${student.last_name}")
    private String studentLastName;

    @Value("${student.group}")
    private String studentGroup;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init() {
        System.out.println("Студент: " + studentName + " " + studentLastName + ", группа: " + studentGroup);
    }
}
