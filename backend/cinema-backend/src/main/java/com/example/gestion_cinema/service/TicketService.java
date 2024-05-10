package com.example.gestion_cinema.service;

import com.example.gestion_cinema.entity.Ticket;

import java.util.List;

public interface TicketService {

    Ticket add(Ticket reservation);
    List<Ticket> findAll();
    Ticket save(Ticket reservation);
    List<Ticket> findByUserId(Long id);
    void delete(Long id);


}