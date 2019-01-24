import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.LayoutStyle.ComponentPlacement;


public class GameScreen extends JFrame implements ActionListener{
	
	// create a container that we can add our gridlayout to
	private Container boardArea;
	
	
	// we need an instance of main to get the variable playerchoice
	main Main = new main();
	int pChoice = main.playerChoice;
	
	// arrays that will be used within the program
    private int[][] boardGrid = new int[5][5];
    private JButton[][] tiles = new JButton[5][5];
  
    // image of enemies
    ImageIcon pokeball = new ImageIcon("Pokeball.PNG");
    
    // default background color
    Color olive = new Color(29,33,13);
    

    
    // Art for the pokemon
    ImageIcon OrihavocArt = new ImageIcon("havoc sprite.png");
    ImageIcon OrielementArt = new ImageIcon("element sprite.png");
    ImageIcon OrilapisArt = new ImageIcon("lapis sprite.png");
    ImageIcon OriplexiArt = new ImageIcon("plexi sprite.png");
    ImageIcon OrivirusArt = new ImageIcon("virus sprite.png");
    
    Image imghavoc=OrihavocArt.getImage();
    Image imgelement=OrielementArt.getImage();
    Image imglapis=OrilapisArt.getImage();
    Image imgplexi=OriplexiArt.getImage();
    Image imgvirus=OrivirusArt.getImage();
    
