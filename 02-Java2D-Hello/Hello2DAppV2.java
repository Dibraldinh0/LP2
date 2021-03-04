import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DAppV2 {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
        frame.setVisible(true);
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(300, 300);
        this.getContentPane().setBackground(Color.black);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.blue);
        g.fillRect(0, 0, 250, 250);
		g2d.setPaint(Color.red);
        g.fillRect(0, 0, 200, 200);
        g2d.setPaint(Color.white);
        g.fillRect(0, 0, 150, 150);
        g2d.setPaint(Color.blue);
        g.fillRect(0, 0, 100, 100);
        g2d.setPaint(Color.red);
        g.fillRect(0, 0, 50, 50);
		
    }
}
