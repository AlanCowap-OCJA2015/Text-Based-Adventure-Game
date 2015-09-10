import java.util.Scanner;

public class GameApp{

	public static void main(String[] args){
		System.out.println("Welcome to Adventure Times's \"Your Time is now!\"");
			
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the name of the adventure (file) you wish to play?" 
				+ "\nLeave blank for default adventure");
		String fileName = scan.nextLine();
		//scan.close();
		Game fun = new Game(fileName);

		System.out.println("How many enemies would you like to encounter?");
		while(!scan.hasNextInt()){
			scan.next();
			System.out.println("Not a valid number, please try again");
		}
		int numEncounters = scan.nextInt();
		fun.generateEncounters(numEncounters);
		fun.playGame();
	}

}
