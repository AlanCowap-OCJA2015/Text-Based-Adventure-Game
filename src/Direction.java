package nu.xdi.code_challenge.adventure;
import java.util.ArrayList;

/**
 * Define a direction in the game
 */
class Direction extends Node {

	private ArrayList<String> nouns;

	Direction (String id) {
		super(id);
		this.nouns = new ArrayList<String>();
	}
}

