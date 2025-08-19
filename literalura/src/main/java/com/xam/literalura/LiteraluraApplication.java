package com.xam.literalura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

    @Autowired
    private CliInterface cliInterface;

	public static void main(String[] args) {

        SpringApplication.run(LiteraluraApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        cliInterface.run();
    }
}
