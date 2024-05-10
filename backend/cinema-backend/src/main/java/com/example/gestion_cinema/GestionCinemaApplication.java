package com.example.gestion_cinema;

import com.example.gestion_cinema.entity.*;
import com.example.gestion_cinema.service.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
//public class GestionCinemaApplication implements CommandLineRunner {
public class GestionCinemaApplication  {
    @Autowired
    private ICinemaInitService iCinemaInitService;

    //private RepositoryRestConfiguration restConfiguration;


    public static void main(String[] args) {

        SpringApplication.run(GestionCinemaApplication.class, args);
    }
    //@Override
    //public void run(String... args) throws Exception {

       // restConfiguration.exposeIdsFor(Categorie.class);


       // iCinemaInitService.initFilms();

    //}

}
