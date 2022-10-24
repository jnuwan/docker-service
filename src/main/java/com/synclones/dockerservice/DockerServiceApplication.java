package com.synclones.dockerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DockerServiceApplication {
	
	@GetMapping("/message")
	public String getMessage(){
		return "SP boot application deployment on Docker is success!!!";
	}

	public static void main(String[] args) {
		SpringApplication.run(DockerServiceApplication.class, args);
	}

}
