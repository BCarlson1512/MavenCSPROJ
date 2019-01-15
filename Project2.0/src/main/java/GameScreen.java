import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.LayoutStyle.ComponentPlacement;


public class GameScreen extends JFrame {
	private JPanel boardGui  = new JPanel();
	
	private Container boardArea;
	
	// arrays that will be used within the program
    private int[][] boardGrid = new int[5][5];
    private JButton[][] tiles = new JButton[5][5];
    private ImageIcon[][] imageGrid = new ImageIcon[5][5];
    private ImageIcon testIcon = new ImageIcon("image.png");
    
    

    
	public GameScreen() { // constructor that creates the board
		
		boardArea = getContentPane();
		boardArea.setLayout(new GridLayout(5,5));
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {

				tiles[i][j] = new JButton();
				
				this.add(tiles[i][j]);
			}
		}
		
		
		
		
	}	// this is the place where the game will be played, this gui element just has to be called on by main

	
	

	
	public void updateVisuals() { // will update the graphics when a change is made
		
	}
}


