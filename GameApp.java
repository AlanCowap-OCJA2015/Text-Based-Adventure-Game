import java.util.ArrayList;
import java.util.Scanner;

public class GameApp{

	public static void main(String[] args){
		System.out.println("Hello Choose your own adventure");
			
		GetAdventure adventure = new GetAdventure();
		ArrayList<Question> choices = null;

		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the name of the adventure (file) you wish to play?" 
				+ "\nLeave blank for default adventure");
		String fileName = scan.nextLine();

		choices = adventure.readFile(fileName);
		for(Question q:choices){
			System.out.println(q.getQuestion());
		}
	}

}
