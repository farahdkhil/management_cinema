package com.example.gestion_cinema.controller;

import com.example.gestion_cinema.entity.Film;
import com.example.gestion_cinema.entity.filmCategory;
import com.example.gestion_cinema.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/find-all")
    public List<Film> findAll() {
        return filmService.findAll();
    }
    @GetMapping("/find-by-id/{id}")
    public Film findById (@PathVariable Long id){
        return filmService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        filmService.delete(id);
    }

    @PostMapping("/add")
    public Film save(@RequestBody Film film){
        return filmService.save(film);
    }

    @GetMapping("/find-by-category/{id}")
    public List<Film> findByIdCategory(filmCategory id) {
        return filmService.findByIdCategory(id);
    }
    @GetMapping("/search-by-name/{name}")
    public List<Film> searchByName(@PathVariable String name) {
        return filmService.SearchByName(name);
    }


}
