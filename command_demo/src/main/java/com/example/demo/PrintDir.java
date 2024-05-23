package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class PrintDir implements Command {
    @Override
    public void run(String path) {
        System.out.println(path);
    }

    @Override
    public String getName() {
        return "pwd";
    }
}
