class Paladin extends Character{


	public Paladin(String name){
		super(name);
		stats.put("S", 7);
		stats.put("P", 8);
		stats.put("E", 7);
		stats.put("C", 7);
		stats.put("I", 6);
		stats.put("A", 5);
		stats.put("L", 5);
	
		bag.add("Scroll");	
	}

}