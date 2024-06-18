package org.example.carte;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.marcheur.Lieu;
import org.example.marcheur.Rue;

import java.util.List;

@AllArgsConstructor
@Getter
public class Carte {
    private List<Rue> rues;
    private List<Lieu> lieus;
}
