import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;

import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Scanner sc = new Scanner(System.in);
    Point pMouse = null;
    Figure focus = null;
    int distX, distY;
    
    ListFrame () {
    	this.setTitle("Projeto");
        this.setSize(700, 700);
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        
        this.addMouseListener (new MouseAdapter() {
        	public void mousePressed (MouseEvent evt) {
        		focus = null;
				pMouse = getMousePosition();
        		for (Figure fig: figs) {
        			if(((fig.x >= pMouse.x) && (fig.y >= pMouse.y)) && ((pMouse.x >= (fig.x + fig.w)) && (pMouse.y >= (fig.y + fig.h )))) {
        				focus = fig;
        			}
        		}        		
        	}
        });        
        
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged (MouseEvent evt){
				if(focus != null) {
					figs.remove(focus);
        			figs.add(focus);
        			distX = focus.x - pMouse.x;
        			distY = focus.y - pMouse.y;                    
				}
				repaint();				
			}
		});

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                	pMouse = getMousePosition();
                    int x = pMouse.x;
                    int y = pMouse.y;
                    int w = 100;
                    int h = 100;      
                    
                    Scanner sc = new Scanner(System.in);
					
					System.out.print("Valor de R para o Contorno até 255: ");  
					int Rcontorno = sc.nextInt();  
					System.out.print("Valor de G para o Contorno até 255: ");  
					int Gcontorno = sc.nextInt();  
					System.out.print("Valor de B para o Contorno até 255: ");  
					int Bcontorno = sc.nextInt();
					
					Color contorno = new Color(Rcontorno, Gcontorno, Bcontorno);
					
					Scanner scfundo = new Scanner(System.in);
                    System.out.print("Valor de R para o Fundo até 255: ");  
					int Rfundo = sc.nextInt();  
					System.out.print("Valor de G para o Fundo até 255: ");  
					int Gfundo = sc.nextInt();  
					System.out.print("Valor de B para o Fundo até 255: ");  
					int Bfundo = sc.nextInt();
					
                    Color fundo = new Color(Rfundo, Gfundo, Bfundo);              
                
                    if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x, y, w, h, contorno, fundo));
                        focus = figs.get(figs.size()-1);
                    }                     
                    else if (evt.getKeyChar() == 'r') {
                        figs.add(new Rect(x, y, w, h, contorno, fundo));
                        focus = figs.get(figs.size()-1);
                    }                                       
                    else if (evt.getKeyChar() == 't') {
                    	figs.add(new Triangle(x, y, w, h, contorno, fundo));
                    	focus = figs.get(figs.size()-1);
                    } 
                    else if (evt.getKeyChar() == 'p') {
                    	figs.add(new Pentagon(x, y, w, h, contorno, fundo));
                    	focus = figs.get(figs.size()-1);
                    }
                    else if (evt.getKeyCode() == 127) {
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
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}
