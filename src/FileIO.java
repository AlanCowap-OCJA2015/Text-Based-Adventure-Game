package nu.xdi.code_challenge.adventure;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import static nu.xdi.code_challenge.adventure.Node.findNode;

class FileIO {

	public static int readConfig(String... filename) {

        BufferedReader inFile = null;
        String inLine = null;
		String inputFilename = "";
        
        if (filename.length > 0) {
			inputFilename = filename[0];
        } else {
			inputFilename = "config.txt";
		}

        // open file for input
        try {
            inFile = new BufferedReader(new FileReader(inputFilename));
        } catch (IOException e) {
			return -1;
        }
	        
        // read file and parse nodes
        if (inFile != null) {
	        try {
				Node curContext = null;
				Adventure.game.locations = new ArrayList<Location>();
				Adventure.game.items = new ArrayList<Item>();
				Adventure.game.actions = new ArrayList<Action>();
				Adventure.game.directions = new ArrayList<Direction>();

				do {
           			inLine = inFile.readLine();

					System.out.println ("-> " + inLine);
					if (inLine == null || inLine.length() == 0) continue;

					inLine = inLine.trim();

					String[] tokens = inLine.split(" ");

					if (tokens.length > 1 && tokens[0].length() > 0 && tokens[0].charAt(0) == '@') {

						switch (tokens[0].toLowerCase()) {

							case "@location_id":
								curContext = new Location (tokens[1]);
								Adventure.game.locations.add((Location)curContext);
								break;
							case "@item_id":
								curContext = new Item (tokens[1]);
								Adventure.game.items.add((Item)curContext);
								System.out.println ("Added " + tokens[1] + " to items list, size:" + Adventure.game.items.size());
								break;
							case "@action_id":
								curContext = new Action (tokens[1]);
								Adventure.game.actions.add((Action)curContext);
								break;
							case "@direction_id":
								curContext = new Direction (tokens[1]);
								Adventure.game.directions.add((Direction)curContext);
								break;

							case "@description":
								curContext.setDescription (inLine.substring(inLine.indexOf(' ')));
								break;

							// Add an item to the current node (location)
							case "@item":
								if (curContext instanceof Location) {
									System.out.println ("Locating " + tokens[1]);
									int item = findNode(Adventure.game.items, tokens[1]);
									System.out.println ("in " + item);

									Item curItem = Adventure.game.items.get(item);
									System.out.println ("as " + curItem);

									((Location)curContext).addItem(curItem);
									System.out.println ("Added " + curItem.getDescription() + " to this location");
								}
								break;

							// Add an item to the current node (location)
							case "@exit":
								if (curContext instanceof Location) {
									System.out.println ("Locating " + tokens[1]);
									int exit = findNode(Adventure.game.directions, tokens[1]);
									System.out.println ("in " + exit);

									Direction curExit = Adventure.game.directions.get(exit);
									System.out.println ("as " + curExit);

									((Location)curContext).addExit(curExit);
									((Location)curContext).addExitTo(tokens[2]);
									System.out.println ("Added " + curExit.getDescription() + " to this location");
									System.out.println ("Leads to " + tokens[2]);
								}
								break;

						}
					}

           		} while (inLine != null);
	        } catch (IOException e) {
				return -1;
	        }
        }
		return 0;		// Successful configuration
	}

}
