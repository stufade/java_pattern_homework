package com.example.hw_12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LifecycleAppApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LifecycleAppApplication.class, args);
        FileProcessor fileProcessor = context.getBean(FileProcessor.class);
    }
}
