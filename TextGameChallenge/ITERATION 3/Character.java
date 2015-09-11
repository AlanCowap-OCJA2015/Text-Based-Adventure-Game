import java.util.HashMap;
import java.util.ArrayList;

abstract class Character{
	protected String name;
	protected int level, XP, HP, MP;
	protected ArrayList<String> bag = new ArrayList<String>();
	protected HashMap stats = new HashMap();


	//Constructors
	public Character(String name){
		this.name = name;
	}


	//Level getters and setters
	public int getLevel(){
		return this.level;
	}

	public void setLevel(int level){
		this.level = level;
	}
	
	//XP getters and setters
	public int getXP(){
		return this.XP;
	}

	public void setXP(int XP){
		this.XP = XP;
	}

	//HP getters and setters
	public int getHP(){
		return this.HP;
	}

	public void setHP(int HP){
		this.HP = HP;
	}

	//MP getters and setters
	public int getMP(){
		return this.MP;
	}

	public void setMP(int MP){
		this.MP = MP;
	}

	//Name getter
	public String getName(){
		return this.name;
	}

	//Stats getter
	public HashMap getStats(){
		return this.stats;
	}
	
}