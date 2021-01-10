package com.codingdojo.routing;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping("{variable}")
	public String dojo(@PathVariable("variable") String variable) {
		if(variable.equals("dojo")) {
			return "The dojo is awesome!";
		}
		if(variable.equals("burbank-dojo")) {
			return "Burbank Dojo is located in Southern California.";
		}
		if(variable.equals("san-jose")) {
			return "SJ dojo is the headquarters.";
		}
		return "";
	}	
}
