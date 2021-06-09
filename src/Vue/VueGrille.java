package Vue;

import Modele.Grille;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class VueGrille extends JPanel implements Observer {

    private Grille grille;

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        int w = grille.getTaille();
        int h = grille.getTaille();
        //g.setColor(new Color(56, 174, 125));
        g.setColor(grille.getC());
        g.fillRect(0,0,w,h);
        g.setColor(Color.black);
        for (int i = 0; i<5; i++){
            g.drawLine((w+i)/5,0,(w+i)/5,h-1);
            g.drawLine(0,(h+i)/5,w-1,(h+i)/5);
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
}
