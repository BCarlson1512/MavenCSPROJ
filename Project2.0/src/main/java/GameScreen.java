import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.LayoutStyle.ComponentPlacement;


public class GameScreen extends JFrame implements ActionListener{
	private JPanel boardGui  = new JPanel();
	
	private Container boardArea;
	
	main Main = new main();
	int pChoice = main.playerChoice;
	
	// arrays that will be used within the program
    private int[][] boardGrid = new int[5][5];
    private JButton[][] tiles = new JButton[5][5];
    ImageIcon pokeball = new ImageIcon("Pokeball.PNG");
    Color olive = new Color(29,33,13);
    

    
    // Art for the pokemon
    
    ImageIcon elementArt = new ImageIcon("element sprite.png");
    ImageIcon havocArt = new ImageIcon("havoc sprite.png");
    ImageIcon lapisArt = new ImageIcon("lapis sprite.png");
    ImageIcon plexiArt = new ImageIcon("plexi sprite.png");
    ImageIcon virusArt = new ImageIcon("virus sprite.png");
    
    Random r = new Random();
    
    // locations of each individual piece, default will be set to the top middle three squares and bottom middle three squares
    private int P1xLoc1 = 1;
    private int P1yLoc1 = 0;
    private int numPokemon = 0; // number of non player controlled pokemon
    
    // same applies for player 2
    private int P2xLoc1;
    private int P2xLoc2;
    private int P2yLoc1;
    private int P2yLoc2;


    Pokemon p1 = new GrassPokemon("lapis", lapisArt);
    Pokemon p2 = new WaterPokemon("element", elementArt);
    Pokemon p3 = new FirePokemon("havoc", havocArt);
    Pokemon p4 = new GrassPokemon("plexi", plexiArt);
    Pokemon p5 = new WaterPokemon("virus", virusArt);
    
    ButtonHandler clickHandler = new ButtonHandler();
    
	public GameScreen() { // constructor that creates the board


		
		System.out.println(System.getProperty("user.dir"));
		
		boardArea = getContentPane();
		boardArea.setLayout(new GridLayout(5,5));
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {

				tiles[i][j] = new JButton();
				tiles[i][j].addActionListener(clickHandler);
				tiles[i][j].setBackground(olive);;
				this.add(tiles[i][j]);
			}
		}
		
		// randomize the locations of the x and y locations of the players that need to be eliminated
		P2xLoc1 = r.nextInt(4);
		P2xLoc2 = r.nextInt(4);
	
		numPokemon++; // Tell the game that there is another pokemon on the field
		
		P2yLoc2 = r.nextInt(4) + 1;
		P2yLoc1 = r.nextInt(4) + 1;
		
		numPokemon++; // Tell the game that there is another pokemon on the field
		
		if((P2xLoc1 == P2xLoc2) && (P2yLoc1 == P2yLoc2)) {// re roll the x and y values if they are duplicates
			P2xLoc1 = r.nextInt(4);
			
		}
	
		// Case statement for when the player chooses a piece
		
		
		//tiles[P1xLoc1][P1yLoc1].setIcon(lapisArt);
		
		switch(pChoice) { // get the art and data for the player's choice of pokemon
		case 1: pChoice = 1;
		
			tiles[P1xLoc1][P1yLoc1].setIcon(lapisArt);
			
			break;
		case 2: pChoice = 2;
		
			tiles[P1xLoc1][P1yLoc1].setIcon(elementArt);
			
			break;
		case 3: pChoice = 3;
		
			tiles[P1xLoc1][P1yLoc1].setIcon(havocArt);
			
			break;
		case 4: pChoice = 4;
		
			tiles[P1xLoc1][P1yLoc1].setIcon(plexiArt);
			
			break;
			
		case 5: pChoice = 5;
			tiles[P1xLoc1][P1yLoc1].setIcon(virusArt);
			
			break;
		case 6: pChoice = 0; // default to pokemon 1
			tiles[P1xLoc1][P1yLoc1].setIcon(lapisArt);
			
			break;
		}
		
		
		boardGrid[P1xLoc1][P1yLoc1] = 1; // tell the game that a player has spawned in
		
		
		//tiles[P1xLoc1][P1yLoc1].setIcon(p1.getArt());
		//boardGrid[P1xLoc1][P1yLoc1] = 1;

		// set locations of the icons and integer array locations
		tiles[P2xLoc1][P2yLoc1].setIcon(pokeball);
		boardGrid[P2xLoc1][P2yLoc1] = 1;
		tiles[P2xLoc2][P2yLoc2].setIcon(pokeball);
		boardGrid[P2xLoc2][P2yLoc2] = 1;
		//tiles[P2xLoc3][P2yLoc3].setIcon(pokeball);

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

	public void movePiece(int x, int y) {
		// check for validity in moves
		
		//System.out.println(validMove(x,y));
		
		if(validMove(x, y) == false) {
			return;
		}
		
		if((validMove(x, y) == true) && (checkCollision(x,y) == true)) {
			runBattle(x, y); // run the battle simulation between two pieces
		}
		
		if((validMove(x, y) == true) && (checkCollision(x,y) == false)) {
			
			boardGrid[P1xLoc1][P1yLoc1] = 0;
			
			boardGrid[x][y] = boardGrid[x][y] + 1; // add a number to the code version of the grid
			
			
			
			System.out.println(Arrays.deepToString(boardGrid));
			// remove the piece from the other zone
			
			tiles[P1xLoc1][P1yLoc1].setIcon(null); // remove the existing icon
			//tiles[x][y].setIcon(p1.getArt());
			
			switch(pChoice) { // get the art and data for the player's choice of pokemon
			case 1: pChoice = 1;
			
				tiles[x][y].setIcon(p1.getArt());
				
				break;
			case 2: pChoice = 2;
			
				tiles[x][y].setIcon(p2.getArt());
				
				break;
			case 3: pChoice = 3;
			
				tiles[x][y].setIcon(p3.getArt());
				
				break;
			case 4: pChoice = 4;
			
				tiles[x][y].setIcon(p4.getArt());
				
				break;
				
			case 5: pChoice = 5;
				tiles[x][y].setIcon(p5.getArt());
				
				break;
			case 6: pChoice = 0; // default to pokemon 1
				tiles[x][y].setIcon(p1.getArt());
				
				break;
			}
			
			// reset the location of the piece
			P1xLoc1 = x;
			P1yLoc1 = y;
		}

	}
	
	public void removePiece(int x, int y) { 
		// removes the piece art and removes the piece from the game
		// used when a battle is won/lost
		
		tiles[x][y].setIcon(virusArt);
		boardGrid[x][y] = boardGrid[x][y] - 1;
		
	}
	
	public void runBattle(int x, int y) {
		System.out.println("Loading Battle.. \n"); // testing first
		Battle contestedPoint = new Battle(p1, p2);
		//contestedPoint.doBattle();

		if(contestedPoint.doBattle() == 1) { // p1 wins the fight
			removePiece(x , y);
			numPokemon--;
			
			if(numPokemon == 0) { // no pokemon on the field triggers and end game
				endGame();
			}
			
		}else if((contestedPoint.doBattle() == 2) ||(numPokemon == 0)) { // p2 wins the fight, or there are no AI pokemon on the field
			
			endGame(); // end the game
		}
		
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
						
						movePiece(i,j); // pass it to the movepiece function
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


