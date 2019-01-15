

public class Pokemon {

	protected String name;
	protected String Weakness;
	protected String Resistance;
	protected String Type;
	protected int hp;
	protected int Attack;

	/**
	public Pokemon(String name, int hp, int cp) {
		this.name = name;
		this.hp = hp;
		this.Attack = cp;
		
		// null for base pokemon type
		this.Weakness = "";
		this.Resistance = "";
		
	}
	
	public Pokemon(String name) {
		
	}
	**/
	
	public boolean isDead(){ // checks for death, returns
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
	
	
	
}
