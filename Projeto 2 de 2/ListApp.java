import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;

import java.io.*;

import buttons.Button;
import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {   
	ArrayList<Figure> figs = new ArrayList<Figure>();
	ArrayList<Button> buts = new ArrayList<Button>();
	Point pMouse = null;
    Figure focus = null; 
    Button butfocus = null;      
	int dx, dy;
	int contContorno = 0;
	int contFundo = 1;
	
	Color cores[] = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.WHITE, Color.BLACK, Color.GRAY, Color.LIGHT_GRAY, Color.DARK_GRAY, Color.PINK, Color.ORANGE};
   
    ListFrame () {
    	this.setTitle("Projeto 2/2");
        this.setSize(700, 700);
        
       try {
			FileInputStream f = new FileInputStream("proj.bin");
        	ObjectInputStream o = new ObjectInputStream(f);
        	this.figs = (ArrayList<Figure>) o.readObject();
        	o.close();
        }        
        catch (Exception x) {
        	System.out.println("ERRO AO ABRIR");
        } 
        
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                	try {
                		FileOutputStream f = new FileOutputStream("proj.bin");
                		ObjectOutputStream o = new ObjectOutputStream(f);
                		o.writeObject(figs);
                		o.flush();
                		o.close();                		
                	}
                	catch (Exception x) {
                		System.out.println("ERRO AO SALVAR");
                	}               	
                    System.exit(0);
                }
            }
        );
        //inicializando a lista de botoes
        buts.add(new Button(1, new Ellipse(20, 130, 35, 35, Color.BLACK, Color.BLACK)));        
        buts.add(new Button(2, new Rect(20, 85, 35, 35, Color.BLACK, Color.BLACK)));
        buts.add(new Button(3, new Triangle(20, 40, 35, 35, Color.BLACK, Color.BLACK)));
        buts.add(new Button(4, new Pentagon(20, 175, 35, 35, Color.BLACK, Color.BLACK)));
                
        this.addMouseListener(
            new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    pMouse = getMousePosition();
                    focus = null;                    
                    //Teste se foi no botão
                    if ((15 <= pMouse.x && pMouse.x <= 60) && (35 <= pMouse.y && pMouse.y <= 215)) {
						focus = null;
        				for (Button butto: buts) {
        					if (butto.clicked(pMouse.x, pMouse.y)) {
        						butfocus = butto;
        					}       				       				
        				}
        				repaint();
        			}
        			//Botão focado, cria a figura
        			else if(butfocus != null) {
        				int idx = butfocus.idx;
        				pMouse = getMousePosition();
		                int x = pMouse.x;
		                int y = pMouse.y;
		                int w = 100;
		                int h = 100;
		                Color contorno = cores[contContorno];
                    	Color fundo = cores[contFundo];  
                    	if (idx == 1) {                  			
                    		figs.add(new Ellipse(x, y, w, h, contorno, fundo));                           
                    	}
                    	else if (idx == 2) {
                    		figs.add(new Rect(x, y, w, h, contorno, fundo));
                    	}
                    	else if (idx == 3) {
                    		figs.add(new Triangle(x, y, w, h, contorno, fundo));
                    	}
                    	else {
                    		figs.add(new Pentagon(x, y, w, h, contorno, fundo));
                    	}
                    	focus = figs.get(figs.size()-1);
                    	butfocus = null;        				
        			}
        			//Teste se foi na figura
        			else {
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
                    
                    //Troca de cores
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
                    
                    //Redimensionamento das figuras                    
                    else if (e.getKeyChar() == 'd' ) {
						//aumenta largura w da figura
						focus.w += 10; 
						focus = figs.get(figs.size()-1);
                    }
                    else if (e.getKeyChar() == 'a' ) {
                    	//diminui largura w da figura
                    	focus.w -= 10; 
						focus = figs.get(figs.size()-1);
                    }
                    else if (e.getKeyChar() == 's' ) {
						//aumenta altura h da figura
						focus.h += 10; 
						focus = figs.get(figs.size()-1);
                    }
                    else if (e.getKeyChar() == 'w' ) {
						//diminui altura h da figura
						focus.h -= 10; 
						focus = figs.get(figs.size()-1);
                    }
                    
                    //Deletar a figura em foco
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
            figo.paint(g, true);
        }
        for (Button butto: buts) {
        	butto.paint(g, butto == butfocus);
        }        
        if (focus != null) {
            focus.drawBorder(g, false);
        }
    }
}
