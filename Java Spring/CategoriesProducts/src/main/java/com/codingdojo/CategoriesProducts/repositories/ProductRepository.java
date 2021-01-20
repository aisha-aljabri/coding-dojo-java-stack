package com.codingdojo.CategoriesProducts.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.CategoriesProducts.models.Category;
import com.codingdojo.CategoriesProducts.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);
}