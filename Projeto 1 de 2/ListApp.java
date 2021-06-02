import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Scanner;

import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
        frame.setFocusTraversalKeysEnabled(false);
    }
}

class ListFrame extends JFrame {   
	ArrayList<Figure> figs = new ArrayList<Figure>();
	Point pMouse = null;
    Figure focus = null;       
	int dx, dy;
	int contContorno = 0;
	int contFundo = 1;
	
	Color cores[] = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.WHITE, Color.BLACK, Color.GRAY, Color.LIGHT_GRAY, Color.DARK_GRAY, Color.PINK, Color.ORANGE};
   
    ListFrame () {
    	this.setTitle("Projeto 1/2");
        this.setSize(700, 700);
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        
        this.addMouseListener(
            new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    pMouse = getMousePosition();
                    focus = null;
                    for (Figure figo: figs) {
                        if (figo.clicked(pMouse.x, pMouse.y)) {
                            focus = figo;
                            figs.remove(focus);
                            figs.add(focus);
                            dx = focus.x - pMouse.x;
                            dy = focus.y - pMouse.y;
                            break;
						}
						repaint();
					}
                }   
            }
        );

        this.addMouseMotionListener(
            new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent me) {
                    pMouse = getMousePosition();
                    if (focus != null) {
                        figs.remove(focus);
                        figs.add(focus);
                        focus.x = pMouse.x + dx;
                        focus.y = pMouse.y + dy;
                    }
					repaint();
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent e) {
                	pMouse = getMousePosition();
                    int x = pMouse.x;
                    int y = pMouse.y;
                    int w = 100;
                    int h = 100;                    
                    Color contorno = cores[contContorno];
                    Color fundo = cores[contFundo];
                    
					//Criar novas figuras
					//E cria uma elipse
					//R cria um retângulo
					//T cria um triângulo
					//P cria um Pentágono
                    if (e.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x, y, w, h, contorno, fundo));
                        focus = figs.get(figs.size()-1);
                    }                     
                    else if (e.getKeyChar() == 'r') {
                        figs.add(new Rect(x, y, w, h, contorno, fundo));
                        focus = figs.get(figs.size()-1);
                    }                                       
                    else if (e.getKeyChar() == 't') {
                    	figs.add(new Triangle(x, y, w, h, contorno, fundo));
                    	focus = figs.get(figs.size()-1);
                    } 
                    else if (e.getKeyChar() == 'p') {
                    	figs.add(new Pentagon(x, y, w, h, contorno, fundo));
                    	focus = figs.get(figs.size()-1);
                    }                    
                    
                    //Redimensionamento das figuras
                    //D aumenta a largura da figura
                    //A diminui a largura da figura 
                    //S aumenta a altura da figura		
                    //W diminui a altura da figura	                    
                    else if (e.getKeyChar() == 'd' ) {						
						focus.w += 10; 
						focus = figs.get(figs.size()-1);
                    }
                    else if (e.getKeyChar() == 'a' ) {                   	
                    	focus.w -= 10;
                    	if (focus.w < 10) {
							focus.w += 10;
                    	} 
						focus = figs.get(figs.size()-1);
                    }
                    else if (e.getKeyChar() == 's' ) {				
						focus.h += 10; 
						focus = figs.get(figs.size()-1);
                    }
                    else if (e.getKeyChar() == 'w' ) {					
						focus.h -= 10;
						if (focus.h < 10) {
							focus.h += 10;
                    	}  
						focus = figs.get(figs.size()-1);
                    }                    
                    
					//Troca de cores
                    //C muda a cor do contorno e F a do fundo
                    else if (e.getKeyChar() == 'c'){
                    	contContorno += 1;
                    	if (contContorno > 12){
                    		contContorno = 0;
                    	}
                    	focus.contorno = cores[contContorno];
                    }
                    else if (e.getKeyChar() == 'f'){
                    	contFundo += 1;
                    	if (contFundo > 12){
                    		contFundo = 0;
                    	}
                    	focus.fundo = cores[contFundo];
                    }
                    
                    //Usando a tecla TAB alteramos a figura em foco 
                    else if (e.getKeyCode() == 9) {
		                for (Figure figo: figs) {
		                    if (focus != figo){
		                        focus=figo;
		                        figs.remove(figo);
		                        figs.add(figo);
		                        repaint();
		                        break;
		                    }
		                }
		            }                      
                    
                    //Deletar a figura em foco pressionando delete
                    else if (e.getKeyCode() == 127) {
		            	figs.remove(focus);
		            	focus = null;
		            }
                    repaint();
                }
            }
        );
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure figo: this.figs) {
            figo.paint(g);
        }
        
        if (focus != null) {
            focus.drawBorder(g);
        }
    }
}
