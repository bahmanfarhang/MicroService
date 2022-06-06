package com.tsiBahmanFarhang.MicroServiceProjectApplication;

import javax.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name="actor")

public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actor_id;
    String first_name;
    String last_name;

    //constructor
    public Actor(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;

    }

    public Actor() {
    }

    //setter
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    //getter
    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }
}
