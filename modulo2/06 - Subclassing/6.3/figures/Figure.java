package figures;

import java.awt.Graphics;

public abstract class Figure {
	int x, y, w, h, rc, gc, bc, rf, gf, bf;	
	public abstract void print ();
    public abstract void paint (Graphics g);
}
