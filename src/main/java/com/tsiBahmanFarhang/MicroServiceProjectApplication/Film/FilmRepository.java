package com.tsiBahmanFarhang.MicroServiceProjectApplication.Film;
import com.tsiBahmanFarhang.MicroServiceProjectApplication.Film.Film;
import org.springframework.data.jpa.repository.JpaRepository;

/*
* the FilmRepository is an interface (which is an abstract type (which a superclass that cannot be instantiated))
* the FilmRepository *extends* (inherits[inheritance]) the methods from JpaRepository
*
* using data from mySQL (data tier)
*
* the filmRepository will be mocked
*
* */
public interface FilmRepository extends JpaRepository<Film, Long> {
}
