package org.example.marcheur;

import lombok.Getter;
import org.example.marcheur.Lieu;

@Getter
public class Rue {
    private final String nom;
    private final Lieu premierLieu;
    private final Lieu secondeLieu;

    public Rue(String nom, Lieu premierLieu, Lieu secondeLieu) {
        this.nom = null;
        this.premierLieu = premierLieu;
        this.secondeLieu = secondeLieu;
    }
}
