package com.example.gestion_cinema.serviceImpl;

import com.example.gestion_cinema.entity.Ticket;
import com.example.gestion_cinema.exceptions.InvalidEntityException;
import com.example.gestion_cinema.repository.TicketRepository;
import com.example.gestion_cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository reservationRepo;

    @Override
    public Ticket add(Ticket reservation) {
        return reservationRepo.save(reservation);
    }

    @Override
    public List<Ticket> findAll() {
        return reservationRepo.findAll();
    }

   @Override
   public List<Ticket> findByUserId(Long id) {
      return reservationRepo.findByUserId(id);
   }
    @Override
    public Ticket save(Ticket reservation) {
        if(reservation.getPlace().getNumber() == 0 ){
            throw new InvalidEntityException("Nombre de place invalide");
        }
        if(reservation.getProjection() == null ){
            throw new InvalidEntityException("Projection de film invalide");
        }
        if(reservation.getNomclient()== null ){
            throw new InvalidEntityException("Utilisateur invalide");
        }

        int  plcesDispo = reservation.getProjection().getSalle().getNombreplace();
        int  placesReserve = reservation.getProjection().getSalle().getNombreplace();
        int nouvellesPlacesDispo = plcesDispo - placesReserve;

        if(plcesDispo < placesReserve){
            throw new InvalidEntityException("nombre de place invalid !");
        }

        Long projectionId = reservation.getProjection().getId();

        reservationRepo.updateNbPlace(nouvellesPlacesDispo, projectionId);

        return reservationRepo.save(reservation)  ;
    }

    @Override
    public void delete(Long id) {
        reservationRepo.deleteById(id);
    }
}