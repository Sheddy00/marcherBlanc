package org.example;

import lombok.Getter;

@Getter
public class Rue {
    private String nom;
    private Lieu premierLieu;
    private Lieu secondeLieu;

    public Rue(String nom, Lieu premierLieu, Lieu secondeLieu) {
        this.nom = nom;
        this.premierLieu = premierLieu;
        this.secondeLieu = secondeLieu;
    }
}
