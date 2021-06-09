package Modele;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class Grille extends Observable {

    private int taille;
    private Color c;

    public Grille(){
        taille = 500;
        c = new Color(156,174,125);
    }

    public int getTaille() {
        return taille;
    }

    public Color getC() {
        return c;
    }
}
