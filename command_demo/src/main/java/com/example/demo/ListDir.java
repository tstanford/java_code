package com.example.demo;
import java.io.File;
import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class ListDir implements Command {
    @Override
    public void run(String path) {
        File file = new File(path);
        Arrays.asList(file.list()).stream().forEach(System.out::println);
    }

    @Override
    public String getName() {
        return "ls";
    }
}
