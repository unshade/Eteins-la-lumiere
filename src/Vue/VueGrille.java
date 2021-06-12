package Vue;

import Modele.Grille;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class VueGrille extends JPanel implements Observer {

    private Grille grille;
    private static final int TAILLEX = 500;
    private static final int TAILLEY = 600;

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
        g.setColor(grille.getC());
        g.fillRect(0,0,w,h);
        g.setColor(Color.black);
        for (int i = 1; i<6; i++){
            g.drawLine((w/5)*i,0,(w/5)*i,h);
            g.drawLine(0,(h/5)*i,w-1,(h/5)*i);
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
