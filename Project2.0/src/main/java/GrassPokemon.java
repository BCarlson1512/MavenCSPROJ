

public class GrassPokemon extends Pokemon{ // these are just placeholder names until we decide on types
	
	public GrassPokemon(String name, int hp, int cp) {
		this.name = name;
		this.hp = hp;
		this.Attack = cp;
		this.Resistance = "Water";
		this.Weakness = "Fire";
	}
	
	public GrassPokemon(String name) {
		this.name = name;
		this.hp = 150;
		this.Attack = 10;
		this.Resistance = "Water";
		this.Weakness = "Fire";
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
		return Weakness;
	}
	
	public String getResistance() {
		return Resistance;
	}
}
