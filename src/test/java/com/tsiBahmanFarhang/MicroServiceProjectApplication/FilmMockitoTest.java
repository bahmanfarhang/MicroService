package com.tsiBahmanFarhang.MicroServiceProjectApplication;


import com.beust.ah.A;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.Actor;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.Film;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.FilmController;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.FilmRepository;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.FilmService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FilmMockitoTest {

    private MicroServiceProjectApplication microServiceProjectApplication;

    //make a fake repo
    @MockBean
    FilmRepository filmRepository;
    FilmController filmController;
    @InjectMocks
    FilmService filmService;

    @BeforeEach
    void setUp(){
        filmRepository = mock(FilmRepository.class);
        //filmService = mock(FilmService.class);
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        microServiceProjectApplication = new MicroServiceProjectApplication();
        filmController = new FilmController();

        filmService = new FilmService(filmRepository);
    }
    @Test
    public void getAllFilmTest(){
        //create list of movies
        List<Film> filmList = new ArrayList<Film>();//new array list of movies
        Film film1 = new Film(1L,"GodFather", "good film", 4.9);//a fake movie
        filmList.add(film1);//adding the movie


        Iterable<Film> filmIterable = filmList;

        when(filmService.getAllFilms()).thenReturn((List<Film>) filmIterable);

        Iterable<Film> expected = filmIterable;
        Iterable<Film> actual = filmService.getAllFilms();

        System.out.println(filmController.getAllFilms().iterator().next().getFilm_id());

        //actual test
        Assertions.assertEquals(expected, actual, "not same");





    }
    @Test
    public void deleteFilmTest(){

    }
    @Test
    public void addFilmTest(){

    }
    @Test
    public void updateFilmTest(){

    }


}
