package com.example.gestion_cinema.service;

import com.example.gestion_cinema.entity.Salle;

import java.util.List;

public interface SalleService {
    Salle add(Salle salle);
    List<Salle> findAll();
    Salle save(Salle salle);
    Salle findById(Long id);
    void delete(Long id);
}
