package com.tsiBahmanFarhang.MicroServiceProjectApplication.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    //methods
    public List<Country> getAllCountry(){
        return countryRepository.findAll();
    }
    public List<Country> addCountry(List<Country> country){
        return countryRepository.saveAll(country);
    }
    public void deleteById(Long id){
        countryRepository.deleteById(id);
    }
    public Country updateCountry(Long id, Country country){
        if (countryRepository.existsById(id)){
            country.setCountry_id(id);
            return countryRepository.save(country);
        }
        return null;
    }



}
