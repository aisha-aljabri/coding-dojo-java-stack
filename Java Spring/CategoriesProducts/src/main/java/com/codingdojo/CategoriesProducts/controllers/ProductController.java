package com.codingdojo.CategoriesProducts.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.CategoriesProducts.models.Association;
import com.codingdojo.CategoriesProducts.models.Category;
import com.codingdojo.CategoriesProducts.models.Product;
import com.codingdojo.CategoriesProducts.services.AppService;

@Controller
public class ProductController {
	private AppService appService;
	public ProductController(AppService service) {
		this.appService = service;
	}
	@RequestMapping("/")
	public String Index(Model model) {
		model.addAttribute("categories", appService.findCategories());
		model.addAttribute("products", appService.findProducts());
		return "products/index.jsp";
	}
	
	
	
	@RequestMapping("product/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "products/new.jsp";
	}
	
	@RequestMapping("category/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "categories/new.jsp";
	}
	
	
	
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "product/new.jsp";
		}
		else {
			appService.createProduct(product);
			return "redirect:/product/new";
		}
	}
	
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "categories/new.jsp";
		}
		else {
			appService.createCategory(category);
			return "redirect:/category/new";
		}
	}
	
	
	@RequestMapping("products/{id}")
	public String ShowProduct(@ModelAttribute("association") Association association, 
		@PathVariable("id") Long id, Model model) 
	{
		Product thisOne = appService.getProduct(id);
		List<Category> others = appService.findCategoriesNotInProduct(thisOne);
		model.addAttribute("product", thisOne);
		model.addAttribute("notInCategories", others);
		return "products/show.jsp";
	}
	
	@RequestMapping("categories/{id}")
	public String ShowCategory(@ModelAttribute("association") Association association, 
		@PathVariable("id") Long id, Model model) 
	{
		Category thisOne = appService.getCategory(id);
		List<Product> others = appService.findProductsNotInCategory(thisOne);
		model.addAttribute("category", thisOne);
		model.addAttribute("notInProducts", others);
		return "categories/show.jsp";
	}
	
	@PostMapping("/associations/{kind}")
	public String Create(@Valid @ModelAttribute("association") Association association,
			BindingResult result,
			@PathVariable("kind") String kind) {
		if(result.hasErrors())
			return String.format("/%s/show.jsp", kind);
		appService.createAssociation(association);
		return "redirect:/";
	}
	
	
	
}