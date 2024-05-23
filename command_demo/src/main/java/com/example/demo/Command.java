package com.example.demo;

public interface Command {

    void run(String path);

    String getName();
}
