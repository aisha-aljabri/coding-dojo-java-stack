package com.codingdojo.CategoriesProducts.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.CategoriesProducts.models.Category;
import com.codingdojo.CategoriesProducts.models.Product;



public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findAll();
	List<Category> findByProductsNotContains(Product product);
}