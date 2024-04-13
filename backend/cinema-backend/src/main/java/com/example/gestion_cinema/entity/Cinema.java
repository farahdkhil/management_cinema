package com.example.gestion_cinema.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
public class Cinema implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    private String address;
    private int nombreSalles;

    @OneToMany(mappedBy = "cinema")
    private Collection<Salle> salles;

    @ManyToOne
    private Ville ville;

    // constructors
    public Cinema() {}

    public Cinema(String name, String address, int nombreSalles) {
        this.name = name;
        this.address = address;
        this.nombreSalles = nombreSalles;
    }

    public Cinema(String name, String address, int nombreSalles, Ville ville) {
        this.name = name;
        this.address = address;
        this.nombreSalles = nombreSalles;
        this.ville = ville;
    }

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNombreSalles() {
        return nombreSalles;
    }

    public void setNombreSalles(int nombreSalles) {
        this.nombreSalles = nombreSalles;
    }

    public Collection<Salle> getSalles() {
        return salles;
    }

    public void setSalles(Collection<Salle> salles) {
        this.salles = salles;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }
}

