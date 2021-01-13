package com.codingdojo.NinjaGold.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		if(session.isNew()) {
			ArrayList<String> activities = new ArrayList<String>();
			session.setAttribute("gold", 0);
			session.setAttribute("activities",activities);
		}
		model.addAttribute("gold", session.getAttribute("gold"));
		model.addAttribute("activities", session.getAttribute("activities"));
		return "views/index.jsp";
	}

}
