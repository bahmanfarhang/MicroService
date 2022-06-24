package com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor;

import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/*
* using the @Service to make this class a service provider - calling an external API (Application Programming Interface)
* API - software intermediary that allows two applications to talk to each other - in this case, my "AutoService" is the
* intermediary for communication between other components
*/
@Service
public class ActorService {
    //Autowired helps me with the injection of dependency
    @Autowired
    ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public ActorService(){
    }
    /*
    * methods
    * using java List from generics for "Actor" so I can maintain the ordered collection
    * using java Lists will help to insert, update, delete, search as it has insert-based method
    */
    public List<Actor> getAllActors(){
        return actorRepository.findAll();
    }
    //java List can also allow me to store null elements
    public List<Actor> addActors(List<Actor> actors) {
        return actorRepository.saveAll(actors);
    }
    public void deleteById(Long id) {
        actorRepository.deleteById(id);
    }
    public Actor updateActor(Long id, Actor actor) {
        if(actorRepository.existsById(id)){ //must do 2 tests, 2 functions to get full coverage
            actor.setActor_id(id);
           return actorRepository.save(actor);
        }
        return null;
    }
}
