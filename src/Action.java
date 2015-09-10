package nu.xdi.code_challenge.adventure;
import java.util.ArrayList;

/**
 * Define an action in the game.
 */
class Action extends Node {

	private String verb;
	private String actionDescription;
	private String actionOnDescription;
	private String needsNoun;

	Action (String id) {
		super(id);
	}

	public void setVerb (String s) {
		this.verb = s;
	}
	public void setActionDescription (String s) {
		this.actionDescription = s;
	}
	public void setActionOnDescription (String s) {
		this.actionOnDescription = s;
	}
	public void setNeedsNoun (String s) {
		this.needsNoun = s;
	}


}

