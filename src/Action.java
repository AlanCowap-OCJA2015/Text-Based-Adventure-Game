package nu.xdi.code_challenge.adventure;
import java.util.ArrayList;

/**
 * Define an action in the game.
 */
class Action extends Node {

	private String verb;
	private String action_description;
	private String action_on_description;
	private String needs_noun;

	Action (String id) {
		super(id);
	}

}

