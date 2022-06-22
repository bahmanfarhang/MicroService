package com.tsiBahmanFarhang.MicroServiceProjectApplication.FilmTest;

import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.Actor;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.Film;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.FilmController;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.FilmRepository;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.FilmService;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.MicroServiceProjectApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

    @ExtendWith(MockitoExtension.class)
    public class FilmControllerMockitoTest {

        private MicroServiceProjectApplication microServiceProjectApplication;

        //make a fake repo
        @MockBean
        FilmRepository filmRepository;
        @InjectMocks
        FilmController filmController;

        @BeforeEach
        void setUp(){
            filmRepository = mock(FilmRepository.class);
            ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
            microServiceProjectApplication = new MicroServiceProjectApplication();
        }
        @Test
        public void getAllFilmTest(){
//            //first created a mock object which is a film
//            Film film = new Film(1L, "A film about Mockito", "You must watch this film", 2.4);
//            //because its a List, i can add multiple films
//            List<Film> filmList = new ArrayList<Film>();
//            filmList.add(film);
//
//            //i will be mocking each method
//            //whenever this function is called then i should filmList, it will NOT RUN IT, but
//            //return it automatically
//            when(filmRepository.findAll()).thenReturn(filmList);
//
//            Iterable<Film> expected = filmList;
//            //as we have mocked the findAll function the service will return that only(mock data)
//            Iterable<Film> actual = filmController.getAllFilms();
//            //
//            Assertions.assertEquals(expected, actual);
        }
        @Test
        public void deleteFilmTest(){

        }
        @Test
        public void addFilmTest(){

        }
        @Test
        public void updateFilmTest(){
//            Film updateAFilmTest = new Film(2L,"GodFather 2", "wow film", 5.9);//a fake movie
//            updateAFilmTest.setFilm_id(2L);
//            when(filmRepository.findById(updateAFilmTest.getFilm_id())).thenReturn(Optional.of(updateAFilmTest));
//            when(filmRepository.save(updateAFilmTest)).thenReturn(updateAFilmTest);
//
//            String expected = null;
//            //Film actual = filmController.updateFilm(updateAFilmTest.setFilm_id());

        }

    }
