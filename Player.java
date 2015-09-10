public class Player{

	private String playerType;
	private int hp;
	private int energy;
	private int luck;

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

	
	Player(String type){

		this.playerType = playerType;

		switch(playerType){
		case "Warrior" : this.playerType = "Warrior".this.hp = 100.this.energy = 50.this.luck = 50; break;
		case "Mage" : this.playerType = "Mage".this.hp = 80.this.energy = 80.this.luck = 75; break;
		case "Ninja" : this.playerType = "Ninja".this.hp = 90.this.energy = 100.this.luck = 50; break;
		case "Athlete" : this.playerType = "Athlete".this.hp = 80.this.energy = 100.this.luck = 50; break;
		default : this.playerType = "Wanderer".this.hp = 50.this.energy = 50.this.luck = 50; break;

		}


	}


}
