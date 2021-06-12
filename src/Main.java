import Controleur.Bouton;
import Modele.Grille;
import Vue.VueGrille;

import javax.swing.*;
import java.awt.*;

/**
 * Classe principale
 */
public class Main {

    /**
     * Main pour lancer le programme
     * @param args arguments du main
     */
    public static void main(String[] args) {

        Grille g = new Grille();
        VueGrille vg = new VueGrille();
        g.addObserver(vg);
        vg.setPreferredSize(new Dimension(500,600));

        Bouton b = new Bouton(g);
        b.setPreferredSize(new Dimension(300,600));

        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(1, 2));
        frame.add(b);
        frame.add(vg);
        frame.setSize(new Dimension(850,600));
        frame.setVisible(true);

    }
}
