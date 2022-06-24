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
        Actor actor = new Actor(1L, "tom", "doe");
        List<Actor> actorList = new ArrayList<Actor>();
        actorList.add(actor);

        //this is mocking, instead of running the actor, im saying if this function is called "actor repo" then return actor list
        //its just returning the actorList when the actorRepo is called using the findAll method
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

        Actor actor = new Actor(1L, "jon", "collin");
        List<Actor> actorList = new ArrayList<Actor>();
        actorList.add(actor);

        //whenever this function is called then i should filmList, it will NOT RUN IT, but
        //return it auto
        //im mocking saveAll and testing
        when(actorRepository.saveAll(actorList)).thenReturn(actorList);

        List<Actor> expected = actorList;
        List<Actor> actual = actorService.addActors(actorList);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void updateTestNoId(){
        //testing no id therefore return false
        when(actorRepository.existsById(1L)).thenReturn(false);
        //updated actor for the actual
        Actor actual = actorService.updateActor(1L, new Actor());
        //i expect nothing and my actual is the actual updated actor above
        Assertions.assertEquals(null, actual);
    }
    @Test
    public void updateTestId(){//100% coverage was achieved because it was a decision coverage and both was covered
        //mock object
        Actor actor = new Actor(1L, "jenny", "kings");
        //return true if existById methods returns the id from the repo
        when(actorRepository.existsById(1L)).thenReturn(true);
        //same thing but for save, it saves it and then returns
        when(actorRepository.save(actor)).thenReturn(actor);
        Actor actual = actorService.updateActor(1L, actor);
        //at the end im checking if the actor is actually updated and saved to what i actually wanted, hence
        //expected is the actor above and the actual is the actual updated 1
        Assertions.assertEquals(actor, actual);
    }
}
