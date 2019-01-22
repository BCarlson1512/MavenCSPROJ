import javax.swing.ImageIcon;

public class GrassPokemon extends Pokemon{ // these are just placeholder names until we decide on types
	
	/*
	 * Constructor for the base grasspokemon object
	 * Parameters: 
	 * Name - the name of the pokemon
	 * Art - the art that will be displayed on the board
	 * 
	 * hp - User inputs the base hp
	 * attack - user inputs the base attack
	 * 
	 * Stores base parameters forresistance and weakness
	 */
	
	public GrassPokemon(String name, int hp, int cp, ImageIcon art) {
		this.name = name;
		this.hp = hp;
		this.Attack = cp;
		this.Resistance = "Water";
		this.Type = "Grass";
		this.Weakness = "Fire";
		this.art = art;
	}
	
	/*
	 * Constructor for the base grasspokemon object
	 * Parameters: 
	 * Name - the name of the pokemon
	 * Art - the art that will be displayed on the board
	 * 
	 * Stores base parameters for hp, attack, resistance and weakness
	 */
	
	public GrassPokemon(String name, ImageIcon art) {
		this.name = name;
		this.hp = 150;
		this.Attack = 10;
		this.Resistance = "Water";
		this.Type = "Grass";
		this.Weakness = "Fire";
		this.art = art;
	}
	
	/*
	 * Gets the attack from the pokemon object
	 * 
	 * returns an integer value for the attack
	 */
	public int getAttack(){
		return Attack;
	}
	/*
	 * Gets the hp from the pokemon object
	 * 
	 * returns an integer value for the hp
	 */
	public int getHP() {
		return hp;
	}
	
	/*
	 * Gets the type from the pokemon object
	 * 
	 * returns an String value for the type, currently only grass, water or fire
	 */
	public String getType() {
		return Type;
	}
	/*
	 * Gets the weakness from the pokemon object
	 * 
	 * returns an String value for the weakness, currently only grass, water or fire
	 */
	public String getWeakness() {
		//System.out.println(Weakness);
		return Weakness;
	}
	/*
	 * Gets the resistance from the pokemon object
	 * 
	 * returns an String value for the resistance, currently only grass, water or fire
	 */
	public String getResistance() {
		return Resistance;
	}
}
