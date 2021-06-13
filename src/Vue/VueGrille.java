package Vue;

import Modele.Grille;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class VueGrille extends JPanel implements Observer {

    private Grille grille;
    private static final int TAILLEX = 500;
    private static final int TAILLEY = 500;

    public VueGrille(){
        grille = new Grille(this);
        setPreferredSize(new Dimension(TAILLEX,TAILLEY));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = grille.getTaille();
        int h = grille.getTaille();
        //g.setColor(new Color(56, 174, 125));
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

        if (grille.jeuFini()) {
            JOptionPane.showMessageDialog(null, "Bravo, vous avez fini le jeu");
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("update de la grille");
        grille = (Grille) o;
        repaint();
    }

    public Grille getGrille() {
        return grille;
    }

    public static int getTAILLEX() {
        return TAILLEX;
    }

    public static int getTAILLEY() {
        return TAILLEY;
    }
}
