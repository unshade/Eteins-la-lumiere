package Controleur;

import Modele.Grille;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class ControleurGrille extends MouseInputAdapter {
    /**
     * attribut grille
     */
    private Grille grille;
    /**
     * attribut boutons representant les boutons du jeu
     */
    private Bouton boutons;

    public ControleurGrille(Grille g){
        this.grille = g;
    }

    /**
     * methode permettant de réagir en fonction de l'evenement e
     * @param e evenement du clic de la souris
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        // incrementation du compteur
        boutons.incrementerCompteur();
        // si on config alors...
        if (grille.isConfig()) {
            // on allume seulement la case cliquee
            grille.activerConfig(e.getX()/(vg.getWidth()/5), e.getY()/(vg.getHeight()/5));
        }
        else {
            // si on joue alors...
            if (grille.isJouer()) {
                // on allume les cases adjacentes
                grille.activerJouer(e.getX()/(vg.getWidth()/5), e.getY()/(vg.getHeight()/5));
            }
        }
    }
}
