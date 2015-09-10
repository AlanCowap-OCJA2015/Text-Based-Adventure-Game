import java.util.ArrayList;
import java.util.Scanner;

public class Game{

	private ArrayList<Question> path = new ArrayList<Question>();
	private ArrayList<Life> encounters = new ArrayList<Life>();

	public Game(String fileName){
		GetAdventure adventure = new GetAdventure();
		path = adventure.readFile(fileName);
	}

	public void playGame(){

		chooseMove(path.get(0));

	}

	public void chooseMove(Question quest){
		if(quest.getOpt1() > 0){
			Scanner scan = new Scanner(System.in);
			System.out.println(quest.getQuestion());
			System.out.print("Which option do you pick?");
			validateInput(scan);
			int choice = scan.nextInt();

			switch(choice){
				case 1: chooseMove(path.get(quest.getOpt1())); break;
				case 2: chooseMove(path.get(quest.getOpt2())); break;
				default: break;
			}
		}
		else{
			System.out.println(quest.getQuestion());
			System.out.println("Congratulation, you have completed your quest, "
				+ " and killed all enemies. Live long and prosper!");
			System.exit(0);
		}
	}

	public void generateEncounters(int numEncounters){
		Scanner scanEncounter = new Scanner(System.in);
		for(int i = 0; i < numEncounters; ++i){
			System.out.println("What is the type of encounter?");
			String type = scanEncounter.next();
			System.out.println("How much health should " + type + " have?");
			validateInput(scanEncounter);
			int health = scanEncounter.nextInt();
			System.out.println("How much attack power should " + type + " have?");
			validateInput(scanEncounter);
			int attack = scanEncounter.nextInt();
			System.out.println("How likely is " + type + " to appear?");
			validateInput(scanEncounter);
			int luck = scanEncounter.nextInt();
			
			encounters.add(new Life(type, health, attack, luck));
			
		}
		System.out.println("");
		
	}

	private void validateInput(Scanner scan){
		while(!scan.hasNextInt()){
			scan.next();
			System.out.println("Not a valid option please enter either 1 or 2:");
		}
	}
	
	public void traverse(){

		Random rand = new Random(System.in);
	
		choice = rand.nextInt(11);

		if(choice%2=0 && Player.luck < 5){
		
			encounterType = rand.nextInt(encounters.size());

			System.out.println("You've encountered a " + encounters.get(encounterType) + " !!!");

			if(Player.defense > Life.attack){

				System.out.println("You are stronger and fight off the " + encounters.get(encounterType)
				+ " ,you only drop 1 health point");
				Player.hp = Player.hp -1;
				System.out.println("Healthpoints: " + Player.hp);
			
			}else{

				System.out.println("You are weaker and the " + encounters.get(encounterType) + " defeats you...");
				int battleres = Life.attack - Player.defense;
				Player.hp = Player.hp-battleres;
				System.out.println("You drop " + battleres + " health points" )
			}

		}else{
			System.out.println("Your journey was quiet, continue...")
	
		} 


	}

}
