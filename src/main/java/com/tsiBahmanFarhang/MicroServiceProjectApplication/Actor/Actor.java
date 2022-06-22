package com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor;
import javax.persistence.*;
/*
* im using @Entity to represent my table in the db - making a primary key
* this is an entity class, and it must follow some rules
* using the @table class below to display data in tabular form and the name of my table is "actor"
* important to know that the use of annotations is to help us to prevent using XML configuration - config method
*/
@Entity
@Table(name="actor")

//actor class with private variables with setters and getters

//this class is a model
public class Actor {
    public Actor(Long actor_id, String first_name, String last_name){
        this.actor_id = actor_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }
    public Actor(){
    }
    /*
     * @Id specifies the primary key of an entity - so my primary key in the db is now actor_id, first_name, last_name
     * @GeneratedValue must be applied in conduction with @Id
     * @GeneratedValue is used to specify how the primary key should be generated
     * and the "strategy = GenerationType.IDENTITY" helps to generate automatic primary key for the entity
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //why use Long? and not int
    private Long actor_id;
    private String first_name;
    private String last_name;
    // just to clarify , a front end app is an app consists of html , css and javascript code only. , you said that java project have
    //that , can you show me the repository

    //setter
    public void setActor_id(Long actor_id) {
        this.actor_id = actor_id;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    //getter
    public Long getActor_id() {
        return actor_id;
    }
    public String getFirst_name() {
        return first_name;
    }
    public String getLast_name() {
        return last_name;
    }
}
