package buttons;

import java.awt.*;
import ivisible.IVisible;
import figures.Figure;

public class Button implements IVisible {
    public int idx;
    public Figure figo;

    public Button (int idx, Figure figo) {
		this.idx = idx;
        this.figo = figo;
    }
	
	@Override
    public boolean clicked (int x, int y) {
        return (figo.x-5<=x && x<=figo.x+figo.w+10 && figo.y-5<=y && y<=figo.y+figo.h+10);
    }
	
	@Override
    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(figo.x-5, figo.y-5, figo.w+10, figo.h+10);		
		if (focused) {
        	g2d.setColor(Color.GRAY);
        } 
        else {
        	g2d.setColor(Color.LIGHT_GRAY);
        }
        g2d.fillRect(figo.x-4, figo.y-4, figo.w+9, figo.h+9);
        this.figo.paint(g, false);
    }
}
