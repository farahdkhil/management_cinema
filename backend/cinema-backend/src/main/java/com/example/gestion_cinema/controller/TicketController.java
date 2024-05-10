package com.example.gestion_cinema.controller;

import com.example.gestion_cinema.entity.Ticket;
import com.example.gestion_cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService reservationService;

    @GetMapping("/find-all")
    public List<Ticket> findAll() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return reservationService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        reservationService.delete(id);
    }

    @PostMapping("/add")
    public Ticket save(@RequestBody Ticket reservation){
        return reservationService.save(reservation);
    }

    @GetMapping("find-by-user-id/{id}")
    public List<Ticket> findByUserId(@PathVariable Long id) throws InterruptedException {
      TimeUnit.SECONDS.sleep(1);

      return reservationService.findByUserId(id);
    }

}