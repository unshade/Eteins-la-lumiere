package Controleur;

import Modele.Grille;

import javax.swing.*;
import java.awt.*;

public class Bouton extends JPanel {

    private Grille modele;

    public Bouton(Grille g){
        modele = g;
        this.setLayout(new GridLayout(5,1));
        JButton config = new JButton("Configurer");
        JButton random = new JButton("Aleatoire");
        JButton jouer = new JButton("Jouer");
        JTextArea text = new JTextArea();
        JButton quitter = new JButton("Quitter");

        this.add(config);
        this.add(random);
        this.add(jouer);
        this.add(text);
        this.add(quitter);
    }
}
