package nu.xdi.code_challenge.adventure;
import java.util.ArrayList;

/**
 * Define an object in the game.
 */
class Object extends Node {

	private ArrayList<Action> actions;
	private ArrayList<String> names;

	Object (String id) {
		super(id);
	}

}

