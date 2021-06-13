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
     * boutons du jeu
     */
    private JButton config, random, jouer, quitter;
    /**
     * Jlabel permettant de compter le nombre de clics
     */
    private JLabel counter;
    /**
     * entier permettant d'incrementer
     */
    private int count;
    /**
     * boolean bloquant l'utilisation de certains boutons
     */
    private boolean bloqueur;

    /**
     * Constructeur des boutons
     * @param g grille de lampe
     */
    public Bouton(Grille g){
        //initialisation attributs, layout et elements
        bloqueur = true;
        modele = g;
        // gestion du layout avec un grid layout
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
                modele.configurerOnOff();
                jouer.setEnabled(!bloqueur);
                bloqueur = !bloqueur;
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

        //Ajout des elements a la classe
        this.add(config);
        this.add(random);
        this.add(jouer);
        this.add(counter);
        this.add(quitter);
    }

    /**
     * getteur du compte
     */
    public int getCounter() {
        return count;
    }

    /**
     * methode permettant d incrementer le compteur de clics
     */
    public void incrementerCompteur(){
        count++;
        counter.setText("         Nombre de clics :  "+count);
    }
}
