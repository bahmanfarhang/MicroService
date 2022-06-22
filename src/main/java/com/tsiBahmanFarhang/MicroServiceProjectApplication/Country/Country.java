package com.tsiBahmanFarhang.MicroServiceProjectApplication.Country;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {

    public Country(Long country_id, String country){
        this.country_id = country_id;
        this.country = country;
    }
    public Country(){
    }
    @Id
    /*
     * IDENTITY indicates that the persistence provider must assign primary key for entity using db identity column
     * persistence provider refers to the implementation of the Java Persistence API (Application Programming Interface)
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //private variables for my field class - private = visible in Film class scope only, security
    private Long country_id;
    private String country;

    //setter
    public void setCountry_id(Long country_id){
        this.country_id = country_id;
    }
    public void setCountry(String country){
        this.country = country;
    }

    //getter
    public Long getCountry_id_id(){
        return country_id;
    }
    public String getCountry(){
        return country;
    }
}
