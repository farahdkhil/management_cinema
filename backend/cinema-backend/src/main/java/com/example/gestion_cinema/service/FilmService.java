package com.example.gestion_cinema.service;

import com.example.gestion_cinema.entity.Film;
import com.example.gestion_cinema.entity.filmCategory;

import java.util.List;

public interface FilmService {
    Film add(Film film);
    List<Film> findAll();
    List<Film> SearchByName(String name);
    Film save(Film film);
    void delete(Long id);
    Film findById(Long id);
    List<Film> findByIdCategory(filmCategory id);
}
