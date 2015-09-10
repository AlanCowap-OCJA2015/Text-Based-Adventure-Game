package nu.xdi.code_challenge.adventure;

import java.util.ArrayList;

/**
 * Define a location in the game.
 */
class Location extends Node {

	private ArrayList<Action> actions;
	private ArrayList<Item> items;
	private ArrayList<Direction> exits;
	private ArrayList<String> exitsTo;

	/**
	 * Constructor for a new location object
	 */
	Location (String id) {
		super(id);
		this.actions = new ArrayList<Action>();
		this.items = new ArrayList<Item>();
		this.exits = new ArrayList<Direction>();
		this.exitsTo = new ArrayList<String>();
	}

	/**
	 * Add an item to this location
	 */
	public void addItem (Item i) {
		this.items.add(i);
	}

	/**
	 * Get this location's item list
	 */
	public ArrayList<Item> getItemList () {
		return this.items;
	}

	/**
	 * Add an exit to this location
	 */
	public void addExit(Direction d) {
		this.exits.add(d);
	}

	/**
	 * Add an exit target to this location
	 */
	public void addExitTo(String s) {
		this.exitsTo.add(s);
	}

	/**
	 * Get this location's directions list
	 */
	public ArrayList<Direction> getExitList () {
		return this.exits;
	}

}

