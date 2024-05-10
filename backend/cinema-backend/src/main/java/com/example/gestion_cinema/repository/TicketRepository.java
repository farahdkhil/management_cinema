package com.example.gestion_cinema.repository;

import com.example.gestion_cinema.entity.Ticket;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin("*")
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("UPDATE Projection p SET p.salle.nombreplace = :nouvellesPlacesDispo WHERE p.id = :id")
    void updateNbPlace(@Param("nouvellesPlacesDispo") int nouvellesPlacesDispo, @Param("id") Long id);

    @Query("select r from Ticket r where r.user.id = :id")
    List<Ticket> findByUserId(Long id);
}
