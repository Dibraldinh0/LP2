import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;

class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect r1;
    Ellipse e1;
    Losango l1;

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(480, 480);
        this.r1 = new Rect(50, 50, 100, 50, Color.red, Color.blue);
        this.e1 = new Ellipse(50, 110, 100, 100, Color.green, Color.yellow);
        this.l1 = new Losango(240, -50, 220, 220, Color.black, Color.white);
        
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
        this.l1.paint(g);
    }
}
