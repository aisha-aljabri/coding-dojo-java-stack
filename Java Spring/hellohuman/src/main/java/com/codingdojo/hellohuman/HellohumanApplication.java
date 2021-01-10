package com.codingdojo.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@SpringBootApplication
public class HellohumanApplication {
	public static void main(String[] args) {
		SpringApplication.run(HellohumanApplication.class, args);
	}
	
	@RequestMapping("/")
	public String index( @RequestParam(value="first_name", required=false) String first_name) {
		if (first_name == null) {
			return "Hello Human, </br>Welcome to SpringBoot.";
		} else  
			return "Hello "+first_name+" </br>Welcome to SpringBoot.";
	}

}
