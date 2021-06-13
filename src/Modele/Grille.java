package Modele;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Grille extends Observable {

    private int taille;
    private boolean[][] lampe;
    private boolean jouer;

    public Grille(Observer observer){
        this.lampe = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                lampe[i][j] = false;
            }
        }
        this.addObserver(observer);
        taille = 500;
    }

    public void jouer(){
        jouer = true;
        while(!jeuFini()){
            // on peut cliquer qq part
        }
    }

    public void activerJouer(int x, int y){
        if (!config && jouer) {
            try {
                lampe[x][y] = true;

                lampe[x+1][y] = true;
                lampe[x-1][y] = true;
                lampe[x][y+1] = true;
                lampe[x][y-1] = true;
                setChanged();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("certaines cases n'existent pas");
            }
            notifyObservers();
        }
    }

    public void config(){
        while(!jouer){
            // la case cliquée devient true
            // TODO c le gange
            // TODO IL FAUT INTERAGIR AVEC LE CONTROLEUR GRILLE POUR CHOISIR LA CASE SOUHAITEE

        }
    }

    public void activerConfig(int x, int y) {
        if (isConfig()) {
            lampe[x][y] = true;
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

    public boolean jeuFini() {
        boolean res = true;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!this.lampe[i][j]) {
                    res = false;
                }
            }
        }
        if (res){
            setChanged();
        }
        notifyObservers();
        return res;
    }

    public int getTaille() {
        return taille;
    }

    public boolean[][] getLampe() {
        return this.lampe;
    }

    public boolean isJouer() {
        return jouer;
    }

    public boolean isConfig() {
        return this.config;
    }
}
