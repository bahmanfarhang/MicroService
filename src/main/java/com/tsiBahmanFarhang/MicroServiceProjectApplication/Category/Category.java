package com.tsiBahmanFarhang.MicroServiceProjectApplication.Category;


import javax.persistence.*;

//using @Entity to represent my table in the db - making a primary key
@Entity
@Table(name="category")
public class Category {

    public Category(Long category_id, String name){
        this.category_id = category_id;
        this.name = name;
    }
    public Category(){
    }
    //the @Id notation specifies the PK in an entity
    //the @GeneratedValue helps how to specify how the PK of the entity should be generated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //private variables
    private Long category_id;
    private String name;

    //setters
    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }
    public void setName(String name){
        this.name = name;
    }
    //getters
    public Long getCategory_id(){
        return category_id;
    }
    public String name(){
        return name;
    }

}
