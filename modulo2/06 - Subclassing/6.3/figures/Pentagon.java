package figures;

import java.awt.*;

public class Pentagon extends Figure {
    public Pentagon (int x, int y, int w, int h, int rc, int gc, int bc, int rf, int gf, int bf) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.rc = rc;
		this.gc = gc;
		this.bc = bc;
		this.rf = rf;
		this.gf = gf;
		this.bf = bf;
    }
    
    public void print() {
		System.out.format("Pentágono de tamanho (%d,%d) na posição (%d,%d).\n", this.w, this.h, this.x, this.y);
    }

	public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		int[] xdir = {(int) (this.x + this.w/2), this.x + this.w, (int) (this.x + this.w*0.75), (int) (this.x + this.w*0.25), this.x};
		int[] ydir = {this.y, (int) (this.y + this.h*0.40), this.y+this.h, this.y+this.h, (int) (this.y + this.h*0.40) };
		g2d.setColor(new Color(rc, gc, bc));
		g2d.drawPolygon(xdir, ydir, 5);
		g2d.setColor(new Color(rf, gf, bf));
		g2d.fillPolygon(xdir, ydir, 5);		
	}
}
