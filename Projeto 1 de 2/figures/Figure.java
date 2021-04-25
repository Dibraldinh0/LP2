package figures;

import java.awt.Graphics;
import java.awt.Color;

public abstract class Figure {
	public int x, y, w, h;
	public Color contorno, fundo;
    public abstract void paint (Graphics g);
}
