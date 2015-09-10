//main class which loads the game

public class JourneyOfAChampion {

	public static void main( String [] ags ) {
		JourneyOfAChampiom joac = new JourneyOfAChampiom();
		joac.loadGame();
	}

	public void loadGame ( ) {
		Player p = new Player(5, 10, "Glorious Pumpkin");

		System.out.println("\t");
		System.out.println("\tWelcome to the Journey of a Champion!");
		System.out.println("\t" + p.toString());
	}

}
