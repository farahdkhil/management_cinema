package com.example.gestion_cinema.repository;

import com.example.gestion_cinema.entity.Film;
import com.example.gestion_cinema.entity.Projection;
import com.example.gestion_cinema.entity.Salle;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Repository
@CrossOrigin("*")
public interface ProjectionRepository extends JpaRepository<Projection, Long> {
    @Query("select p from Projection p where p.dateprojection= :date and p.salle= :salle")
    Projection findProjection(Date date, Salle salle);

    @Query("select s.nombreplace from Salle s where s.id = :id  ")
    int nbPlaces(Long id);

    @Query("select p from Projection p where p.film = :id ")
    List<Projection> findByIdFilm(Film id);
}
