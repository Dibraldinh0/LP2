package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.Color;

public class Ellipse extends Figure {

	public int x, y, w, h;
	private Color contorno, fundo;
   	
    public Ellipse (int x, int y, int w, int h, Color contorno, Color fundo) {
        super(x, y, w, h , contorno, fundo);
    }

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(this.contorno);
        g2d.draw(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
        g2d.setColor(this.fundo);
		g2d.fillOval(x, y, w, h);
	}
    
}
