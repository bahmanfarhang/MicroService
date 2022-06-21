package com.tsiBahmanFarhang.MicroServiceProjectApplication.Film;

import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/film")

@CrossOrigin

public class FilmController {


    @Autowired
    FilmService filmService;

    //Controller for films
    @GetMapping(value = "/allFilms")
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
