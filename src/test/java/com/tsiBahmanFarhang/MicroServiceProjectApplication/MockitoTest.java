package com.tsiBahmanFarhang.MicroServiceProjectApplication;

import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.Actor;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.ActorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//import static org.mockito.Mockito.verify;
///*
//* so i need to test to see if all my functionality is working or not
//* im using a 3 layer architecture - controller(actorController), service(ActorService), repository(ActorRepository)
////* */
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
//public class MockitoTest {
//
//    //@Autowired helps me to inject dependency
//    //these are my private variable, private so its in the scope of this class ONLY
//    private MicroServiceProjectApplication microServiceProjectApplication;
//    @Mock
//    private ActorRepository actorRepository;
//    private Actor actor;
//
//    @BeforeEach
//    void setUp(){
//        //constructor
//        microServiceProjectApplication = new MicroServiceProjectApplication(actorRepository, actor);
//    }
//
//    @Test
//    public void getAllActors(){
//        microServiceProjectApplication.getAllActors();
//        verify(actorRepository).findAll();
//    }
//    @Test
//    public void testAddActors(){
//        Actor savedActor = new Actor();
//        String expected = "Saved";
//        String Actual = microServiceProjectApplication.addActor(savedActor.getActor_id(),savedActor.getFirst_name(),savedActor.getLast_name());
//        ArgumentCaptor<Actor> cocktailArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
//        verify(actorRepository).save(cocktailArgumentCaptor.capture());
//        cocktailArgumentCaptor.getValue();
//        Assertions.assertEquals(expected,Actual,"Cocktail is not saved into the database");
//    }

//}

