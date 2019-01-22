
public class Battle {

	/**
	 * this is the class where the battle related events will occur
	 * Methods needed:
	 * Do Battle
	 * Checkhp
	 * Weakness calculation
	 * Remove pieces
	 * 
	 */
	
	private  Pokemon pieceOne;
	private  Pokemon pieceTwo;
	
	
	/**
	 * / this method will create new battles between pieces
	 * p1 is player one's pokemon
	 * p2 is player two's pokemon
	 * 
	 * this will be used within runBattle under Class GameScreen
	 */
	
	/*
	 * battle constructor, the two pokemon that are battling for a square as parameters
	 * assigns them to variables of this class
	 */
	public Battle(Pokemon firstPkmn, Pokemon secondPkmn) {// creates the battle event
		this.pieceOne = firstPkmn;
		this.pieceTwo = secondPkmn;
	}
	
	
	/*
	 * runs the battles between pokemon in the event of collision
	 * 
	 * returns a 1 value when a battle is won by the player
	 * returns a 2 when the battle is lost by a player
	 */
	 public int doBattle() {
	        
	        System.out.println(String.format("Begin Battle: %s vs. %s!", pieceOne.getName(), pieceTwo.getName()));
	        System.out.println();
	        
	        // the Pokemon attack each other until one of their HP are depleted
	        while (pieceOne.getHP() > 0) {
	        	pieceOne. Battleattack(pieceTwo , pieceOne); // passing the other pokemon on as a parameter so that we can access both weaknesses
	            if (pieceTwo.getHP() > 0 ) {
	            	pieceTwo. Battleattack(pieceOne, pieceTwo);
	            } else {
	                // p2's HP is at 0
	                System.out.println(String.format("The winner is %s!", pieceOne.getName()));
	                System.out.println();
	                
	                
	                // return a one to the program, to signify that player one was successful in winning
	                return 1;
	            }
	        }
	        
	        
	        // p1's HP is at 0
	        System.out.println(String.format("The winner is %s!", pieceTwo.getName()));
	        
	        // return 2 since the ai was successful in winning
	        return 2;
	        
	    }
	
	 
	 
}
