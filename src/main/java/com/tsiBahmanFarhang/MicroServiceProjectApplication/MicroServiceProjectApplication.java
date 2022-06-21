package com.tsiBahmanFarhang.MicroServiceProjectApplication;

import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.ActorRepository;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroServiceProjectApplication {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ActorRepository actorRepository;

    public MicroServiceProjectApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceProjectApplication.class, args);
    }

}
