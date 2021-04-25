package figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

public class Triangle extends Figure {
	
	public int x, y, w, h;
	private Color contorno, fundo;
		
	public Triangle (int x, int y, int w, int h, Color contorno, Color fundo) {
 		this.x = x;
 		this.y = y;
	 	this.w = w;
	 	this.h = h;
	 	this.contorno = contorno;
	 	this.fundo = fundo;	 	
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		int[] xdir= {this.x, ((this.w)/2) + (this.x), (this.w) + (this.x)};
		int[] ydir={this.y, (this.y) - (this.h), this.y};
		g2d.drawPolygon(xdir, ydir, 3); 
		g2d.setColor(this.contorno);
		g2d.drawPolygon(xdir, ydir, 3);
		g2d.setColor(this.fundo);
		g2d.fillPolygon(xdir, ydir, 3);		
	}
}
