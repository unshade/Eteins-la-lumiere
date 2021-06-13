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
        if (grille.isConfig()) {
            grille.activerConfig(e.getX()/(vg.getWidth()/5), e.getY()/(vg.getHeight()/5));
        }
        else {
            if (grille.isJouer()) {
                grille.activerJouer(e.getX()/(vg.getWidth()/5), e.getY()/(vg.getHeight()/5));
            }
        }
    }
}
