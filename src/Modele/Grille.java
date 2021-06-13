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

    public void config(){
        while(!jouer){
            // la case cliquée devient true
            // TODO c le gange
            // TODO IL FAUT INTERAGIR AVEC LE CONTROLEUR GRILLE POUR CHOISIR LA CASE SOUHAITEE

        }
    }

    public void activer(int x, int y){
        // TODO faire en sorte de généraliser
        if (x <= this.getTaille()/5 && y <= this.getTaille()/5){
            lampe[0][0] = true;
            // tu chopes les 4 souhaitées et tu les mets en couleur
            lampe[1][0] = true;
            lampe[0][1] = true;
            setChanged();
        }
        notifyObservers();
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
}
