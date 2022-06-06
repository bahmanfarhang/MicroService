package com.tsiBahmanFarhang.MicroServiceProjectApplication;

import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository {

    Iterable<Actor> findAll();
}
