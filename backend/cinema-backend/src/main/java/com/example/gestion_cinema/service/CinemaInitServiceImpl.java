package com.example.gestion_cinema.service;

import com.example.gestion_cinema.entity.*;
import com.example.gestion_cinema.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;


@Service
@Transactional
public class CinemaInitServiceImpl implements ICinemaInitService {

    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private SalleRepository salleRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private SeanceRepository seanceRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ProjectionRepository projectionRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Override
    public void initVilles() {
        Stream.of("Casablanca","Marrakech","Rabat","Tanger")
                .forEach(nameVille->{
                    Ville ville=new Ville();
                    ville.setName(nameVille);
                    villeRepository.save(ville);
                });
    }

    @Override
    public void initCinemas() {
        villeRepository.findAll().forEach(v->{
            Stream.of("MegaRama","IMAX","Founoun","Chahrazad","Daouliz")
                    .forEach(nameCinema->{
                        Cinema cinema=new Cinema();
                        cinema.setName(nameCinema);
                        cinema.setNombreSalles(3+(int)(Math.random()*7));
                        cinema.setVille(v);
                        cinemaRepository.save(cinema);
                    });
        });
    }

    @Override
    public void initSalles() {
        cinemaRepository.findAll().forEach(cinema->{
            for(int i=0;i<cinema.getNombreSalles();i++) {
                Salle salle=new Salle();
                salle.setName("salle "+(i+1));
                salle.setCinema(cinema);
                salle.setNombreplace(15+(int)(Math.random()*20));
                salleRepository.save(salle);
            }
        });
    }

    @Override
    public void initPlaces() {
        salleRepository.findAll().forEach(salle -> {
            for (int i=0;i<salle.getNombreplace();i++) {
                Place place=new Place();
                place.setNumber(i+1);
                place.setSalle(salle);
                placeRepository.save(place);
            }
        });
    }

    @Override
    public void initSeances() {
        DateFormat dateFormat=new SimpleDateFormat("HH:mm");
        Stream.of("12:00","15:00","17:00","19:00","21:00").forEach(s -> {
            Seance seance=new Seance();
            try {
                seance.setHeureDebut(dateFormat.parse(s));
                seanceRepository.save(seance);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void initCategories() {
        Stream.of("Histoire","Action","Fiction","Drama").forEach(cat->{
            Categorie categorie=new Categorie();
            categorie.setName(cat);
            //categoryRepository.save(categorie);
        });
    }

    @Override
    public void initFilms() {
        double[] durees=new double[] {1,1.5,2,2.5,3,3.5};
      //  List<Categorie> categories=categoryRepository.findAll();
        Stream.of("Game of thrones","titanic","harrypotter","greenbook","Seigneur des anneaux","Spider man","Iron man","Cat woman")
                .forEach(titreFilm->{
                    Film film=new Film();
                    film.setTitre(titreFilm);
                    film.setDurees(durees[new Random().nextInt(durees.length)]);
                    film.setPhoto(titreFilm.replaceAll(" ","")+".jpg");
         //           film.setCategorie(categories.get(new Random().nextInt(categories.size())));
                    filmRepository.save(film);
                });
    }

    @Override
    public void initProjections() {
        double[] prices=new double[] {30,50,60,70,90,100};
        villeRepository.findAll().forEach(ville -> {
            ville.getCinemas().forEach(cinema -> {
                cinema.getSalles().forEach(salle -> {
                    filmRepository.findAll().forEach(film -> {
                        seanceRepository.findAll().forEach(seance -> {
                            Projection projection=new Projection();
                            projection.setDateprojection(new Date());
                            projection.setFilm(film);
                            projection.setPrix(prices[new Random().nextInt(prices.length)]);
                            projection.setSalle(salle);
                            projection.setSeance(seance);
                            projectionRepository.save(projection);
                        });
                    });
                });
            });
        });
    }

    @Override
    public void initTickets() {
        projectionRepository.findAll().forEach(projection -> {
            projection.getSalle().getPlaces().forEach(place -> {
                Ticket ticket=new Ticket();
                ticket.setPlace(place);
                ticket.setPrix(projection.getPrix());
                ticket.setProjection(projection);
                ticket.setReserve(false);
                ticketRepository.save(ticket);
            });
        });
    }
}
