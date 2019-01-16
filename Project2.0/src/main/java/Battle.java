
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
	
	public Battle(Pokemon firstPkmn, Pokemon secondPkmn) {// creates the battle event
		this.pieceOne = firstPkmn;
		this.pieceTwo = secondPkmn;
	}
	
	 public void doBattle() {
	        
	        System.out.println(String.format("Begin Battle: %s vs. %s!", pieceOne.getName(), pieceTwo.getName()));
	        System.out.println();
	        
	        // the Pokemon attack each other until one of their HP are depleted
	        while (pieceOne.getHP() > 0) {
	        	pieceOne. attack(pieceTwo , pieceOne); // passing the other pokemon on as a parameter so that we can access both weaknesses
	            if (pieceTwo.getHP() > 0 ) {
	            	pieceTwo. attack(pieceOne, pieceTwo);
	            } else {
	                // p2's HP is at 0
	                System.out.println(String.format("The winner is %s!", pieceOne.getName()));
	                System.out.println();
	                return;
	            }
	        }
	        
	        // p1's HP is at 0
	        System.out.println(String.format("The winner is %s!", p2.getName()));
	        System.out.println();
	        
	    }
	
}
