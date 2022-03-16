package com.example.evaljava.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Editeur {
    public Editeur() {
    }

    public Editeur(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    Long id;

    @Column
    String nom;

    @Column
    String adresse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "EditeurEntity{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}

