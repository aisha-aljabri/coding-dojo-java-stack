package com.codingdojo.CategoriesProducts.repositories;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.CategoriesProducts.models.Association;

public interface AssociationRepoistory extends CrudRepository<Association, Long>{

}