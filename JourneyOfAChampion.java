//main class which loads the game

import java.util.Scanner;

public class JourneyOfAChampion {
	private Scanner scan = new Scanner(System.in);

	public static void main( String [] ags ) {
		JourneyOfAChampion joac = new JourneyOfAChampion();
		joac.loadGame();
	}

	public void loadGame ( ) {
		Player player = new Player(5, 10, "Glorious Pumpkin");

		System.out.println("\t");
		System.out.println("\tWelcome to the Journey of a Champion!");
		System.out.println("\t" + player.toString());


		//Loads the file
		FileLoader fl = new FileLoader("C:/java/CodeChallengeGame/Dialogues.txt");
//		System.out.println(fl.toString());	//TEST display of text loaded

		//test dialogue
		Dialogue dialogue = new Dialogue(fl.toString() , player.getName(), "Stranger");
		System.out.println(dialogue.getNextMessage());
		
		//get user choice
		System.out.print("Choose an option> ");
		String inputStr = scan.nextLine();
		int inputInt = 0;
		try{
			inputInt = Integer.parseInt(inputStr);
		}catch(NumberFormatException nfe){
			System.out.println("Please choose a valid option..");
		}
		
		//check if chosen option is one of the available in this dialogue branch
		if(inputInt > 0 && inputInt <= dialogue.getOptionCount()){
			System.out.println("This is a valid option..");
		} else {
			System.out.println("There is no such option..");
		}
		
		

	}

}
