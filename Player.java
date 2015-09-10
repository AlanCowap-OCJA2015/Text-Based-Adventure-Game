//represents player with his stats
//strength is power of attack and health at same time
//dexterity is chance to inflict damage and dodge damage at same time

public class Player {
	private String name;
	private int strength;
	private int dexterity;
	
	public Player () {
		setStr(0);
		setDex(0);
		setName("unknown");
	}

	public Player (int str, int dex, String name) {
		setStr(str);
		setDex(dex);
		setName(name);
	}

	public int getStr(){
		return this.strength;
	}

	public void setStr(int newStr){
		this.strength = newStr;
	}

	public int getDex(){
		return this.strength;
	}

	public void setDex(int newDex){
		this.dexterity = newDex;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String newName){
		this.name = newName;
	}


	public String toString(){
		return this.getName() + " - Strength: " + this.getStr() + ", Dexterity: " + this.getDex();
	}
}
