package nu.xdi.code_challenge.adventure;

import java.util.ArrayList;
import java.util.Scanner;
import static nu.xdi.code_challenge.adventure.Node.findNode;

public class Adventure {

	ArrayList<Location> locations;
	ArrayList<Action> actions;
	ArrayList<Item> items;
	ArrayList<Direction> directions;

	static Adventure game;

	public static void main (String[] args) {
		game = new Adventure();
		game.runGame();
	}

	/**
	 * Main game loop
	 */
	public void runGame () {

		Scanner scan = new Scanner(System.in);

		// Read the configuration file	
		FileIO.readConfig();

		System.out.println ("\n\nThe adventure begins...\n\n");


		// Start at the "start" location id
		int currentLocation = findNode (locations, "start");
		String userInput;
	game:
		while (true) {

			Location curLoc = locations.get(currentLocation);

			// Show the location description
			System.out.println ("\n\n");
			System.out.println (curLoc.getDescription());

			// Show any items at this location
			if (curLoc.getItemList().size() > 0) {
				System.out.println ("You can see:");
				for (Item i : curLoc.getItemList()) {
					System.out.println (i.getDescription());
				}
			}

			// Show the exits from this location
			if (curLoc.getExitList().size() > 0) {
				System.out.println ("Available exits are:");
				for (Direction i : curLoc.getExitList()) {
					System.out.println (i.getDescription());
				}
			}

			while (true) {
				System.out.print ("What next? >");
				userInput = scan.nextLine();

				String verb = "";
				String noun = "";
				int userAction;
				Item userItem;

				verb = parseVerb(userInput).toLowerCase();

				if (verb.length() > 0 && (userAction = findNode(actions, verb)) > 0) {

//					System.out.println ("Action found " + actions.get(userAction).getDescription());

					if (verb.equals("quit")) break game;
					if (verb.equals("look")) break;

					noun = parseNoun(userInput);

					if (verb.equals("go")) {
						// Look up available exits to match direction
						int descNum = 0;
						for (Direction i : curLoc.getExitList()) {
							String desc = i.getDescription().toLowerCase();
			
							if (desc.equals(noun)) {
								break;								
							}
							descNum++;
						}
					}


				} else {
					System.out.println ("I don't know how to '" + userInput + "'");
				}
			}
		}		

	}


	/**
	 * Search the actions list for the verb
	 */
	public String parseVerb (String input) {

		if (input.length() > 0 ) {
			if (input.indexOf(' ') > 0) {
				System.out.println(input.substring(0, input.indexOf(' ')));
				return input.substring(0, input.indexOf(' '));
			} else {
				return input;
			}
		}		
		return "";
	}

	/**
	 * Search the object list for the noun
	 */
	public String parseNoun (String input) {
		return input.substring(input.indexOf(' '));
	}

}

