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
        VueGrille vg = new VueGrille();
        Grille g = new Grille(vg);
        Bouton b = new Bouton(g);
        b.setPreferredSize(new Dimension(300,600));
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(b, BorderLayout.WEST);
        frame.add(vg, BorderLayout.EAST);
        frame.setSize(new Dimension(850,600));
        frame.setVisible(true);
    }
}
