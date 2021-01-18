package com.codingdojo.DojosNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.DojosNinjas.models.Ninja;
import com.codingdojo.DojosNinjas.repositories.NinjasRepository;




@Service
public class NinjaService {
	private final NinjasRepository ninjaRepository;
	
	public NinjaService(NinjasRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
	
	public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }
	
	public Ninja createNinja(Ninja n) {
		return ninjaRepository.save(n);
	}

}
