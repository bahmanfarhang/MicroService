package com.tsiBahmanFarhang.MicroServiceProjectApplication.Film;
import javax.persistence.*;
import java.time.LocalDate;
/*
* the entity helps me to set up my table and give a primary key for the film in the db and use the @Id annotation
* and, it specifies primary key for this entity "flm"
* the @table annotation helps with tabular form
* the @GeneratedValue helps to specify how the primary key should be generated
* */

@Entity
@Table(name = "film")

public class Film {
    @Id
    /*
    * IDENTITY indicates that the persistence provider must assign primary key for entity using db identity column
    * persistence provider refers to the implementation of the Java Persistence API (Application Programming Interface)
    */
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //private variables for my field class - private = visible in Film class scope only, security
    private Long film_id;
    private String title;
    private String description;
    private Double rental_rate;
    //setter
    public void setFilm_id(Long film_id){
        this.film_id = film_id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setRental_rate(Double rental_rate){
        this.rental_rate = rental_rate;
    }

    //getter
    public Long getFilm_id(){
        return film_id;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public Double getRental_rate(){
        return rental_rate;
    }
}
