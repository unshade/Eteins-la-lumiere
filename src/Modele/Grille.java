package Modele;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Grille extends Observable {

    private int taille;
    private Color c;

    public Grille(Observer observer){
        this.addObserver(observer);
        taille = 500;
        c = new Color(62, 128, 85);
    }

    public int getTaille() {
        return taille;
    }

    public Color getC() {
        return c;
    }
}
