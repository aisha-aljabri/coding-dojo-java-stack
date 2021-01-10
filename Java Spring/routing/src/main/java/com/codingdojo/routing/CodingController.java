package com.codingdojo.routing;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {
	@RequestMapping("")
	public String hellocoding() {
		return "Hello Coding Dojo!";
	}
	
	@RequestMapping("/python")
	public String hellopython() {
		return "Python/Django was awesome!";
	}
	
	@RequestMapping("/java")
	public String hellojava() {
		return "Java/Spring is better!";
	}

}
