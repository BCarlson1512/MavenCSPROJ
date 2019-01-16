

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
	
    public void changeHP(int newHP) {
        if (newHP < 0) {
            this.hp = 0;
        } else {
            this.hp = newHP;
        }
    }
	
    
    public String getWeakness(){
    	return Weakness;
    }
    
    public String getName() {
    	return name;
    }
    
	public void Battleattack(Pokemon p, Pokemon m) { // pokemon m represents the defending pokemon
    	int boostedDamage = (int) ((1.5 * this.Attack));
    	
    	
    	if(p.getType().equals("Grass") && m.getWeakness().equals("Water")) { // grass attacking water gets a damage boost
    		
    		p.changeHP(p.getHP() - boostedDamage);
            
            if (p.getHP() < 0 ) {
                p.changeHP(0);
            }
    		
            System.out.println(String.format("*Weakness Advantage!* %s attacks %s. %s's hp is now %d.", this.name, p.getName(), p.getName(), p.getHP()));
            
    	}else if (p.getType().equals("Fire") && m.getWeakness().equals("Grass")) { // fire attacking grass gets a boost
    		
    		p.changeHP(p.getHP() - boostedDamage);
            
            if (p.getHP() < 0 ) {
                p.changeHP(0);
            }
    		
            System.out.println(String.format("*Weakness Advantage!* %s attacks %s. %s's hp is now %d.", this.name, p.getName(), p.getName(), p.getHP()));
            
    	}else if(p.getType().equals("Water") && m.getWeakness().equals("Fire")) { // water attacking fire also gets a boost in turn
    		
    		p.changeHP(p.getHP() - boostedDamage);
            
            if (p.getHP() < 0 ) {
                p.changeHP(0);
            }
    		
            
            System.out.println(String.format("*Weakness Advantage!* %s attacks %s. %s's hp is now %d.", this.name, p.getName(), p.getName(), p.getHP()));
    		
    	}else { // if none of these cases are satisifed, run the default damage case (1x multiplier)
        	
    		p.changeHP(p.getHP() - this.Attack);
            
            if (p.getHP() < 0 ) {
                p.changeHP(0);
            }	
    	
            System.out.println(String.format("%s attacks %s. %s's hp is now %d.", this.name, p.getName(), p.getName(), p.getHP()));
    	}
	}
}
