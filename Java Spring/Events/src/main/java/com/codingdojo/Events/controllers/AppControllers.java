package com.codingdojo.Events.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.Events.models.Comment;
import com.codingdojo.Events.models.Event;
import com.codingdojo.Events.models.EventUser;
import com.codingdojo.Events.models.User;
import com.codingdojo.Events.services.AppService;
import com.codingdojo.Events.validator.UserValidator;

@Controller
public class AppControllers {
    private final AppService appService;
    private final UserValidator userValidator;
    
    public AppControllers(AppService appService, UserValidator userValidator) {
        this.appService = appService;
        this.userValidator = userValidator;
    }
    
    
    //registration & login
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "views/registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login(HttpSession session) {
    	if(session.getAttribute("id") == null) {
        return "views/loginPage.jsp";
        }
    	else {
    		return"redirect:/home";
    	}
    }
    
    
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
    	userValidator.validate(user, result);
        if(result.hasErrors()) {
            return "views/registrationPage.jsp";
        }
        User u = appService.registerUser(user);
        session.setAttribute("id", u.getId());
        return "redirect:/home";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
    	if(appService.authenticateUser(email, password)) {
    		session.setAttribute("id", appService.findByEmail(email).getId());
    		return "redirect:/home"; 
    	}else {
    		model.addAttribute("error", "Invalid Credentials.");
    		return "views/loginPage.jsp";
    	}
    }
    
    
    
    @RequestMapping("/home")
    public String homePage(HttpSession session,Model model,@ModelAttribute("event")Event event) {
			User user = appService.getUserById((Long)session.getAttribute("id"));
			model.addAttribute("user", user);
			model.addAttribute("sameState",appService.sameState(user.getState()));
			model.addAttribute("anotherState",appService.anotherState(user.getState()));
			model.addAttribute("joinsEvent",appService.joinedEvents());
			return "views/homePage.jsp";

	}
    
    
    //Events
    @RequestMapping(value="/event", method=RequestMethod.POST)
    public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session, Model model) {
    	if(result.hasErrors()) {
    		User user = appService.getUserById((Long)session.getAttribute("id"));
		    model.addAttribute("user", user);
		    model.addAttribute("sameState",appService.sameState(user.getState()));
		    model.addAttribute("anotherState",appService.anotherState(user.getState()));
		    model.addAttribute("joinsEvent",appService.joinedEvents());
		    return "views/homePage.jsp";
	}
	else {
		appService.createEvent(event, (Long)session.getAttribute("id"));
		return"redirect:/home";
	} }
    
    @RequestMapping("/events/{id}")
    public String event(@PathVariable("id") Long id, Model model, HttpSession session, @ModelAttribute("comment")Comment comment) {
    	model.addAttribute("user", appService.getUserById((Long)session.getAttribute("id")));
    	model.addAttribute("event", appService.findevent(id));
    	return "views/event.jsp";
    }
    
    @RequestMapping("/events/{id}/delete")
    public String deleteEvent(@PathVariable("id")Long id) {
    	appService.deleteEvent(id);
    	return"redirect:/home";
    }
    
    @RequestMapping("/events/{id}/edit")
    public String editEvent(@ModelAttribute("event")Event event, @PathVariable("id")Long id, Model model) {
    	model.addAttribute("event",appService.findevent(id));
    	return"views/editEvent.jsp";
    }
    
    @RequestMapping(value="/events/{id}/edit", method=RequestMethod.POST)
    public String editEvent(@Valid @ModelAttribute("event")Event event, BindingResult result,@PathVariable("id")Long id,Model model, HttpSession session) {
    	if(result.hasErrors()) {
    		model.addAttribute("event",appService.findevent(id));
    		return"views/editEvent.jsp";
    	}
    	else {
    		event.setId(id);
    		event.setUser(appService.getUserById((Long)session.getAttribute("id")));
    		appService.editEvent(event);
    		return"redirect:/home";
    	}
    }
     @RequestMapping(value="/join/{eventId}/add")
     public String join(@PathVariable("eventId")Long eventId,HttpSession session) {
    	     EventUser eventuser=new EventUser();
    		 eventuser.setEvent(appService.findevent(eventId));
    		 eventuser.setUser(appService.getUserById((Long)session.getAttribute("id")));
    		 appService.createEventUser(eventuser);
    		 return"redirect:/home";
     }
     
     @RequestMapping("/join/{eventId}/cancel")
     public String cancel(@PathVariable("eventId")Long eventId, HttpSession session) {
    	 EventUser result = appService.findEventUser(appService.findevent(eventId), appService.getUserById((Long)session.getAttribute("id")));
    	 appService.cancel(result);
    	 return"redirect:/home";
    }
     
    
 //Comment
    @RequestMapping(value="/events/{eventId}", method=RequestMethod.POST)
    public String addComment(@PathVariable("eventId")Long eventId, HttpSession session, @Valid @ModelAttribute("comment")Comment comment, BindingResult result, Model model) {
    	comment.setUser(appService.getUserById((Long)session.getAttribute("id")));
    	comment.setEvent(appService.findevent(eventId));
    	appService.addComment(comment);
    	return"redirect:/events/{eventId}";
    }
    
    @RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		return "redirect:/login";
	}
    

}
