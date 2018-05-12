import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Game extends JPanel {

	Timer t = new Timer(2, new Listener());
	public int i; 
	public int j;
	public int lado = 66;
	public int trocaCor = 1;
	
	public int pecax = lado/2 + 5*lado;
	public int pecay = lado/2 + 7*lado;
	
	public Game(){
		super();
		t.start();
		addKeyListener(new Key());
		setFocusable(true);
		
		
	}
	
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			repaint();
		}
	}
		
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		setBackground(Color.GRAY);
		
		for(i=0; i<8; i++){
			for(j=0; j<8; j++) {
				if (trocaCor == 1){
					g.setColor(Color.WHITE);
				}
				else if(trocaCor == -1){
					g.setColor(Color.BLACK);
					
				}
				g.fillRect(j*lado, i*lado, lado, lado);
				trocaCor *= -1;
			}	
			trocaCor *= -1;
			
		}
		i=0;
		j=0;
		g.setColor(Color.BLUE);
		g.fillRect(pecax-10, pecay-10, 20, 20);
		
	}
	
	private class Key extends KeyAdapter {
		public void keyPressed(KeyEvent e){
			if(e.getKeyCode() == KeyEvent.VK_DOWN){
				trocaCor *= -1;
			}
			if(e.getKeyCode() == KeyEvent.VK_LEFT){
			}
			if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			}
			if(e.getKeyCode() == KeyEvent.VK_S){
			}
			if(e.getKeyCode() == KeyEvent.VK_A){
			}
		}
		public void keyReleased(KeyEvent e){
			
			if(e.getKeyCode() == KeyEvent.VK_LEFT){
				
			}
			if(e.getKeyCode() == KeyEvent.VK_RIGHT){
				
			}
		}
	}
	
	
	
	public static void main (String args[]){
		JFrame frame = new JFrame();
		frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Game panel = new Game();
		frame.add(panel);
		frame.setVisible(true);
	}
}
	
	
	
	
	
	
	
