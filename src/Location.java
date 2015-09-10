package nu.xdi.code_challenge.adventure;

/**
 * Define a location in the game.
 */
class Location extends Node {

	private ArrayList<Action> actions;
	private ArrayList<Object> objects;
	private ArrayList<Direction> exits;

	Location (String id) {
		this.id = id;
	}
}

