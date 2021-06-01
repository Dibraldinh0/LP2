import javax.swing.JOptionPane;

class Rect {
	int x, y;
	int w, h;
	
	Rect (int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	void print() {
		System.out.format("Posição(%d,%d)\nTamanho(%d,%d)\nÁrea(%d)\n", this.x, this.y, this.w, this.h, this.area());
	}
	
	int area() {
		return this.w * this.h;
	}
	
	void drag(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
}

public class RectApp {	

	public static void main(String[] args) {
		Rect r1 = new Rect(1, 1, 25, 25);
		r1.print();
		r1.area();
		int dx = Integer.parseInt(JOptionPane.showInputDialog("Arrasto na direção X"));
		int dy = Integer.parseInt(JOptionPane.showInputDialog("Arrasto na direção Y"));
		r1.drag(dx, dy);
		r1.print();
	}
}
