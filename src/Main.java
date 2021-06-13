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
        // creation des elements necessaires au jeu
        VueGrille vg = new VueGrille();
        Grille g = new Grille(vg);
        Bouton b = new Bouton(g);
        // liaison des boutons a la grille
        g.lierBoutton(b);
        ControleurGrille cg = new ControleurGrille(vg, g, b);
        b.setPreferredSize(new Dimension(300,500));
        // creation de la fenetre et ajout des elements a celle ci
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(b, BorderLayout.WEST);
        frame.add(vg, BorderLayout.CENTER);
        frame.setSize(new Dimension(815,535));
        frame.setVisible(true);
        frame.pack();
    }
}
