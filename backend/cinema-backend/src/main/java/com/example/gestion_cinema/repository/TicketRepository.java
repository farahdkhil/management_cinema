package com.example.gestion_cinema.repository;

import com.example.gestion_cinema.entity.Ticket;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
@Repository
@CrossOrigin("*")
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
