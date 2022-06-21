package com.tsiBahmanFarhang.MicroServiceProjectApplication.Language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/language")
public class LanguageController {

    @Autowired
    LanguageService languageService;

    //Controller for language
    @GetMapping(value = "/allLanguage")
    public Iterable<Language> getAllLanguage() {
        return languageService.getAllLanguage();
    }

    @PostMapping(value = "/addLanguage")
    public List<Language> addLanguage(@RequestBody List<Language> language) {
        return languageService.addLanguage(language);
    }

    @DeleteMapping(value = "/deleteLanguage{id}")
    public void deleteByLanguageId(@PathVariable("id") Long id) {
        languageService.deleteById(id);
    }

    @PutMapping(value = "updateLanguage/{id}")
    public Language updateLanguage(@RequestBody Language language, @PathVariable("id") Long id) {
        return languageService.updateLanguage(id, language);
    }
}
