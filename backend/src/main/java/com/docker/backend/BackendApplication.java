package com.docker.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BackendApplication {

	@GetMapping("/")
	public String home() {
        return "Hello, Dockerized World!";
    }
	@GetMapping("/resp")
	public String test() {
        return "returns the response in the /resp api";
    }

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
