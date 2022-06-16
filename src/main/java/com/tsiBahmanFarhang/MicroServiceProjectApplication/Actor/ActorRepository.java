package com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor;

import com.tsiBahmanFarhang.MicroServiceProjectApplication.Actor.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

/*
* Spring boot is a microservice-based framework, and it is build on top of spring and uses all its features
*
* Crud stand for create, red, update, delete, so CrudRepository is a spring data interface for generic crud operations
* therefore, by using this interface, I can operate the crud on my actors
*
* using Jpa to manage data
* Jpa stands for Java Persistence API, containing the full API CrudRepository and PagingAndSortingRepository
*
* the extends shows that a class it inherited (inheritance) from another class, which is a OOP concept
* in the case below, "ActorRepository" interface extends (inherits[inheritance]) from "JaRepository" interface
* which makes sense because we need the methods of "JpaRepository"
* since my ActorRepository is an interface, it means that it is an abstract type which is a superclass that does NOT
* allow instantiation - (creation of an object from that particular class)
* */

public interface ActorRepository extends JpaRepository<Actor, Long> {
}