package com.tsiBahmanFarhang.MicroServiceProjectApplication.Language;

import javax.persistence.*;

@Entity
@Table(name="language")
public class Language {

    @Id
    /*
     * IDENTITY indicates that the persistence provider must assign primary key for entity using db identity column
     * persistence provider refers to the implementation of the Java Persistence API (Application Programming Interface)
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //private variables for my field class - private = visible in Film class scope only, security
    private Long language_id;
    private String name;

    //setter
    public void setLanguage_id(Long language_id){
        this.language_id = language_id;
    }
    public void setName(String name){
        this.name = name;
    }


    //getter
    public Long getLanguage_id(){
        return language_id;
    }
    public String getName(){
        return name;
    }

}
