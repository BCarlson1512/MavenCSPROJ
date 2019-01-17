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
	
	public boolean isDead(){
		int hp = getHP();
		
		if(hp < 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public int getAttack(){
		return Attack;
	}
	
	public int getHP() {
		return hp;
	}
	
	
	public String getType() {
		return Type;
	}
	
	public String getWeakness() {
		System.out.println(Weakness);
		return Weakness;
	}
	
	public String getResistance() {
		return Resistance;
	}
}
