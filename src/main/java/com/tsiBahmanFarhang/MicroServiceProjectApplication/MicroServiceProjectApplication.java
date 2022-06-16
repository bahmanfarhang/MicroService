package com.tsiBahmanFarhang.MicroServiceProjectApplication;

import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.ActorRepository;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroServiceProjectApplication {
//    @Autowired
//    private FilmRepository filmRepository;
//    @Autowired
//    private ActorRepository actorRepository;
//
//    public MicroServiceProjectApplication(FilmRepository filmRepository, ActorRepository actorRepository) {
//        this.filmRepository = filmRepository;
//        this.actorRepository = actorRepository;
//    }
//
//    public MicroServiceProjectApplication(FilmRepository filmRepository) {
//        this.filmRepository = filmRepository;
//    }
//
//    public MicroServiceProjectApplication(ActorRepository actorRepository) {
//        this.actorRepository = actorRepository;
//    }

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceProjectApplication.class, args);
    }

}
