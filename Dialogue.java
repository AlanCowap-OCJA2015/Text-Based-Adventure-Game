//holds dialogue text between you and someone
//allows to move through dialogue branching until dilagoue ends

class Dialogue {
	private String text;	//all dialogue text
	private String plName;	//players name
	private String somName;	//someone's name
	private int dialogPosition = 1;	//holds current position of someone's speech branch
	private int optionCount = 0;	//number of answering options available for player in current part of dialogue
	
	
	public Dialogue (String text, String plName, String somName) {
		this.text = text;
		this.plName = plName;
		this.somName = somName;
	}

	//goes to next line specified in parameters and returns it
	public String getNextMessage(){

		String option = ""+ dialogPosition;

		String displayText = "";		

		int startPos = text.indexOf(option + "<") + option.length();

		//System.out.println(option);	//TEST
		//System.out.println(startPos);//TEST

		int endPos = text.indexOf("¬", startPos);

		//System.out.println(endPos);//TEST

		displayText = "\n" + text.substring(startPos, endPos);


		//GENERATE AVAILABLE OPTIONS
		boolean hasOptions = true;
		while(hasOptions){
			String currentOption = option + "." + (1 + optionCount);
			int start = text.indexOf(currentOption);
			if(start != -1){	//there is such option
				++optionCount;
				int end = text.indexOf("¬", start);
				displayText += "\n" + optionCount + text.substring(start + currentOption.length(), end);

			}else{					//there is no such option
				hasOptions = false;
			}
		}
		
		return displayText;
	}


	


	public int getOptionCount(){
		return this.optionCount;
	}
}
