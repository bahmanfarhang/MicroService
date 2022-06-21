package com.tsiBahmanFarhang.MicroServiceProjectApplication.Language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    @Autowired
    LanguageRepository languageRepository;

    //methods
    public List<Language> getAllLanguage(){
        return languageRepository.findAll();
    }
    public List<Language> addLanguage(List<Language> languages){
        return languageRepository.saveAll(languages);
    }
    public void deleteById(Long id){
        languageRepository.deleteById(id);
    }
    public Language updateLanguage(Long id, Language language){
        if (languageRepository.existsById(id)){
            language.setLanguage_id(id);
            return languageRepository.save(language);
        }
        return null;
    }
}
