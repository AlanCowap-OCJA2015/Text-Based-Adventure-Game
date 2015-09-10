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


	//goes to next question line
	//generates answer list available for that question
	//returns generated string
	public String getNextMessage(){

		String option = ""+ dialogPosition;
		String displayText = "";		
		int startPos = text.indexOf(option + "<") + option.length();

	//	System.out.println(option);	//TEST
	//	System.out.println(startPos);//TEST

		//gets ¬ character position after the question
		int endPos = text.indexOf("¬", startPos);

		//System.out.println(endPos);//TEST

		//gets position of \n character after ¬ character
		//will be needed to determine what option chosen branch moves to
		int newLinePos = text.indexOf("\n", endPos);

		String endString = text.substring(endPos, newLinePos);
		//System.out.println("-" + endString + "-");//TEST
		
		if(text.substring(endPos, newLinePos).equals("¬END")){
			System.out.println("Dialogue ends");
			return null;
		}

		displayText = "\n" + text.substring(startPos, endPos);



		//GENERATE AVAILABLE OPTIONS
		optionCount = 0;
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



//accepts user picked option
//displays appropriate message
//with respond from someone
//and another subset of options available
	public String pickOption(int userOption){

		if(!(userOption > 0 && userOption <= optionCount)){
			return null;
		}

		/*
1<Hello Stranger! - 'You see a man on crutches, he has no left leg'.¬
	1.1>Hello, what do you want?¬2
	1.2>I have no time for you, get out of my way!¬3
	1.3>Sorry, I have no time, see you later!¬4
	1.4>Say nothing, go away¬END
2<Please bring this letter to my friend, I am disabled and can't walk..¬
	2.1>Okay - 'Take the letter'.¬5
	2.2>Maybe next time¬END
3<Idiot! - 'Smacks you with a crutch'.¬END
4<Please, I need your help!¬
	4.1>Okay, what do you want?¬2
5<Thank you! Goodbye!¬END
		*/
		
		//gets position of chosen option
		String optionStr = dialogPosition + "." + userOption + ">";
		int optionPos = text.indexOf(optionStr);
		//System.out.println(optionPos);	//TEST

		//gets position of ¬ caracter after chosen option
		int movePos = text.indexOf("¬", optionPos);
		//System.out.println(movePos);	//TEST

		//gets position of \n character after ¬ character
		//will be needed to determine what option chosen branch moves to
		int newLinePos = text.indexOf("\n", movePos);
		//System.out.println(newLinePos);	//TEST
		
		String displayText = "\nYou say: " + text.substring(optionPos + optionStr.length(), movePos);
		//System.out.println("\nYou say: " + displayText;)	//TEST


		//determining where branching goes to
		String moveOptionStr = text.substring(movePos + 1, newLinePos);
		//System.out.println("-"+moveOptionStr+ "-");	//TEST
		try{
			dialogPosition = Integer.parseInt(moveOptionStr);
		} catch (NumberFormatException nfe){
			//nfe.printStackTrace();
			System.out.println("Dialogue ends");
			return null;	//dialog ends at the end of option you choose
		}
		//System.out.println("-" + dialogPosition + "-");	//TEST

		return displayText;
	}


	public int getOptionCount(){
		return this.optionCount;
	}
}
