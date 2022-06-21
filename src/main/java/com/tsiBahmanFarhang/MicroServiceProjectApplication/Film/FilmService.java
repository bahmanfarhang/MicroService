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

@Service
public class FilmService {

    //@Autowired helps with the injection of dependency
    @Autowired
    FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }

    //methods
    public List<Film> getAllFilms(){
        return filmRepository.findAll();
    }
    public List<Film> addFilms(List<Film> films){
        return filmRepository.saveAll(films);
    }
    public void deleteById(Long id){
        filmRepository.deleteById(id);
    }
    public Film updateFilm(Long id, Film film){
        if (filmRepository.existsById(id)){
            film.setFilm_id(id);
            return filmRepository.save(film);
        }
        return null;
    }

}


