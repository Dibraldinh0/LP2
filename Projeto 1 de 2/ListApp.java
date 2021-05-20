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
        
        /*this.addMouseListener (new MouseAdapter() {
        	public void mousePressed (MouseEvent e) {
				
			}
		});        
        
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged (MouseEvent e) {
				
			}
		});*/

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent e) {
                	pMouse = getMousePosition();
                    int x = pMouse.x;
                    int y = pMouse.y;
                    int w = 100;
                    int h = 100;   
                    
                    //removido para facilitar nos testes   
                    
                    /*Scanner sc = new Scanner(System.in);
					
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
					
                    Color fundo = new Color(Rfundo, Gfundo, Bfundo);*/
                    
                    Color contorno = new Color(255, 0, 0);
                    Color fundo = new Color(0, 255, 255);              
                
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
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}
