package com.example.gestion_cinema.service;

import com.example.gestion_cinema.entity.filmCategory;

import java.util.List;

public interface CategoryService {
    filmCategory add(filmCategory category);
    List<filmCategory> findAll();
    filmCategory save(filmCategory category);
    void delete(Long id);
}
