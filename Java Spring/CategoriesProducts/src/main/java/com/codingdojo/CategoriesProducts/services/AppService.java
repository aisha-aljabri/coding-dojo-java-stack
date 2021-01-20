package com.codingdojo.CategoriesProducts.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.CategoriesProducts.models.Association;
import com.codingdojo.CategoriesProducts.models.Category;
import com.codingdojo.CategoriesProducts.models.Product;
import com.codingdojo.CategoriesProducts.repositories.AssociationRepoistory;
import com.codingdojo.CategoriesProducts.repositories.CategoryRepository;
import com.codingdojo.CategoriesProducts.repositories.ProductRepository;

@Service
public class AppService {
	private final ProductRepository pRepo;
	private final CategoryRepository cRepo;
	private final AssociationRepoistory aRepo;
	public AppService(ProductRepository pRepo, CategoryRepository cRepo, AssociationRepoistory aRepo) {
		this.pRepo = pRepo;
		this.cRepo = cRepo;
		this.aRepo = aRepo;
	}
	
	public Product getProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	public Category getCategory(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	
	public Product createProduct(Product product) {
		return this.pRepo.save(product);
	}
	public Category createCategory(Category category) {
		return this.cRepo.save(category);
	}
	public Association createAssociation(Association ass) {
		return this.aRepo.save(ass);
	}
	
	public List<Category> findCategoriesNotInProduct(Product product) {
		return cRepo.findByProductsNotContains(product);
	}
	public List<Product> findProductsNotInCategory(Category category) {
		return pRepo.findByCategoriesNotContains(category);
	}
	
	
	
	public List<Category> findCategories() {
		return this.cRepo.findAll();
    }
	public List<Product> findProducts() {
		return this.pRepo.findAll();
	}}