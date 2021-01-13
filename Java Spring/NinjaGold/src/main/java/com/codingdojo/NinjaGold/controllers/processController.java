package com.codingdojo.NinjaGold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class processController {
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String process(@RequestParam(value="place")String place, HttpSession session) {
		
		
		if(place.equals("farm")) {
			int val = ThreadLocalRandom.current().nextInt(10,20);
			session.setAttribute("gold", (int)session.getAttribute("gold")+val);
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("MMMM d yyyy HH:mm");
			activities.add("you entered a farm and earned "+val+" gold. ("+formatter.format(date)+")");
			session.setAttribute("activities", activities);
		}
		
		
		if(place.equals("cave")) {
			int val = ThreadLocalRandom.current().nextInt(5,10);
			session.setAttribute("gold", (int)session.getAttribute("gold")+val);
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("MMMM d yyyy HH:mm");
			activities.add("you entered a cave and earned "+val+" gold. ("+formatter.format(date)+")");
			session.setAttribute("activities", activities);
		}
		
		if(place.equals("house")) {
			int val = ThreadLocalRandom.current().nextInt(2,5);
			session.setAttribute("gold", (int)session.getAttribute("gold")+val);
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("MMMM d yyyy HH:mm");
			activities.add("you entered a house and earned "+val+" gold. ("+formatter.format(date)+")");
			session.setAttribute("activities", activities);
		}
		
		if(place.equals("casino")) {
			int val = ThreadLocalRandom.current().nextInt(-50,50);
			session.setAttribute("gold", (int)session.getAttribute("gold")+val);
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("MMMM d yyyy HH:mm");
			activities.add("you entered a casino and earned "+val+" gold. ("+formatter.format(date)+")");
			session.setAttribute("activities", activities);
		}
		
		return"redirect:/";
	}

}
