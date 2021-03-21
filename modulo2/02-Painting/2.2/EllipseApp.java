import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class EllipseApp {
    public static void main (String[] args) {
        EllipseFrame frame = new EllipseFrame();
        frame.setVisible(true);
    }
}

class EllipseFrame extends JFrame {
    Ellipse e1, e2, e3;

    EllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Colorindo Elipses");
        this.setSize(480, 480);
        
        this.e1 = new Ellipse(25, 50, 70, 30, Color.black, new Color(30, 30, 210));
        this.e2 = new Ellipse(25, 100, 100, 100, Color.blue, new Color(195, 40, 30));
        this.e3 = new Ellipse(25, 200, 30, 70, Color.yellow, new Color(0, 100, 55));
        
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
    }
}

class Rect {
    int x, y, w, h;

    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void print () {
        System.out.format("Retangulo:\nTamanho (%d,%d)\nPosiçao (%d,%d)\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        g.drawRect(this.x,this.y, this.w,this.h);
    }
}

class Ellipse {
    int x, y, w, h;
    Color contorno, fundo;

    Ellipse (int x, int y, int w, int h, Color contorno, Color fundo) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.contorno = contorno;
        this.fundo = fundo;
    }

    void print () {
        System.out.format("Elipse:\nTamanho (%d,%d)\nPosiçao (%d,%d)\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(contorno);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g2d.setColor(fundo);
        g2d.fillOval(x, y, w, h);
    }
}
