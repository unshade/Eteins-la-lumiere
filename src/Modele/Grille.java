package Modele;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Grille extends Observable {

    private int taille;
    private boolean[][] lampe;

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

    public int getTaille() {
        return taille;
    }

    public boolean[][] getLampe() {
        return this.lampe;
    }
}
