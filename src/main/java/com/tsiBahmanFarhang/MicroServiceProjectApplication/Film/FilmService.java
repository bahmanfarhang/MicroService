package com.tsiBahmanFarhang.MicroServiceProjectApplication.Film;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.Film;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* @Service will make this class a service provider - calling an external API (Application Programming Interface)
* and, API is a software intermediary between two applications so communication can take place
* and in my case, FilmService is that intermediary for communication - the service provider
*/



/*
* so when i try to access the url, the first thing the code looks for is a "controller - 1st" layer because this
* is the layer that is responsible for "transforming" my request into response IE : i try to access localhost:8080/getActors.
* the "Controller layer" looks if that url is declared in code , if yes , it tries to execute that piece of code , if not
* it shows 404 not found. so, when the request is successful. the code will basically go into "second layer" which is "service"
* A service layer is basically everything i need to execute something ( functions , getters , setters , remove , add etc...)
* but in order to access these functions , i need the "3rd layer" which is known as "repository". This layer contains everything to
* manipulate the database , basically everything that's why i call it Repository. and it is responsible for database manipulation.
*
* */
@Service
public class FilmService {

    //@Autowired helps with the injection of dependency
    //this is an instance of filmRepo
    @Autowired
    FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }
    public FilmService( ){
    }

    //the test case will be for the filmService and i will mock the data from my filmRepository - therefore i do NOT
    //need to get the data from the actual database as i will mock it from the filmRepository

    // the filmRepository.findAll will execute a SQL statement of select all from film and returns the result into a list of films
    // so instead of typing SQL statements manually , filmRepository takes care of everything , i just need to call proper function
    //service is middle
    public List<Film> getAllFilms(){
        return filmRepository.findAll();
    }
    /*
    //when you want to add a new film , you basically add 1 or more films, the least is 1 film but there is no limit
    //in java it's equivalent to something like this:
    // List<Film> films = {new Film("film1"), new Film("film2"), new Film("film3")}
    // it allows me to add multiple films by using the List
    // i can actually add another method we call it addFilm ; and it will add only 1 film per time and
    //will return that added film to filmRepository, and it will saveAll with that saveAll function - it will only call
    save instead of saveAll because i don't have a list

    public Film addFilm(Film film){
        return filmRepository.save(film);
    }
     */

    public List<Film> addFilms(List<Film> films){
        return filmRepository.saveAll(films);
    }
    public void deleteById(Long id){
        filmRepository.deleteById(id);
    }
    public Film updateFilm(Long id, Film film){
        if (filmRepository.existsById(id)){//make 2 test 1 for existById
            film.setFilm_id(id); //1 test for setFilm
            return filmRepository.save(film);
        }
        return null;
    }

}


