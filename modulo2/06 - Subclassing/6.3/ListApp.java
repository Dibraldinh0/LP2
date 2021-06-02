import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    int x = rand.nextInt(350);
                    int y = rand.nextInt(350);
                    int w = rand.nextInt(50);
                    int h = rand.nextInt(50);
                    int rc = rand.nextInt(255);
                    int gc = rand.nextInt(255);
                    int bc = rand.nextInt(255);
                    int rf = rand.nextInt(255);
                    int gf = rand.nextInt(255);
                    int bf = rand.nextInt(255);
                    if (evt.getKeyChar() == 'r') {
                        figs.add(new Rect(x, y, w, h, rc, gc, bc, rf, gf, bf));
                    }
                    else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x, y, w, h, rc, gc, bc, rf, gf, bf));
                    }
                    else if (evt.getKeyChar() == 'p') {
                    	figs.add(new Pentagon(x, y, w, h, rc, gc, bc, rf, gf, bf));
                    }
                    repaint();
                }
            }
        );

        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}
