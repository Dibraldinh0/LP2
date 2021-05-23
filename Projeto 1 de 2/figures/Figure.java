package figures;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Figure {
	public int x, y, w, h;
	public Color contorno, fundo;
	
    public abstract void paint (Graphics g);
    
    public Figure(int x, int y, int w, int h, Color contorno, Color fundo) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.contorno = contorno;
		this.fundo = fundo;
    }
    
	public Color borda = new Color(255,10,10);	
	
	public boolean clicked (int posX, int posY) {
		  return (((x <= posX) && (y <= posY)) && ((posX <= (x + w)) && (posY <= (y + h))));
	}
	
	public void drawBorder(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(borda);
		g2d.drawRect(this.x, this.y, this.w, this.h);
	}	
}
