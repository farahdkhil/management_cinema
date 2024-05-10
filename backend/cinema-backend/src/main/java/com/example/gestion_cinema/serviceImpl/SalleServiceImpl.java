package com.example.gestion_cinema.serviceImpl;

import com.example.gestion_cinema.entity.Salle;
import com.example.gestion_cinema.exceptions.EntityNotFoundException;
import com.example.gestion_cinema.exceptions.InvalidEntityException;
import com.example.gestion_cinema.repository.SalleRepository;
import com.example.gestion_cinema.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleServiceImpl implements SalleService {
    @Autowired
    private SalleRepository salleRepo;


    @Override
    public Salle add(Salle salle) {
        return salleRepo.save(salle);
    }

    @Override
    public List<Salle> findAll() {
        return salleRepo.findAll();
    }

    @Override
    public Salle save(Salle salle) {
        if(salle.getName() == null ){
            throw new InvalidEntityException("Nom salle invalide");
        }
        if(salle.getNombreplace() == 0 ){
            throw new InvalidEntityException("Nombre de place invalide");
        }
        Salle s = salleRepo.getByName(salle.getName());
        if(s != null){
            throw new InvalidEntityException("salle existe déja !");
        }
        return salleRepo.save(salle);
    }

    @Override
    public   Salle findById(Long id) {

        return salleRepo.findById(id).orElseThrow(()-> new EntityNotFoundException(" salle n'existe pas"));
    }

    @Override
    public void delete(Long id) {
        salleRepo.deleteById(id);
    }
}
