import javax.swing.ImageIcon;

public class Pokemon {

	protected String name;
	protected String Weakness;
	protected String Resistance;
	protected String Type;
	protected int hp;
	protected int Attack;
	protected ImageIcon art;


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
	
	public int getAttack(){
		return Attack;
	}
	
	public int getHP() {
		return hp;
	}
	
	public String getType() {
		return Type;
	}
	
	/*
	 * modifies the hp of a pokemon only used in the event of a battle
	 * newHP is the hp after each damage phase
	 */
    public void changeHP(int newHP) {
        if (newHP < 0) { // if its less than zero, just round it off at zero
            this.hp = 0;
        } else {
            this.hp = newHP; // set the hp to the newHp variable
        }
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
    
    /*
     * Gathers the string name of the pokemon
     * returns a string of the name
     * 
     */
    public String getName() {
    	return name;
    }
    
    /*
     * Fetches the art stored in the pokemon object
     * returns the imageicon
     */
    
    public ImageIcon getArt() {
    	return art;
    }
    
    /*
     * 
     * Runs the battle between two pokemon
     * 
     * Pokemon m is p1
     * 
     * Pokemon m is the ai pokemon its fighting against
     * 
     * Currently working on a console output
     * 
     */
    
    public void Battleattack(Pokemon p, Pokemon m) { // pokemon m represents the defending pokemon
    	
    	// boosted damage for strengths
    	int boostedDamage = (int) ((1.5 * this.Attack));
    	
    	// reduced damage when attacking resistances
    	int reducedDamage = (int) ((0.75 * this.Attack));
    	
    	// string variables rather than using the getX() method
    	String pType, mType, pWeak, mWeak;
    	pType = p.getType();
    	mType = m.getType();
    	pWeak = p.getWeakness();
    	mWeak = m.getWeakness();

    	
    	/*
    	 * checks for weakness and resistance cases
    	 * 
    	 * Weakness cases:
    	 * 
    	 * Grass attacks water
    	 * Fire attacks grass
    	 * water attacks fire
    	 * 
    	 * Resistance cases are:
    	 * 
    	 * water attacks grass
    	 * grass attacks fire
    	 * fire attacks water
    	 * 
    	 */
    	
    	if(pType.equals("Grass") && mWeak.equals("Water")) { // grass attacking water gets a damage boost
    		
    		p.changeHP(p.getHP() - boostedDamage);
            
            if (p.getHP() < 0 ) {
                p.changeHP(0);

            }
    		
            System.out.println(String.format("*Its Super Effective!* %s attacks %s. %s's hp is now %d.", this.name, p.getName(), p.getName(), p.getHP()));
            
    	}else if (pType.equals("Fire") && mWeak.equals("Grass")) { // fire attacking grass gets a boost
    		
    		p.changeHP(p.getHP() - boostedDamage);
            
            if (p.getHP() < 0 ) {
                p.changeHP(0);
       
            }
    		
            System.out.println(String.format("*Its Super Effective!* %s attacks %s. %s's hp is now %d.", this.name, p.getName(), p.getName(), p.getHP()));
            
    	}else if(pType.equals("Water") && mWeak.equals("Fire")) { // water attacking fire also gets a boost in turn
    		
    		p.changeHP(p.getHP() - boostedDamage);
            
            if (p.getHP() < 0 ) {
                p.changeHP(0);
               
            }
    		
            
            System.out.println(String.format("*Its Super Effective!* %s attacks %s. %s's hp is now %d.", this.name, p.getName(), p.getName(), p.getHP()));
    		
    	}else if((pType.equals("Grass")) && (m.getResistance().equals(pWeak))){// resistance cases case 1: grass type attacks fire:
    		
    		p.changeHP(p.getHP() - reducedDamage);
            
            if (p.getHP() < 0 ) {
                p.changeHP(0);
              
            }
    		
            
            System.out.println(String.format("*Its Super Effective!* %s attacks %s. %s's hp is now %d.", this.name, p.getName(), p.getName(), p.getHP()));
    		
    	}else if((pType.equals("Fire")) && (m.getResistance().equals(pWeak))){// resistance cases case 1: Fire type attacks Water:
    		
    		p.changeHP(p.getHP() - reducedDamage);
            
            if (p.getHP() < 0 ) {
                p.changeHP(0);
              
            }
    		
            
            System.out.println(String.format("*Its Super Effective!* %s attacks %s. %s's hp is now %d.", this.name, p.getName(), p.getName(), p.getHP()));
    		
    	}else if((pType.equals("Water")) && (m.getResistance().equals(pWeak))){// resistance cases case 1: Water type attacks grass:
    		
    		
    		p.changeHP(p.getHP() - reducedDamage);
            
            if (p.getHP() < 0 ) {
                p.changeHP(0);
               
            }
    		
            
            System.out.println(String.format("*Its Super Effective!* %s attacks %s. %s's hp is now %d.", this.name, p.getName(), p.getName(), p.getHP()));
    		
    	}else { // if none of these cases are satisifed, run the default damage case (1x multiplier)
        	
    		p.changeHP(p.getHP() - this.Attack);
            
            if (p.getHP() < 0 ) {
                p.changeHP(0);
             
            }	
    	
            System.out.println(String.format("%s attacks %s. %s's hp is now %d.", this.name, p.getName(), p.getName(), p.getHP()));
    	}
	}
}
