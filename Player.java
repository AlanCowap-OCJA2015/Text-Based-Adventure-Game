import java.util.ArrayList;

class Player{
	private Room currentRoom;
	private ArrayList<Thing> inventory = new ArrayList<Thing>();
	private int loot = 0;
	
	public void setCurrentRoom(Room room){
		this.currentRoom = room;
	}
	public void showLoot(){
		System.out.println(this.loot);
	}
	public void increaseLoot(int amount){
		this.loot += amount;
	}
	public void increaseLoot(String amount){
		try {
			int temp = Integer.parseInt(amount);
			this.loot += temp;
		} catch (Exception e) {

		}
		
	}
	public void look(){
		System.out.println(currentRoom.getRoomName());
		System.out.println(currentRoom.getDescription());
		System.out.println("Exits are ");
		exits();
	}
	public void look(char direction){
		//check if direction has a room (done by room)
		//get the value of that room
		Room tempRoom = currentRoom.getAdjacentRoom(direction);
		//look at the overview for that room
		if(tempRoom != null){
			System.out.println(tempRoom.getRoomName());
			System.out.println(tempRoom.getOverview());
		}else{
			System.out.println("There is notting in this direction");
		}
	}
	public void look(String direction){
		look(direction.charAt(0));
	}
	public void move(char direction){
		if (currentRoom.getAdjacentRoom(direction)!=null){
			currentRoom = currentRoom.getAdjacentRoom(direction);
			currentRoom.getDescription();
		}
		look();
	}
	public void move(String direction){
		move(direction.charAt(0));
	}
	public void move(){
		System.out.println("Move where?");
	}
	public void go(){
		System.out.println("Go where?");
	}
	public void go(char direction){
		move(direction);
	}
	public void go(String direction){
		move(direction.charAt(0));
	}
	public void exits(){
		for (String s: currentRoom.showAdjacent()){
			System.out.println(s.charAt(0));
		}
	}
	
	
}
/*
class Room{
Room getAdjacentRoom(char direction){return null;}
String getOverview(){return "overview";}
String getDescription(){return "description";}
}

class Thing{}
*/
