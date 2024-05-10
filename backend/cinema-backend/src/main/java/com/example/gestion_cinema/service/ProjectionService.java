package com.example.gestion_cinema.service;

import com.example.gestion_cinema.entity.Film;
import com.example.gestion_cinema.entity.Projection;

import java.util.List;

public interface ProjectionService {

    Projection add(Projection projection);

    List<Projection> findAll();

    Projection save(Projection projection);

    void delete(Long id);

    List<Projection> findByIdFilm( Film id);



}