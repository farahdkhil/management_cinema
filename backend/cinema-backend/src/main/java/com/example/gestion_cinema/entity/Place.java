package com.example.gestion_cinema.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
public class Place {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id ;
    private int number;
    private double longitude, latitude, altitude;
    @ManyToOne
    private Salle salle;

    @OneToMany(mappedBy = "place")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Ticket> tickets;
}
