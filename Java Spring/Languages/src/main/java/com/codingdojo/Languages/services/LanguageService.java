package com.codingdojo.Languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.Languages.models.Language;
import com.codingdojo.Languages.repositories.LanguagesRepository;


@Service
public class LanguageService {
	private final LanguagesRepository languageRepository;
	
	public LanguageService(LanguagesRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguage() {
	        return languageRepository.findAll();
	}
	
	public Language createLanguage(Language l) {
        return languageRepository.save(l);
    }
	public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
	
	public Language updateLanguage(Long id, String name, String creator, double version) {
    	Optional <Language> language = languageRepository.findById(id);
    	if(language != null) {
    		Language theLanguage = language.get();
    		theLanguage.setName(name);
    		theLanguage.setCreator(creator);
    		theLanguage.setVersion(version);
    		return languageRepository.save(theLanguage);
    	}
    	return null;        
    }
	
	public Language updateLanguage(Language l) {
    	return languageRepository.save(l);
    } 
    
    // deletes a book
    public void deleteLanguage(Long id) {
    	languageRepository.deleteById(id);
    }

}
