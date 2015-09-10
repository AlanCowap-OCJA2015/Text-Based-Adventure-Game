package nu.xdi.code_challenge.adventure;

import java.util.ArrayList;

/**
 * Define an action in the game.
 */
class Node {

	private String id;
	private String description;

	Node (String id) {
		this.id = id.intern();
	}

	public void setDescription (String s) {
		this.description = s.intern();
	}

	public String getDescription () {
		return this.description;
	}

	public String getId () {
		return this.id;
	}

	/**
	 * Method to compare the given id with the object's id
	 */
	int compareId (String id) {
		return this.id.compareToIgnoreCase(id);
	}

	/**
	 * Search an ArrayList for an object matching the given id
	 */
	public static int findNode (ArrayList<?> nodeList, String id) {

		for (Node n : (ArrayList<Node>)nodeList ) {
			if (n.compareId(id) == 0) {
				return nodeList.indexOf(n);
			}
		}
		return -1;
	}

}

