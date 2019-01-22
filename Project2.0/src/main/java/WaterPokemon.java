import javax.swing.ImageIcon;

public class WaterPokemon extends Pokemon{// these are just placeholder names until we decide on types
	
	public WaterPokemon(String name, int hp, int cp, ImageIcon art) {
		this.name = name;
		this.hp = hp;
		this.Attack = cp;
		this.Resistance = "Fire";
		this.Type = "Water";
		this.Weakness = "Grass";
		this.art = art;
	}
	
	public WaterPokemon(String name, ImageIcon art) {
		this.name = name;
		this.hp = 125;
		this.Attack = 15;
		this.Resistance = "Fire";
		this.Type = "Water";
		this.Weakness = "Grass";
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
