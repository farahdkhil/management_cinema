package com.example.gestion_cinema.repository;

import com.example.gestion_cinema.entity.Film;
import com.example.gestion_cinema.entity.filmCategory;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin("*")
public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query("select f from Film f ")
    List<Film> findAllFilms();

    @Query("select f from Film f where f.titre like %:name%")
    Film getByName(String name);

    @Query("select f from Film f where f.categorie= :id ")
    List<Film> findByIdCategory(filmCategory id);

    @Query("select f from Film f where f.titre like %:name%")
    List<Film> searchByName(String name);
}
