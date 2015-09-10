//used to run given dialogue

class Dialogue {
	private String text;
	private String plName;	//players name
	private String somName;	//someone's name
	
	public Dialogue (String text, String plName, String somName) {
		this.text = text;
		this.plName = plName;
		this.somName = somName;
	}

	//goes to next line specified in aprameters and returns it
	public String getOption(String option){
		String displayText = "";		


		//5<Thank you! Goodbye!¬END
		int startPos = text.indexOf(option) + option.length() + 1;

		System.out.println(option);

		System.out.println(startPos);

		int endPos = text.indexOf("¬", startPos);

		System.out.println(endPos);

		displayText = text.substring(startPos, endPos);
		
		return displayText;
	}
}
