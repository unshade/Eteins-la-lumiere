package Modele;

import Controleur.Bouton;
import Vue.VueGrille;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Grille extends Observable {
    // taille de la grille
    private int taille;
    // tableau de boolean pour les lampes
    private boolean[][] lampe;
    // boolean jouer passant à true lorsqu on commence a jouer grace au bouton jouer
    private boolean jouer;

    public Grille(Observer observer){
        this.lampe = new boolean[5][5];
        // toutes les lampes sont eteintes a l initialisation
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                lampe[i][j] = false;
            }
        }
        // ajout de l observer
        this.addObserver(vg);
        taille = 500;
    }

    /**
     * methode permettant de lier les boutons a la grille
     * @param b
     */
    public void lierBoutton(Bouton b){
        this.boutons = b;
    }

    /**
     * methode verifiant qu au moins une case est allumee
     * @return un res permettant de commencer le jeu ou non
     */
    public boolean verifCases(){
        boolean res = true;
        int compte = 0;
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                // incrementation du compte permettant de debloquer le jeu
                if (lampe[i][j]){
                    compte++;
                } else {
                    res = false;
                }
            }
        }
        if (compte>0){
            res = true;
        }
        return res;
    }

    /**
     * methode permettant de jouer a condition qu on est pas en mode config et qu au moins une case est allumee
     */
    public void jouer(){
        jouer = true;
        while(!jeuFini()){
            // on peut cliquer qq part
        }
    }

    /**
     * methode permettant d activer et de desactiver une case en fonction des clics
     * @param x abscisse de la souris
     * @param y ordonnee de la souris
     */
    public void activerJouer(int x, int y){
        // si on joue et donc qu on ne configure pas alors on continue
        if (!config && jouer) {
            // on commence par allumer la lampe cliquee
            lampe[x][y] = !lampe[x][y];
            // puis on essaie d'allumer toutes celles a proximite
            try {
                lampe[x+1][y] = !lampe[x+1][y];
            } catch (IndexOutOfBoundsException e) {
                System.out.println("certaines cases n'existent pas");
            }

            try {
                lampe[x-1][y] = !lampe[x-1][y];
            } catch (IndexOutOfBoundsException e) {
                System.out.println("certaines cases n'existent pas");
            }

            try {
                lampe[x][y+1] = !lampe[x][y+1];
            } catch (IndexOutOfBoundsException e) {
                System.out.println("certaines cases n'existent pas");
            }

            try {
                lampe[x][y-1] = !lampe[x][y-1];
            } catch (IndexOutOfBoundsException e) {
                System.out.println("certaines cases n'existent pas");
            }
            // on avertit les observers des changements operes
            setChanged();
            notifyObservers();
        }
    }

    /**
     * permet de switch le bouton config entre on et off
     */
    public void configurerOnOff(){
        this.config = !this.config;
    }

    /**
     * permet d activer les lampes en mode config
     * @param x
     * @param y
     */
    public void activerConfig(int x, int y) {
        if(isConfig()){
            lampe[x][y] = !lampe[x][y];
            setChanged();
            notifyObservers();
        }
    }

    public void random() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                this.lampe[i][j] = random.nextBoolean();
            }
        }
        setChanged();
        notifyObservers();
    }

    /**
     * methode retournant true que lorsque le jeu est fini
     * @return un boolean
     */
    public boolean jeuFini() {
        boolean res = true;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (this.jouer && this.boutons.getCounter() > 0){
                    if (!this.lampe[i][j]){
                        compte++;
                    }
                }
            }
        }
        // toutes les cases doivent etre eteintes
        if(compte==25){
            res=true;
        }
        return res;
    }

    /**
     * getter de taille
     * @return
     */
    public int getTaille() {
        return taille;
    }

    /**
     * getter de
     * @return lampes (attribut tableau de boolean)
     */
    public boolean[][] getLampe() {
        return this.lampe;
    }

    /**
     * getter de l attribut jouer
     * @return jouer
     */
    public boolean isJouer() {
        return jouer;
    }

    /**
     * getter de l attribut config
     * @return config
     */
    public boolean isConfig() {
        return this.config;
    }
}
