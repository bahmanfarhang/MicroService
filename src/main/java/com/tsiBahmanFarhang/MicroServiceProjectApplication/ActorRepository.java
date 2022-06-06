package com.tsiBahmanFarhang.MicroServiceProjectApplication;

import javax.persistence.GeneratedValue;

public interface ActorRepository extends GeneratedValue {

    Iterable<Actor> findAll();
}
