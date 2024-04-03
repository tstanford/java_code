package org.example;

import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Person person = new Person("Tim", "Stanford", LocalDate.of(1978,7,18));

        var mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        var p = mapper.readValue("{\"eyeColour\":\"green\",\"firstname\":\"Tim\",\"surname\":\"Stanford\",\"dateOfBirth\":[1976,5,9]}", Person.class);
    }
}