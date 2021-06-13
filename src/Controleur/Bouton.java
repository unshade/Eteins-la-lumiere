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
    private JButton config, random, jouer, quitter;
    private JLabel counter;
    private int count;

    /**
     * Constructeur des boutons
     * @param g grille de lampe
     */
    public Bouton(Grille g){

        //initialisation attributs, layout et elements
        modele = g;
        this.setLayout(new GridLayout(6,1));
        config = new JButton("Configurer");
        random = new JButton("Aleatoire");
        jouer = new JButton("Jouer");
        counter = new JLabel("         Nombre de clics :  0");
        quitter = new JButton("Quitter");

        //Ajout des actions listeners aux elements
        config.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modele.config();
            }
        });

        random.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modele.random();
            }
        });

        jouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modele.jouer();
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
        this.add(counter);
        this.add(quitter);
    }

    public int getCounter() {
        return count;
    }

    public void incrementerCompteur(){
        count++;
        counter.setText("         Nombre de clics :  "+count);
    }
}
