package com.codingdojo.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(HttpSession session){
		Integer count = (Integer)session.getAttribute("count");
		if(count == null) {
			session.setAttribute("count", 0);
		}
		else {
			count = count + 1;
			session.setAttribute("count", count);
		}
        
        return "index.jsp";
    }
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		model.addAttribute("counter", session.getAttribute("count"));
		return "counter.jsp";
		
	}

}
