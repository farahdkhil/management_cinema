package com.example.gestion_cinema.serviceImpl;

import com.example.gestion_cinema.entity.Film;
import com.example.gestion_cinema.entity.filmCategory;
import com.example.gestion_cinema.exceptions.EntityNotFoundException;
import com.example.gestion_cinema.exceptions.InvalidEntityException;
import com.example.gestion_cinema.repository.FilmRepository;
import com.example.gestion_cinema.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository filmRepo;


    @Override
    public Film add(Film film) {
        return filmRepo.save(film);
    }

    @Override
    public List<Film> findAll() {
        return filmRepo.findAll();
    }

    @Override
    public List<Film> findByIdCategory(filmCategory id) {
        return filmRepo.findByIdCategory(id);
    }

    @Override
    public Film save(Film film) {
        if(film.getTitre() == null ){
            throw new InvalidEntityException("Nom film invalide");
        }
        if(film.getRealisateur() == null ){
            throw new InvalidEntityException("Réalisateur du film invalide");
        }
        if(film.getDecription() == null ){
            throw new InvalidEntityException("Description du film invalide");
        }
        if(film.getDateSortie() == null ){
            throw new InvalidEntityException("Date de création  du film invalide");
        }
        if(film.getDurees() == 0 ){
            throw new InvalidEntityException("Durée du film invalide");
        }
        if(film.getPhoto() == null ){
            throw new InvalidEntityException("Image du film invalide");
        }
        if(film.getProjections() == null ){
            throw new InvalidEntityException("Projection du film invalide");
        }
        //if(film.getprix() == null ){
          //  throw new InvalidEntityException("Prix du billet de film invalide");
        //}
        if(film.getCategorie() == null ){
            throw new InvalidEntityException("Catégorie de film  invalide");
        }

        Film f = filmRepo.getByName(film.getTitre());
        if(f != null){
            throw new InvalidEntityException("Film existe déja !");
        }
        return filmRepo.save(film);
    }

    @Override
    public void delete(Long id) {
        filmRepo.deleteById(id);
    }

    @Override
    public Film findById(Long id) {

        return filmRepo.findById(id).orElseThrow(()-> new EntityNotFoundException(" Film n'existe pas"));
    }
    @Override
    public List<Film> SearchByName(String name) {

        return filmRepo.searchByName(name);
    }
}
