class Warlock extends Character{


	public Warlock(String name){
		super(name);
		stats.put("S", 4);
		stats.put("P", 6);
		stats.put("E", 4);
		stats.put("C", 6);
		stats.put("I", 8);
		stats.put("A", 6);
		stats.put("L", 9);
	
		bag.add("Skull");	
	}

}