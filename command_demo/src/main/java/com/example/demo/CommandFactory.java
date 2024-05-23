package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CommandFactory {

    private Map<String, Command> commands;

    public CommandFactory(List<Command> commandList) {
        commands = new HashMap<>();
        for (Command command : commandList) {
            commands.put(command.getName(), command);
        }
    }

    public Command getCommand(String name) {
        Command command = commands.get(name);
        if (command == null) {
            throw new IllegalArgumentException("No such command");
        }
        return command;
    }
}
