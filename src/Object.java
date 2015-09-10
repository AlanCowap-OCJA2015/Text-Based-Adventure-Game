package nu.xdi.code_challenge.adventure;

/**
 * Define an object in the game.
 */
class Object extends Node {

	private ArrayList<Action> actions;
	private ArrayList<String> names;

	Object (String id) {
		this.id = id;
	}

}

