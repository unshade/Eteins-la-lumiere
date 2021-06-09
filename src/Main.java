import Controleur.Bouton;
import Modele.Grille;
import Vue.VueGrille;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Grille g = new Grille();
        VueGrille vg = new VueGrille();
        g.addObserver(vg);
        vg.setPreferredSize(new Dimension(500,500));

        Bouton b = new Bouton(g);
        b.setPreferredSize(new Dimension(200,200));

        JFrame frame=new JFrame();
        frame.add(vg,BorderLayout.EAST);
        frame.add(b,BorderLayout.WEST);
        frame.setSize(new Dimension(700,700));
        frame.setVisible(true);

    }
}
