//main class which loads the game

public class JourneyOfAChampion {

	public static void main( String [] ags ) {
		JourneyOfAChampion joac = new JourneyOfAChampion();
		joac.loadGame();
	}

	public void loadGame ( ) {
		Player player = new Player(5, 10, "Glorious Pumpkin");

		System.out.println("\t");
		System.out.println("\tWelcome to the Journey of a Champion!");
		System.out.println("\t" + player.toString());


		//Loads the file and displays it
		FileLoader fl = new FileLoader("C:/java/CodeChallengeGame/Dialogues.txt");
		System.out.println(fl.toString());

		//test with dialogue
		Dialogue dialogue = new Dialogue(fl.toString() , player.getName(), "Stranger");
		System.out.println(dialogue.getOption("5"));
	}

}
