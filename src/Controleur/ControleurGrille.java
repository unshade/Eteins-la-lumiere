package Controleur;

import Modele.Grille;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class ControleurGrille extends MouseInputAdapter {
    private Grille grille;
    private Bouton boutons;

    public ControleurGrille(Grille g){
        this.grille = g;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        boutons.incrementerCompteur();
        grille.activer(e.getX(), e.getY());
    }
}
