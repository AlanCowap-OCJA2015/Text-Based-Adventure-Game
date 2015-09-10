package nu.xdi.code_challenge.adventure;
import java.util.ArrayList;

/**
 * Define an item in the game.
 */
class Item extends Node {

	private ArrayList<Action> actions;
	private ArrayList<String> names;

	Item (String id) {
		super(id);
		this.actions = new ArrayList<Action>();
		this.names = new ArrayList<String>();
	}

}

