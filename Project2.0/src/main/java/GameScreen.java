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
    
    private int P2yLoc1 = 4;
    private int P2yLoc2 = 4;
    private int P2yLoc3 = 4;

    Pokemon p1 = new GrassPokemon("Ivysaur", 10 , 10);
    Pokemon p2 = new WaterPokemon("Mudkip", 5 , 5 );
    
    ButtonHandler clickHandler = new ButtonHandler();
    
	public GameScreen() { // constructor that creates the board
		
		System.out.println(System.getProperty("user.dir"));
		
		boardArea = getContentPane();
		boardArea.setLayout(new GridLayout(5,5));
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {

				tiles[i][j] = new JButton();
				tiles[i][j].addActionListener(clickHandler);;
				this.add(tiles[i][j]);
			}
		}
		
		// locations of the players pieces
		
		tiles[P1xLoc1][P1yLoc1].setIcon(pokeball);
		boardGrid[P1xLoc1][P1yLoc1] = 1;
		//tiles[P1xLoc2][P1yLoc2].setIcon(pokeball);
		//tiles[P1xLoc3][P1yLoc3].setIcon(pokeball);
		
		tiles[P2xLoc1][P2yLoc1].setIcon(pokeball);
		boardGrid[P2xLoc1][P2yLoc1] = 1;
		//tiles[P2xLoc2][P2yLoc2].setIcon(pokeball);
		//tiles[P2xLoc3][P2yLoc3].setIcon(pokeball);

		
		 //... 
		
		
	}	// this is the place where the game will be played, this gui element just has to be called on by main

	public boolean checkCollision(int x, int y) { // this checks to see if two players are about to enter battle
		for(int i = 0; i <= 4; i++) {
			
			for(int j = 0; i <= 4; j++) {
				System.out.println(boardGrid[x][y]);
				if(boardGrid[x][y] == 0) { // unoccupied tile/only a single piece, nothing happens here
					return false;
				}
				
				if(boardGrid[x][y] == 1) { // Two pieces on the tile start the battle
					return true;
				}
				

				
			}
		}
		
		return false;
	}
	

	
	public boolean validMove(int x, int y) {
		int rowDiff = Math.abs(x - P1xLoc1);
		int colDiff = Math.abs(y - P1yLoc1);
		
		if((rowDiff == 1 ) || (colDiff == 1)) { // horizontal and vertical movement
			return true;
		} 
		
		if((rowDiff == 1 ) && (colDiff == 1)) { // diagonal movement
			return true;
		}
		
		return false;
		
	}
	
	public void movePiece(int x, int y, int piecenum) {
		// check for validity in moves
		
		//System.out.println(validMove(x,y));
		
		if(validMove(x, y) == false) {
			return;
		}
		
		if((validMove(x, y) == true) && (checkCollision(x,y) == true)) {
			runBattle(); // run the battle simulation between two pieces
		}
		
		if((validMove(x, y) == true) && (checkCollision(x,y) == false)) {
			
			boardGrid[P1xLoc1][P1yLoc1] = 0;
			
			boardGrid[x][y] = boardGrid[x][y] + 1; // add a number to the code version of the grid
			
			System.out.println(Arrays.deepToString(boardGrid));
			// remove the piece from the other zone
			
			tiles[P1xLoc1][P1yLoc1].setIcon(null); // remove the existing icon
			tiles[x][y].setIcon(pokeball);
			
			
			// reset the location of the piece
			P1xLoc1 = x;
			P1yLoc1 = y;
		}

	}
	
	public void runBattle() {
		System.out.println("Loading Battle.. \n"); // testing first
		Battle contestedPoint = new Battle(p1, p2);
		contestedPoint.doBattle();
		
	}
	
	public void endGame() { // Closes the game screen, shows game over window

		for(int i = 0; i < 4; i++) {
			
			for(int j = 0; j < 4; j++) {
				
			boardGrid[i][j] = 0; // reset the games grid
			tiles[i][j].setIcon(null); // set the icons to nothing
				
			}
		}
		
		GameOverScreen gameOver = new GameOverScreen();
		
		gameOver.setBounds(200, 200, 450, 450); // open the game over window
		gameOver.setVisible(true);
		
		
		dispose(); // delete the game screen window
		
	}
	
	private class ButtonHandler implements ActionListener{ // handles any button click
		
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource(); // get where the user clicks from
			
			for(int i = 0; i < 5; i++) { // find the tile where the click was made
				for(int j = 0; j < 5; j++) {
					if(src == tiles[i][j]) {
						
						movePiece(i,j,0); // pass it to the movepiece function
						return; // stop running the loops after its been found
					}

				}
			}
			
		}
	
	}
	


	public void actionPerformed(ActionEvent e) { // to avoid errors, blank action peformed for the top class
		// TODO Auto-generated method stub
		
	}
}


