package Controleur;

import Modele.Grille;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe Bouton, contient la grille de lampe et les boutons d'interraction
 */
public class Bouton extends JPanel {

    /**
     * Grille de lampe
     */
    private Grille modele;

    /**
     * Constructeur des boutons
     * @param g grille de lampe
     */
    public Bouton(Grille g){

        //initialisation attributs, layout et elements
        modele = g;
        this.setLayout(new GridLayout(6,1));
        JButton config = new JButton("Configurer");
        JButton random = new JButton("Aleatoire");
        JButton jouer = new JButton("Jouer");
        JTextArea text = new JTextArea();
        JButton quitter = new JButton("Quitter");

        //Ajout des actions listeners aux elements

        config.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        random.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        jouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        //Ajout des elements

        this.add(config);
        this.add(random);
        this.add(jouer);
        this.add(text);
        this.add(quitter);
    }
}
