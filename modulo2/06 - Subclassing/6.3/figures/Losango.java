package figures;

import java.awt.*;

public class Losango extends Figure {

    private int x, y, w, h;

    public Losango (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    
    public void print() {
		System.out.format("Losango de tamanho (%d,%d) na posição (%d,%d).\n",
		this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.rotate(3.14/4);
        g2d.drawRect(this.x, this.y, this.w, this.h);
    }
}
