package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final CommandFactory commandFactory;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public DemoApplication(CommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}

	@Override
	public void run(String... args) throws Exception {
		commandFactory.getCommand("pwd").run("C:\\");
		commandFactory.getCommand("ls").run("C:\\");
	}
}
