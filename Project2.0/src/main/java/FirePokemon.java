import javax.swing.ImageIcon;

public class FirePokemon extends Pokemon { // these are just placeholder names until we decide on types

public FirePokemon(String name, int hp, int cp,ImageIcon art) {
	this.name = name;
	this.hp = hp;
	this.Attack = cp;
	this.Resistance = "Grass";
	this.Type = "Fire";
	this.Weakness = "Water";
	this.art = art;
	}
	
	public FirePokemon(String name, ImageIcon art) {
		this.name = name;
		this.hp = 100;
		this.Attack = 25;
		this.Resistance = "Grass";
		this.Type = "Fire";
		this.Weakness = "Water";
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
