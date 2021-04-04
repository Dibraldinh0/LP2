package figures;

import java.awt.*;

public class Rect extends Figure {

	private int x, y, w, h;

    public Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

	@Override
	public void print() {
		System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
	            this.w, this.h, this.x, this.y);
		
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(this.x, this.y, this.w, this.h);	
	}
}
