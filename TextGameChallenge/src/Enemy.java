class Enemy{
	private String name, loot;
	private int HP, XP, attack, fightNumber;

	public Enemy(int HP, int XP, int attack, String name, String loot, int fightNumber){
		this.XP = XP;
		this.HP = HP;
		this.attack = attack;
		this.loot = loot;
		this.name = name;
	}

	public String toString(){
		return "Name: " + this.name + ", HP: " + this.HP
			+ ", XP: " + this.XP + ", Attack: " 
			+ this.attack + ", Loot: " + this.loot;
	}


	public String getName(){
		return this.name;
	}

	public int getNum(){
		return this.fightNumber;
	}
}