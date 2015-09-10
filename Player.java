public class Player{

	private String playerType;
	private int hp;
	private int energy;
	private int luck;
	private boolean hasWeapon = true;
	private ArrayList<String> inventory = new ArrayList<String>();

	//...getters n' setters

	public String getPlayerType(){
		return this.playerType;
	}

	public int getHp(){
		return this.hp;
	}

	public int getEnergy(){
		return this.energy;
	}

	public int getLuck(){
		return this.Luck;
	}

	public void setHp(int hp){
		this.hp = hp;
	}

	public void setEnergy(int nrg){
		this.energy = nrg;
	}

	public void setLuck(int luckyDuck){
		this.luck = luckyDuck;
	}

	public void listInventory(){	

		for(String s : inventory){
			System.out.println(s);
		}	
	}
	
	public void giveWeapon(String weapon){
		this.hasWeapon = true;
		this.inventory.add(weapon);
	}

	public void addItem(String str){
		this.inventory.add(str);
		this.energy = this.energy -10;//more items is more weight
	}

	
	Player(String type){

		this.playerType = playerType;

		switch(playerType){
		case "Warrior" : this.playerType="Warrior".this.hp = 100.this.energy = 50.this.luck = 50.inventory.add(War Hammer); break;
		case "Mage" : this.playerType = "Mage".this.hp = 80.this.energy = 80.this.luck = 75.inventory.add(Staff); break;
		case "Ninja" : this.playerType = "Ninja".this.hp = 90.this.energy = 100.this.luck = 50.inventory.add(Throwing Star); break;
		case "Athlete" : this.playerType = "Athlete".this.hp = 80.this.energy = 100.this.luck = 50.inventory.add(Knife); break;
		default : this.playerType = "Wanderer".this.hp = 50.this.energy = 50.this.luck = 50.inventory.add(Spoon); break;

		}


	}


}
