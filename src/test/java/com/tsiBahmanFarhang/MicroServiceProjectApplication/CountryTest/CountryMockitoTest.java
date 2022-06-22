package com.tsiBahmanFarhang.MicroServiceProjectApplication.CountryTest;

import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.Actor;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Country.Country;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Country.CountryRepository;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Country.CountryService;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.Film;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.FilmRepository;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.FilmService;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.MicroServiceProjectApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class CountryMockitoTest {

    private MicroServiceProjectApplication microServiceProjectApplication;
    //injecting the countryService to test the methods
    @InjectMocks
    CountryService countryService;
    //make a fake repo
    @MockBean
    CountryRepository countryRepository;
    @BeforeEach
    void setUp(){
        //,mock class has no functions
        countryRepository = mock(CountryRepository.class);
        ArgumentCaptor<Country> actorArgumentCaptor = ArgumentCaptor.forClass(Country.class);
        countryService = new CountryService(countryRepository);
    }
    @Test
    public void getAllCountryTest(){
        Country country = new Country();
        List<Country> countryList = new ArrayList<Country>();
        countryList.add(country);

        when(countryRepository.findAll()).thenReturn(countryList);

        List<Country> expected = countryList;
        List<Country> actual = countryService.getAllCountry();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void deleteCountryTest(){

        countryService.deleteById(1L);
        verify(countryRepository,times(1)).deleteById(1L);
    }
    @Test
    public void addCountryTest(){

        Country country = new Country();
        List<Country> countryList = new ArrayList<Country>();
        countryList.add(country);

        when(countryRepository.saveAll(countryList)).thenReturn(countryList);

        Iterable<Country> expected = countryList;
        Iterable<Country> actual = countryService.addCountry(countryList);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void updateTestNoId(){
        when(countryRepository.existsById(1L)).thenReturn(false);
        Country actual = countryService.updateCountry(1L, new Country());
        Assertions.assertEquals(null, actual);
    }
    @Test
    public void updateTestId(){
        Country country = new Country();
        when(countryRepository.existsById(1L)).thenReturn(true);
        when(countryRepository.save(country)).thenReturn(country);
        Country actual = countryService.updateCountry(1L, country);
        Assertions.assertEquals(country, actual);
    }
}
