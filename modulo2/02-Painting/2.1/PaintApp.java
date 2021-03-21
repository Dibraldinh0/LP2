import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1, r2, r3;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Colorindo Retangulos");
        this.setSize(480, 480);
        this.r1 = new Rect(20,100, 100, 30, Color.green, Color.black);
        this.r2 = new Rect(20, 160, 150, 70, Color.yellow, Color.red);
        this.r3 = new Rect(20, 280, 200, 100, Color.magenta, Color.cyan);      
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
    }
}

class Rect {
    int x, y, w, h;
    Color contorno, fundo;

    Rect (int x, int y, int w, int h, Color contorno, Color fundo) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.contorno = contorno;
        this.fundo = fundo;
    }

    void print () {
        System.out.format("Tamanho (%d,%d)\nPosiçao (%d,%d)\n", this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(contorno);
        g2d.drawRect(this.x,this.y, this.w,this.h);
        g2d.setColor(fundo);        
        g2d.fillRect(x+1, y+1, w-1, h-1);
    }
}
