import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.LayoutStyle.ComponentPlacement;


public class GameScreen extends JFrame implements ActionListener{
	private JPanel boardGui  = new JPanel();
	
	private Container boardArea;
	
	// arrays that will be used within the program
    private int[][] boardGrid = new int[5][5];
    private JButton[][] tiles = new JButton[5][5];
    private ImageIcon[][] imageGrid = new ImageIcon[5][5];
    private ImageIcon testIcon = new ImageIcon("image.png");
    ImageIcon pokeball = new ImageIcon("Pokeball.PNG");
    
    // locations of each individual piece, default will be set to the top middle three squares and bottom middle three squares
    private int P1xLoc1 = 1;
    private int P1xLoc2 = 2;
    private int P1xLoc3 = 3;
    
    private int P1yLoc1 = 0;
    private int P1yLoc2 = 0;
    private int P1yLoc3 = 0;
    
    
    // same applies for player 2
    private int P2xLoc1 = 1;
    private int P2xLoc2 = 2;
    private int P2xLoc3 = 3;
    
    private int P2yLoc1 = 6;
    private int P2yLoc2 = 6;
    private int P2yLoc3 = 6;

    
    ButtonHandler clickHandler = new ButtonHandler();
    
	public GameScreen() { // constructor that creates the board
		
		boardArea = getContentPane();
		boardArea.setLayout(new GridLayout(5,5));
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {

				tiles[i][j] = new JButton();
				tiles[i][j].addActionListener(clickHandler);;
				this.add(tiles[i][j]);
			}
		}
		
		
		for(int i = 0; i <=3; i++) { // set icons for future pieces
			tiles[0][i + 1].setIcon(pokeball);
			tiles[6][i + 1].setIcon(pokeball);
		}
		

		
		 //... 
		
		
	}	// this is the place where the game will be played, this gui element just has to be called on by main

	public void movePiece(int x, int y) {
		
	}
	
	private class ButtonHandler implements ActionListener{
		
		public void ActionPerformed(ActionEvent e) {
			Object src = e.getSource();
			
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 5; j++) {
					if(src == tiles[i][j]) {
						
						movePiece(i,j);
						return;
					}

				}
			}
			
		}
		
	}
	

	
	public void updateVisuals() { // will update the graphics when a change is made
		
	}
}


