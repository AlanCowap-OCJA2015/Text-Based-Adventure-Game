class Mage extends Character{


	public Mage(String name){
		super(name);
		stats.put("S", 3);
		stats.put("P", 7);
		stats.put("E", 3);
		stats.put("C", 7);
		stats.put("I", 9);
		stats.put("A", 5);
		stats.put("L", 9);
	
		bag.add("Sheep");	
	}

}