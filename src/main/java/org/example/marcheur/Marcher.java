package org.example.marcheur;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.carte.Carte;

import java.util.*;

@AllArgsConstructor
@Getter
public class Marcher {
    private Lieu lieuActuelle;

    public List<Lieu> marcher_vers_destination(Lieu destination, List<Rue> rues) {
        Map<Lieu, Integer> distances = new HashMap<>();
        Map<Lieu, Lieu> previousNodes = new HashMap<>();
        PriorityQueue<Lieu> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        distances.put(lieuActuelle, 0);
        queue.add(lieuActuelle);

        while (!queue.isEmpty()) {
            Lieu current = queue.poll();

            if (current.equals(destination)) {
                return reconstructPath(previousNodes, destination);
            }

            for (Rue rue : rues) {
                Lieu neighbor = null;
                if (rue.getPremierLieu().equals(current)) {
                    neighbor = rue.getSecondeLieu();
                } else if (rue.getSecondeLieu().equals(current)) {
                    neighbor = rue.getPremierLieu();
                }

                if (neighbor != null) {
                    int newDistance = distances.get(current) + 1;
                    if (!distances.containsKey(neighbor) || newDistance < distances.get(neighbor)) {
                        distances.put(neighbor, newDistance);
                        previousNodes.put(neighbor, current);
                        queue.add(neighbor);
                    }
                }
            }
        }

        return null;
    }

    private List<Lieu> reconstructPath(Map<Lieu, Lieu> previousNodes, Lieu destination) {
        List<Lieu> path = new ArrayList<>();
        Lieu current = destination;
        while (current != null) {
            path.add(current);
            current = previousNodes.get(current);
        }
        Collections.reverse(path);
        return path;
    }
}
