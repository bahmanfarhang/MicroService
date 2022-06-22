package com.tsiBahmanFarhang.MicroServiceProjectApplication.Film;

import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/*
* MVC architecture; 3 tier layer - user interface tier, application tier, data tier
* in the controller class i have public methods to handle requests from users, in postman to display results and test if it works
* essentially validates the data, or gets an error message, 404...
* */
@RestController
//the first thing it looks at is the controller if the url is declared in code
@RequestMapping("api/v1/film/")

@CrossOrigin
public class FilmController {

    //the @Autowired in filmController is the filmService
    @Autowired
    FilmService filmService;

    //Controller for films
    //using iterables here to make enhance the iteration, they are interface - why implement iterator/iterable interface?
    //this will help me get the items 1 by 1
    @GetMapping(value = "/allFilms") //use List or iterable
    public Iterable<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

    @PostMapping(value = "/addFilm")
    public List<Film> addFilms(@RequestBody List<Film> films) {
        return filmService.addFilms(films);
    }

    @DeleteMapping(value = "/deleteFilm{id}")
    public void deleteByFilmId(@PathVariable("id") Long id) {
        filmService.deleteById(id);
    }

    @PutMapping(value = "updateFilm/{id}")
    public Film updateFilm(@RequestBody Film film, @PathVariable("id") Long id) {
        return filmService.updateFilm(id, film);
    }
}
