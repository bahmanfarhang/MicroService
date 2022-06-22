package com.tsiBahmanFarhang.MicroServiceProjectApplication.ActorTest;

import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.Actor;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.ActorRepository;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.ActorService;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.Film;
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

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ActorServiceMockitoTest {

    private MicroServiceProjectApplication microServiceProjectApplication;

    //injecting the service to test its methods
    @InjectMocks
    ActorService actorService;
    //making a mock object of actorrepo
    @MockBean
    ActorRepository actorRepository;
    //before each test run i want to run this
    @BeforeEach
    void setUp(){
        //,mock class has no functions
        actorRepository = mock(ActorRepository.class);
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        //made an object with the parameter actorRepo
        actorService = new ActorService(actorRepository);
    }
    @Test
    public void getAllActorsTest (){
        //first created a mock object which is a film
        Actor actor = new Actor();
        List<Actor> actorList = new ArrayList<Actor>();
        actorList.add(actor);

        when(actorRepository.findAll()).thenReturn(actorList);

        List<Actor> expected = actorList;
        //as we have mocked the findAll function the service will return that only(mock data)
        List<Actor> actual = actorService.getAllActors();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void deleteActorTest(){

        actorService.deleteById(1L);
        verify(actorRepository,times(1)).deleteById(1L);
    }
    @Test
    public void addActorTest(){

        Actor actor = new Actor();
        List<Actor> actorList = new ArrayList<Actor>();
        actorList.add(actor);

        //whenever this function is called then wwe should filmList, it will NOT RUN IT, but
        //return it auto
        //im mocking saveAll and testing
        when(actorRepository.saveAll(actorList)).thenReturn(actorList);

        List<Actor> expected = actorList;
        List<Actor> actual = actorService.addActors(actorList);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void updateTestNoId(){
        when(actorRepository.existsById(1L)).thenReturn(false);
        Actor actual = actorService.updateActor(1L, new Actor());
        Assertions.assertEquals(null, actual);
    }
    @Test
    public void updateTestId(){
        Actor actor = new Actor();
        when(actorRepository.existsById(1L)).thenReturn(true);
        when(actorRepository.save(actor)).thenReturn(actor);
        Actor actual = actorService.updateActor(1L, actor);
        Assertions.assertEquals(actor, actual);
    }
}
