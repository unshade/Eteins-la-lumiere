package Vue;

import Modele.Grille;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class VueGrille extends JPanel implements Observer {
    /**
     * attribut grille
     */
    private Grille grille;

    /**
     * constructeur de la vue de la grille
     */
    public VueGrille(){
        // on lui attribue une grille
        grille = new Grille(this);
        // on set la taille
        setPreferredSize(new Dimension(500,500));
    }

    /**
     * methode permettant de creer le rendu graphique (issu de swing) afin que l'utilisateur ait acces au jeu depuis une fenetre
     * @param g graphics
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // on stocke la taille de la grille
        int w = grille.getTaille();
        int h = grille.getTaille();
        boolean[][] lampes = grille.getLampe();
        // boucle conditionnelle permettant le changement de couleur
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (lampes[i][j]) {
                    g.setColor(new Color(43, 224, 106));
                }
                else {
                    g.setColor(new Color(62, 128, 85));
                }
                // dessin des carrés de la grille
                g.fillRect((i*w)/5,(j*h)/5,w/5,h/5);
            }
        }
        // dessin des lignes noires de séparation
        for (int i = 1; i < 6; i++) {
            g.setColor(Color.black);
            g.drawLine((w/5)*i,0,(w/5)*i,h);
            g.drawLine(0,(h/5)*i,w-1,(h/5)*i);
        }
        // afficher ecran de fin et fermer la fenetre
        if (grille.jeuFini()) {
            JOptionPane.showMessageDialog(null, "Bravo, vous avez fini le jeu");
        }
    }

    /**
     * methode permettant de mettre a jour la grille
     * @param o qui represente la grille
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("update de la grille");
        grille = (Grille) o;
        repaint();
    }

}
