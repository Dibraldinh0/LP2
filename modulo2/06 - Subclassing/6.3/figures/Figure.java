package figures;

import java.awt.Graphics;

public abstract class Figure {
	int x, y, w, h;
	public abstract void print ();
    public abstract void paint (Graphics g);
}
