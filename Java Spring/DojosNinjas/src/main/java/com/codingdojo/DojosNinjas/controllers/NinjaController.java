package com.codingdojo.DojosNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.DojosNinjas.models.Dojo;
import com.codingdojo.DojosNinjas.models.Ninja;
import com.codingdojo.DojosNinjas.services.DojoService;
import com.codingdojo.DojosNinjas.services.NinjaService;

@Controller
public class NinjaController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService=ninjaService;
		this.dojoService=dojoService;
	}
	
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos",dojos);
		return "views/newNinja.jsp";
	}
    
	@RequestMapping(value="/ninja", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "views/newNinja.jsp";
		}
		else {
		    ninjaService.createNinja(ninja);
			return "redirect:/";
		}
	}

}
