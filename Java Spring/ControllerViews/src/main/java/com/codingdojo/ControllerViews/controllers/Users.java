package com.codingdojo.ControllerViews.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.ControllerViews.models.User;
import com.codingdojo.ControllerViews.services.UserService;
import com.codingdojo.ControllerViews.validator.UserValidator;

@Controller
public class Users {
    private final UserService userService;
    private final UserValidator userValidator;
    
    public Users(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "views/registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "views/loginPage.jsp";
    }
    
    
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
    	userValidator.validate(user, result);
        if(result.hasErrors()) {
            return "views/registrationPage.jsp";
        }
        User u = userService.registerUser(user);
        session.setAttribute("userId", u.getId());
        return "redirect:/home";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
    	if(userService.authenticateUser(email, password)) {
    		session.setAttribute("id", userService.findByEmail(email).getId());
    		return "redirect:/home"; 
    	}else {
    		model.addAttribute("error", "Invalid Credentials.");
    		return "views/loginPage.jsp";
    	}
    }
    
    
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model){
    	if(session.getAttribute("id")==null) {
    		return "redirect:/registration"; 
    	}
    	Long id = (Long)session.getAttribute("id");
    	User user = userService.findUserById(id);
    	model.addAttribute("user", user);
    	return "views/homePage.jsp";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
		return "redirect:/login"; 
    }

}
