class Warrior extends Character{


	public Warrior(String name){
		super(name);
		stats.put("S", 8);
		stats.put("P", 7);
		stats.put("E", 9);
		stats.put("C", 5);
		stats.put("I", 3);
		stats.put("A", 7);
		stats.put("L", 8);
	
		bag.add("Axe");	
	}

}