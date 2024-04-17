package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Main {
    public static void main(String[] args) throws IOException {
        String data = Files.readString(Path.of("C:\\Users\\tim.stanford\\Code\\Tim\\yamlReader\\data.yml"));
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        List<Button> buttons = mapper.readValue(data, List.class);
    }
}