import java.util.ArrayList;
import java.lang.Character;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.regex.Pattern;

public class Room{
	
	private String roomNumber;
	private String roomName;
	private String overview;
	private String description;
	
	private ArrayList <Room> adjacentRooms = new ArrayList<Room>(); // to be assigned on second file load
	private ArrayList <String> stringAdjacentRooms;
	private ArrayList <String> thingsInRoom;
	
	Room(){ // blank default constructor to be used if needed
		
	}
	
	Room(String roomNumber, String roomName, String description, String overview, ArrayList <String> thingsInRoom, ArrayList <String> stringAdjacentRooms){
		this.roomNumber = roomNumber;
		this.roomName = roomName;
		this.overview = overview;
		this.description = description;
		this.thingsInRoom = thingsInRoom;
		this.stringAdjacentRooms = stringAdjacentRooms;
		
	}
	
	
	public String getRoomName(){
		return this.roomName;
	}
	public String lookAtThing(Thing thing){
		
		return thing.getThingDiscription();
		
	}
	public ArrayList<String> showAdjacent(){
		return stringAdjacentRooms;
	}
	public Room getAdjacentRoom(char direction){
		
		direction = Character.toLowerCase(direction); //make sure char is lower case
		
		for (int i=0; i<stringAdjacentRooms.size(); ++i){
			
			if (stringAdjacentRooms.get(i).charAt(0) == direction){ //check the what direction is picked and return the room
				
				return adjacentRooms.get(i);
				
			} 
			
		}
		return null;

	}
	
	public String getOverview(){
		
		return this.overview;
		
	}
	
	public String getDescription(){
		
		return this.description;
	}
	
	public void setAdjacentRooms(ArrayList <Room> adjacentRooms){
		this.adjacentRooms = adjacentRooms;
		
	}
	public void addAdjacentRoom(Room adjacentRoom){
		adjacentRooms.add(adjacentRoom) ;
		
	}
	
	public String getRoomNumber(){
		return this.roomNumber;
		
	}
	
	
	
}

class Thing{
	int thingNumber;
	String description;
	
	Thing(){
		
	}
	
	
	public String getThingDiscription(){
		return this.description;
	}
	
	public int getThingNumber(){
		
		return this.thingNumber;
		
	}
	
}

//import java.util.ArrayList; temp comment

class FileLoader{
	
	static ArrayList <Room> tempRoomArray = new ArrayList <Room>(); //all rooms stored here, add to menu later
	
	public static ArrayList<Room> load(){
		
		
		File file = new File("RoomDescriptions.txt");
		Scanner scan = null;
		try{
			
			scan = new Scanner(file);//.useDelimiter("~~");
		
			ArrayList <String> tempAdjacentArray;
			ArrayList <String> tempThingsArray; //need to change things constructor!!!!
		
			while(scan.hasNextLine()){
				
			
				tempAdjacentArray = new ArrayList <String>();
				tempThingsArray = new ArrayList <String>();
			
				String roomNumber = scan.nextLine();
				String roomName = scan.nextLine();
				String overview = scan.nextLine();
				String description = scan.nextLine();
			
				while(true){
					
					String temp = scan.nextLine();
					if (temp.startsWith("~~")){
						break;
					} else if (temp.contains("=#")){
						tempAdjacentArray.add(temp);
					} else if (temp.contains("obj")){
						tempThingsArray.add(temp);
					}
										
				}
				
				
				tempRoomArray.add(new Room(roomNumber,roomName,description,overview,tempThingsArray,tempAdjacentArray));
				
			}
		
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(scan !=null){
				scan.close();
			}
			
		}
		for (Room room: tempRoomArray){
			for (String roomNum: room.showAdjacent()){
				for (Room adjacentRoom: tempRoomArray){
					if (roomNum.contains(adjacentRoom.getRoomNumber())){
						room.addAdjacentRoom(adjacentRoom);
					}
				}
			}
						
		}
/*
		for(int i = 0 ; i < tempRoomArray.size(); ++i){
			System.out.println(tempRoomArray.get(i).getDescription());
		}
*/
		return tempRoomArray;
		
	}
	
	
}
