package com.codingdojo.DojosNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.DojosNinjas.models.Dojo;


@Repository
public interface DojosRepository extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();
}
