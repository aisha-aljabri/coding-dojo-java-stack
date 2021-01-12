package com.codingdojo.DojoSurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "views/Home.jsp";
	}
	
	@RequestMapping("/result")
	public String info(Model model, HttpSession session) {
		model.addAttribute("name", session.getAttribute("name"));
		model.addAttribute("location", session.getAttribute("location"));
		model.addAttribute("language", session.getAttribute("language"));
		model.addAttribute("comment", session.getAttribute("comment"));
		return "views/result.jsp";
	}
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
    public String result(@RequestParam(value="name")String name, @RequestParam(value="location")String location, @RequestParam(value="language")String language, @RequestParam(value="comment")String comment, HttpSession session) {
  	  session.setAttribute("name", name);
		  session.setAttribute("location", location);
		  session.setAttribute("language", language);
		  session.setAttribute("comment", comment);
		  return "redirect:/result";
    }
	

}
