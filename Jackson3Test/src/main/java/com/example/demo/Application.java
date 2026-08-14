package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tools.jackson.databind.json.JsonMapper;

@SpringBootApplication
public class Application {

    private final JsonMapper jsonMapper;

    public Application(JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
