package figures;

import java.awt.*;

public class Rect extends Figure {
    public Rect (int x, int y, int w, int h, int rc, int gc, int bc, int rf, int gf, int bf) {
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

	@Override
	public void print() {
		System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
	            this.w, this.h, this.x, this.y);
		
	}

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(rc, gc, bc));
        g2d.drawRect(this.x, this.y, this.w, this.h);
        g2d.setColor(new Color(rf, gf, bf));
        g2d.fillRect(x+1, y+1, w-1, h-1);
	}
        
}
