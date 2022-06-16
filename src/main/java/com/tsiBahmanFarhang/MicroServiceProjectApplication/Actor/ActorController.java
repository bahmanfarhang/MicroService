package com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor;
//class for handling all the API
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.Film;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/*
* REST stands for representational state transfer
* the @RestController is used at a class level, and it allows the class to make requests by a client
* therefore it allows me to use REST API such as Get, Post, Delete, Put
* API stands for Application Programming Interface
* */

/*
* the @RequestMapping is important as it used to map HTTP requests to handler methods of MVC and REST controller, and I
* named it "api/v1 which I will use in postman"
* */

@RestController
@RequestMapping("api/v1/actor")
public class ActorController {
    @Autowired
    ActorService actorService;

    @GetMapping(value = "/allActors")
     public Iterable<Actor> getAllActors(){
        return actorService.getAllActors();
    }

    @PostMapping(value = "/addActor")
    public List<Actor> addActors(@RequestBody List<Actor> actors){
       return actorService.addActors(actors);
    }

    @DeleteMapping(value = "/deleteActor{id}")
    public void deleteByActorId(@PathVariable("id") Long id) {
        actorService.deleteById(id);
    }

    @PutMapping(value = "/updateActor/{id}")
    public Actor updateActor(@RequestBody Actor actor,@PathVariable("id") Long id){
        return actorService.updateActor(id,actor);
    }
}
