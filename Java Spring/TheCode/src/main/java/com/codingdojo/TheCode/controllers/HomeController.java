package com.codingdojo.TheCode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "views/index.jsp";
	}
	
	@RequestMapping("/code")
	public String code() {
		return "views/code.jsp";
	}
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String error(@RequestParam(value="code")String code, RedirectAttributes redirectAttributes) {
		if(code.equals("bushido")) {
			return "redirect:/code";
		}
		else {
			String error = "you must Try Again";
			redirectAttributes.addFlashAttribute("error", error );
			
		}
		return "redirect:/";
	}

}
