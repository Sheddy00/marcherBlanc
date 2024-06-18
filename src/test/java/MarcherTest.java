import org.example.carte.Carte;
import org.example.marcheur.Lieu;
import org.example.marcheur.Marcher;
import org.example.marcheur.Rue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MarcherTest {
    @Test
    public void test_des_marche() {
        var HEI = new Lieu("HEI");
        var pullman = new Lieu("Pullman");
        var nexta = new Lieu("Nexta");
        var balancoire = new Lieu("Balançoire");
        var ESTI = new Lieu("ESTI");
        var sekolintsika = new Lieu("Sekolintsika");
        var marais = new Lieu("Marais");
        var boulevard = new Lieu("Boulevard de l'Europe");

        var rue1 = new Rue("Rue Andriantsitoharana", HEI, pullman);
        var rue2 = new Rue("Rue Ranaivo", pullman, balancoire);
        var rue3 = new Rue(null, balancoire, boulevard);
        var rue5 = new Rue(null, balancoire, ESTI);
        var rue6 = new Rue(null, boulevard, ESTI);
        var rue7 = new Rue(null, pullman, nexta);
        var rue8 = new Rue(null, HEI, sekolintsika);
        var rue9 = new Rue(null, sekolintsika, marais);

        List<Lieu> lieus = new ArrayList<>();
        lieus.add(HEI);
        lieus.add(pullman);
        lieus.add(nexta);
        lieus.add(balancoire);
        lieus.add(ESTI);
        lieus.add(sekolintsika);
        lieus.add(marais);
        lieus.add(boulevard);

        List<Rue> rues = new ArrayList<>();
        rues.add(rue1);
        rues.add(rue2);
        rues.add(rue3);
        rues.add(rue5);
        rues.add(rue6);
        rues.add(rue7);
        rues.add(rue8);
        rues.add(rue9);

        Carte carte = new Carte(rues, lieus);

        Marcher Bjami = new Marcher(marais);

        List<Lieu> cheminParcouru = Bjami.marcher_vers_destination(ESTI, rues);
        List<Lieu> cheminAttendu = List.of(marais, sekolintsika, HEI, balancoire, ESTI);

        assertEquals(cheminParcouru, cheminAttendu);
    }
}
