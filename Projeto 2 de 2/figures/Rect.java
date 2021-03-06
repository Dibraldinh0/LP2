package figures;

import java.awt.*;
import java.awt.Color;

public class Rect extends Figure {

    public Rect (int x, int y, int w, int h, Color contorno, Color fundo) {
		super(x, y, w, h , contorno, fundo);
    }

	public void paint(Graphics g, boolean focused) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(this.contorno);
        g2d.drawRect(this.x, this.y, this.w, this.h);	
        g2d.setColor(this.fundo);
		g2d.fillRect(x+1, y+1, w-1, h-1);
	}
}

