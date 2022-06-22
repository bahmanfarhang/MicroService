package com.tsiBahmanFarhang.MicroServiceProjectApplication.FilmTest;

import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.Actor;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.Film;
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
/*
importing mockito framework for mocking in unit testing (component testing)
equally important it is wise to note that the normal unit testing is NOT enough when a 'microservice' like architecture
is involved, the actual logic of the methods therefore must be under test

while doing unit test case i can use one of the 'test doubles' - dummy object, fake object, a stub class and
mock object (i did)
 */
import static org.mockito.Mockito.*;
/*
* @When, @verify, @times
* */

//or i can use @RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class FilmServiceMockitoTest {

    private MicroServiceProjectApplication microServiceProjectApplication;
    /*
    if i use the @InjectMocks annotation with the FilmService and whatever mock objects are in FilmRepository,
    then in run time it will be expected that FilmService has dependency about the FilmRepository inside this
    FilmServiceMockitoTest class therefore i have the @Mock instance of the class FilmRepository which will be automatically
    added to FilmService
    injecting the service as i will write the test for the service and inside this mocktoTest i have the filmRepository
    * */
    @InjectMocks
    FilmService filmService;
    //make a fake repo
    @MockBean
    FilmRepository filmRepository;
    @BeforeEach
    void setUp(){
        //,mock class has no functions
        filmRepository = mock(FilmRepository.class);
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        filmService = new FilmService(filmRepository);
    }
    @Test
    public void getAllFilmTest(){
        //first created a mock object which is a film
        Film film = new Film(1L, "A film about Mockito", "You must watch this film", 2.4);
        List<Film> filmList = new ArrayList<Film>();
        filmList.add(film);

        //whenever this function is called then we should filmList, it will NOT RUN IT, but
        //return it automatically
        when(filmRepository.findAll()).thenReturn(filmList);

        Iterable<Film> expected = filmList;
        //as we have mocked the findAll function the service will return that only(mock data)
        Iterable<Film> actual = filmService.getAllFilms();
        //
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void deleteFilmTest(){
        //whenever filmService deleteById is called, then verify will ensure the filmRepo
        //the deleteById function is called 1 time only
        filmService.deleteById(1L);
        //Allows verifying that certain behavior or action happened at least once
        //exact number of times or never. E.g:
        // verify(mock, times(5)).someMethod("was called five times");
        verify(filmRepository,times(1)).deleteById(1L);
    }
    @Test
    public void addFilmTest(){

        Film film = new Film(1L, "film", "lol", 3.4);
        List<Film> filmList = new ArrayList<Film>();
        filmList.add(film);

        //whenever this function is called then wwe should filmList, it will NOT RUN IT, but
        //return it auto
        //im mocking saveAll and testing
        when(filmRepository.saveAll(filmList)).thenReturn(filmList);

        Iterable<Film> expected = filmList;
        //as we have mocked the findAll function the service will return that only(mock data)
        Iterable<Film> actual = filmService.addFilms(filmList);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void updateTestNoId(){
        when(filmRepository.existsById(1L)).thenReturn(false);
        Film actual = filmService.updateFilm(1L, new Film());
        Assertions.assertEquals(null, actual);
    }
    @Test
    public void updateTestId(){
        Film film = new Film(1L, "film", "lol", 3.4);
        when(filmRepository.existsById(1L)).thenReturn(true);
        when(filmRepository.save(film)).thenReturn(film);
        Film actual = filmService.updateFilm(1L, film);
        Assertions.assertEquals(film, actual);
    }
}
