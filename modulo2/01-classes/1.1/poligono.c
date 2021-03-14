#include <stdio.h>

typedef struct {
	int x, y;
	int h, w;
	int lados;
	int r, g, b
}

Poligono;

void print (Poligono * p){
	printf("Tamanho (%d, %d)\nPosicao (%d, %d)\nNumero de lados (%d)\nCor RGB (%d, %d ,%d)", p->x, p->y, p->h, p->w, p->lados, p->r, p->g, p->b);
}

int main (){
	Poligono p1 = {2, 2, 4, 4, 5, 120, 40, 40};
	print(&p1);
	
	return 0;
}
