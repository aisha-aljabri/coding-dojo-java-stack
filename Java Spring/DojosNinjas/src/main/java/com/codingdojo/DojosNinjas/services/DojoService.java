package com.codingdojo.DojosNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.DojosNinjas.models.Dojo;
import com.codingdojo.DojosNinjas.repositories.DojosRepository;

@Service
public class DojoService {
	private final DojosRepository dojoRepository;
	
	public DojoService(DojosRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	
	public Dojo createDojo(Dojo d) {
		return dojoRepository.save(d);
	}
	
	public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }

}
