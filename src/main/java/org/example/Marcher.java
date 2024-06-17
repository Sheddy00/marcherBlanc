package org.example;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Marcher {
    private Carte carte;
    private Lieu lieuActuelle;

    public List<Lieu> marcher_ver_destination(Lieu destination) {
        List<Lieu> marche = new ArrayList<>();
        marche.add(lieuActuelle);

        while (!lieuActuelle.equals(destination)) {
            List<Rue> possibilite = carte.getAdjacences().get(destination);
            Rue choixDeRue = possibilite.get(new Random().nextInt(possibilite.size()));
            Lieu positionSuivante = choixDeRue.getArrivee();

            marche.add(positionSuivante);
            lieuActuelle = positionSuivante;
        }
        return marche;
    }
}
