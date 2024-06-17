package org.example;

import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class Carte {
    private Map<Lieu, List<Rue>> adjacences;

}
