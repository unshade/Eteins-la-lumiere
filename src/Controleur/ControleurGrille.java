package Controleur;

import Modele.Grille;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class ControleurGrille extends MouseInputAdapter {
    private Grille grille;

    public ControleurGrille(Grille g){
        this.grille = g;
    }

    /*
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
    }*/
    public void activer(int x, int y){
        if (x <= grille.getTaille()/5 && y <= grille.getTaille()/5){
            // tu chopes les 4 souhaitées et tu les mets en couleur + foncee
            grille.getLampe()[0][0] = true;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        this.activer(e.getX(), e.getY());
    }
}