    Image newinghavoc = imghavoc.getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ) ;
    Image newingelement = imgelement.getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ) ;
    Image newinglapis = imglapis.getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ) ;
    Image newingplexi = imgplexi.getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ) ;
    Image newingvirus = imgvirus.getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ) ;
    
    ImageIcon havocArt = new ImageIcon(newinghavoc);
    ImageIcon elementArt = new ImageIcon(newingelement);
    ImageIcon lapisArt = new ImageIcon(newinglapis);
    ImageIcon plexiArt = new ImageIcon(newingplexi);
    ImageIcon virusArt = new ImageIcon(newingvirus);
    

    // create a new instance of random to be used in enemy spawning below
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
    
    // locations for pokemon 3
    private int P2yLoc3;
    private int P2xLoc3;

    // the five base pokemon to be used within this game
    Pokemon p1 = new GrassPokemon("lapis", lapisArt);
    Pokemon p2 = new WaterPokemon("element", elementArt);
    Pokemon p3 = new FirePokemon("havoc", havocArt);
    Pokemon p4 = new GrassPokemon("plexi", plexiArt);
    Pokemon p5 = new WaterPokemon("virus", virusArt);
    
    
    // Custom event handler for button clicks
    ButtonHandler clickHandler = new ButtonHandler();
    
	public GameScreen() { // constructor that creates the board


		// location of all system files
		//System.out.println(System.getProperty("user.dir"));
		
		// get the content pane and then add a 5x5 grid layout
		boardArea = getContentPane();
		boardArea.setLayout(new GridLayout(5,5));
		
		
		// initialize the button array
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
		
		numPokemon++;
		
		P2xLoc3 = r.nextInt(4) + 1;
		P2yLoc3 = r.nextInt(4) + 1;
		
		numPokemon++; // Tell the game that there is another pokemon on the field
		
		if((P2xLoc1 == P2xLoc2) && (P2yLoc1 == P2yLoc2)) {// re roll the x and y values if they are duplicates
			P2xLoc1 = r.nextInt(4);
			
		}else if((P2xLoc1 == P2xLoc3) && (P2yLoc1 == P2yLoc3)) { // re roll conditions for pokemon 3
			P2xLoc1 = r.nextInt(4);
		
		}else if((P2xLoc2 == P2xLoc3) && (P2yLoc2 == P2yLoc3)) {
			P2xLoc2 = r.nextInt(4);
		}
	
		// Case statement for when the player chooses a piece
		
		/**
		 * Cases as follows:
		 * 
		 * player chooses pokemon 1 = grab art for lapis
		 * player chooses pokemon 2 = grab art for element
		 * player chooses pokemon 3 = grab art for havoc
		 * player chooses pokemon 4 = grab art for plexi
		 * player chooses pokemon 5 = grab art for virus
		 * 
		 * default case = lapis 
		 */
		
		
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
		
		
		boardGrid[P1xLoc1][P1yLoc1] = 1; // tell the game that a player has spawned in at 
		
		

		// set locations of the icons and integer array locations
		tiles[P2xLoc1][P2yLoc1].setIcon(pokeball);
		boardGrid[P2xLoc1][P2yLoc1] = 1;
		tiles[P2xLoc2][P2yLoc2].setIcon(pokeball);
		boardGrid[P2xLoc2][P2yLoc2] = 1;
		
		tiles[P2xLoc3][P2yLoc3].setIcon(pokeball);
		boardGrid[P2xLoc3][P2yLoc3] = 1;

	}	// this is the place where the game will be played, this gui element just has to be called on by main

	/*
	 * check to see if two players have collided
	 * 
	 * Int x is the x coordinate of the tile being checked
	 * Int y is the y coordinate of the tile being checked
	 * 
	 * return false if there is no collision
	 * 
	 * return true when a collision between two players has occured
	 */
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

	/*
	 * Checks to see if the player's move is valid
	 * 
	 * Take x coordinate as int x
	 * 
	 * Takes y as the y coordinate being checked
	 * 
	 * Makes sure that the piece can move correctly.
	 * 
	 * Existing bug where the player can also move in an L shape
	 * 
	 * Update bug fixed
	 */
	
	public boolean validMove(int x, int y) {
		int rowDiff = Math.abs(x - P1xLoc1);
		int colDiff = Math.abs(y - P1yLoc1);
		
		System.out.println(rowDiff);
		System.out.println(colDiff);
		
		
		// rengineered conditional fixes the l shape movement bug
		
		if((rowDiff > 1 )) { // horizontal movement
			return false;
		}else if((rowDiff > 1 ) && (colDiff > 1)) { // diagonal movement
			return false;
		}else if((colDiff > 1)) { // vertical movement
			return false;
		}else {
			return true;
		}
		
	}

	/*
	 * Moves the player's piece
	 * 
	 * Take x coordinate as int x
	 * 
	 * Takes y as the y coordinate being checked
	 * 
	 * When a valid move is deteced and it is collision free,
	 * 
	 * Existing bug where the player can also move in an L shape
	 */
	
	public void movePiece(int x, int y) throws InterruptedException {
		// check for validity in moves
		
		//System.out.println(validMove(x,y));
		
		boolean moveCheck = validMove(x,y);
		boolean collisionCheck = checkCollision(x,y);
		
		if(moveCheck == false) {
			return;
		}
		
		if((moveCheck == true) && (collisionCheck == true)) {
			runBattle(x, y); // run the battle simulation between two pieces
		}
		
		if((moveCheck == true) && (collisionCheck == false)) {
			
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
	/*
	 * 
	 * Int x is the x coordinate
	 * Int y is the y coordinate
	 * 
	 * Removes the piece from the game at coordinates provided
	 * 
	 */
	public void removePiece(int x, int y) { 
		// removes the piece art and removes the piece from the game
		// used when a battle is won/lost
		
		tiles[x][y].setIcon(null);
		boardGrid[x][y] = boardGrid[x][y] - 1;
		
	}
	

	/*
	 * runs a battle created from the battle class and coordinates x and y
	 */
	
	public void runBattle(int x, int y) throws InterruptedException {
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
	
	/*
	 * 
	 * Once an endgame condtion is met, the game is reset for the next iteration
	 * 
	 */
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
	
	/*
	 * 
	 * This is the custom actionlistener class for button clicks
	 * 
	 */
	
	private class ButtonHandler implements ActionListener{ // handles any button click
		
		/*
		 * 
		 * Handles all of the button clicks, taking an event at locaton e.
		 * 
		 */
		
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource(); // get where the user clicks from
			
			for(int i = 0; i < 5; i++) { // find the tile where the click was made
				for(int j = 0; j < 5; j++) {
					if(src == tiles[i][j]) {
						
                                            try {
                                                movePiece(i,j); // pass it to the movepiece function
                                            } catch (InterruptedException ex) {
                                                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
                                            }
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


