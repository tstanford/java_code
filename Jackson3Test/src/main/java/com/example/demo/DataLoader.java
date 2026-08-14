package com.example.demo;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataLoader.class);
    private static final String PEOPLE_JSON_PATH = "classpath:/data/people.json";

    private List<Person> people;
    private final JsonMapper jsonMapper;
    private final ResourceLoader resourceLoader;

    public DataLoader(JsonMapper jsonMapper, ResourceLoader resourceLoader) {
        this.jsonMapper = jsonMapper;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Loading people");
        validateSerialization(List.of(new Person("Dave", "Brown")));
        try{
            Resource resource = resourceLoader.getResource(PEOPLE_JSON_PATH);

            if(!resource.exists()) {
                log.error("file not found {}", PEOPLE_JSON_PATH);
                return;
            }

            this.people = jsonMapper.readValue(resource.getInputStream(), new TypeReference<List<Person>>(){});

            log.info("Loaded {} People", people.size());

            people.forEach(System.out::println);
        } catch (JacksonException e) {
            log.info("Error loading people: {}", e.getMessage());
        } catch (Exception e){
            throw e;
        }
    }

    public List<Person> getPeople() {
        return people;
    }

    private void validateSerialization(List<Person> people) {
        String s = jsonMapper.writeValueAsString(people);
        System.out.println(s);
    }
}
