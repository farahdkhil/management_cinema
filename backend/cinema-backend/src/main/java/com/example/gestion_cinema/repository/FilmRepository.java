package com.example.gestion_cinema.repository;

import com.example.gestion_cinema.entity.Film;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
@Repository
@CrossOrigin("*")
public interface FilmRepository extends JpaRepository<Film, Long> {
}
