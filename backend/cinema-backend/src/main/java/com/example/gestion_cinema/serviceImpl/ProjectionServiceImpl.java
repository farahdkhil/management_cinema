package com.example.gestion_cinema.serviceImpl;

import com.example.gestion_cinema.entity.Film;
import com.example.gestion_cinema.entity.Projection;
import com.example.gestion_cinema.exceptions.InvalidEntityException;
import com.example.gestion_cinema.repository.ProjectionRepository;
import com.example.gestion_cinema.service.ProjectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectionServiceImpl implements ProjectionService {

    @Autowired
    private ProjectionRepository projectionRepo;


    @Override
    public Projection add(Projection projection) {
        return projectionRepo.save(projection);
    }

    @Override
    public List<Projection> findAll() {
        return projectionRepo.findAll();
    }

    @Override
    public List<Projection> findByIdFilm(Film id) {
        return projectionRepo.findByIdFilm(id);
    }

    @Override
    public Projection save(Projection projection) {
        if(projection.getDateprojection() == null ){
            throw new InvalidEntityException("Date de projection invalide");
        }
        if(projection.getFilm() == null ){
            throw new InvalidEntityException("Film invalide");
        }
        if(projection.getSalle() == null ){
            throw new InvalidEntityException("Salle invalide");
        }
       // projection.setSalle(projectionRepo.nbPlaces(projection.getSalle().getId()));
        Projection p = projectionRepo.findProjection(projection.getDateprojection(),projection.getSalle());
        if(p != null){
            throw new InvalidEntityException("projection existe déja !");
        }

        return projectionRepo.save(projection);
    }

    @Override
    public void delete(Long id) {
        projectionRepo.deleteById(id);
    }
}