package nu.xdi.code_challenge.adventure;

/**
 * Define an action in the game.
 */
class Node {

	private String id;
	private String description;

	public void setDescription (String s) {
		this.description = s;
	}

	public String getDescription () {
		return this.description;
	}

	public String getId () {
		return this.id;
	}
}

