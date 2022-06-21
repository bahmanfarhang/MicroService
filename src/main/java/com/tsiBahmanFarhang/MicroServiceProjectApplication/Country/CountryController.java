package com.tsiBahmanFarhang.MicroServiceProjectApplication.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/country")

public class CountryController {
    @Autowired
    CountryService countryService;

    //Controller for country
    @GetMapping(value = "/allCountry")
    public Iterable<Country> getAllCountry() {
        return countryService.getAllCountry();
    }

    @PostMapping(value = "/addCountry")
    public List<Country> addCountry(@RequestBody List<Country> country) {
        return countryService.addCountry(country);
    }

    @DeleteMapping(value = "/deleteCountry{id}")
    public void deleteByCountryId(@PathVariable("id") Long id) {
        countryService.deleteById(id);
    }

    @PutMapping(value = "updateCountry/{id}")
    public Country updateCountry(@RequestBody Country country, @PathVariable("id") Long id) {
        return countryService.updateCountry(id, country);
    }
}
