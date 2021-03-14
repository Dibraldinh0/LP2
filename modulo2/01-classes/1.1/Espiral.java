public class Espiral {
	int x, y, h, w, v, r, g, b;
	
	Espiral (int x, int y, int h, int w, int v, int r, int g, int b) {
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
		this.v = v;
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	void print () {
		System.out.format("Posicao (%d, %d)\nTamanho (%d, %d)\nNº de Voltas (%d)\nCor RGB (%d, %d, %d)\n", this.x, this.y, this.h, this.w, this.v, this.r, this.g, this.b);
	}

	public static void main(String[] args) {
		Espiral es = new Espiral(1, 1, 10, 10, 5, 120, 40, 40);
		es.print();
		
	}

}
