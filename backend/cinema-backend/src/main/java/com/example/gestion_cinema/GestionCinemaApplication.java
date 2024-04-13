package com.example.gestion_cinema;

import com.example.gestion_cinema.entity.*;
import com.example.gestion_cinema.service.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class GestionCinemaApplication implements CommandLineRunner {
    @Autowired
    private ICinemaInitService iCinemaInitService;

    private RepositoryRestConfiguration restConfiguration;


    public static void main(String[] args) {

        SpringApplication.run(GestionCinemaApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {

        restConfiguration.exposeIdsFor(Categorie.class);
        restConfiguration.exposeIdsFor(Cinema.class);
        restConfiguration.exposeIdsFor(Ticket.class);
        restConfiguration.exposeIdsFor(Film.class);
        restConfiguration.exposeIdsFor(Ville.class);
        restConfiguration.exposeIdsFor(Place.class);
        restConfiguration.exposeIdsFor(Projection.class);
        restConfiguration.exposeIdsFor(Salle.class);
        restConfiguration.exposeIdsFor(Seance.class);

        iCinemaInitService.initFilms();
        iCinemaInitService.initCategories();
        iCinemaInitService.initCinemas();
        iCinemaInitService.initPlaces();
        iCinemaInitService.initSalles();
        iCinemaInitService.initVilles();
        iCinemaInitService.initProjections();
        iCinemaInitService.initTickets();
    }

}
