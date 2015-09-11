import java.util.ArrayList;

public class MainLogic{
	private FileParser parser = new FileParser();
	private ArrayList<Question> questions;
	private ArrayList<String> answers;
	private ArrayList<Integer> eOutcome;
	private int outcome;
	private static final String lbreak = "---------------------";
	private Character PC;
	private String tempName;

	public static void main(String[] args){
		new MainLogic().init();
	}

	private void init(){
		questions = parser.read();

		while(outcome != -1){
			outcome = showQuestion(outcome);
		}

		System.out.println("THE END");
	}

	private int showQuestion(int tempOutcome){

		if(tempOutcome == 0){
			System.out.println("What is your name?");
			tempName = System.console().readLine();
		}


		Question tempQuestion = null;

		tempQuestion = getQuestion(tempOutcome);

		//System.out.println(tempQuestion.getEnemy());

		if(tempQuestion.getEnemy() != null) fight(tempQuestion);

		System.out.println("\n" + tempQuestion.getQuestion());
		System.out.println(lbreak);

		answers = tempQuestion.getAnswers();
		eOutcome = tempQuestion.getEOutcome();

		for(int i = 0; i < answers.size(); ++i){
			System.out.println((i+1) + ") " + answers.get(i));
		}

		int choice = Integer.parseInt(System.console().readLine());
		
		if(tempOutcome == 0) getCharacter(choice);

		//System.out.println(eOutcome.get(choice - 1));

		if(tempQuestion.getBOutcome() == 33 & choice == 1){
			System.out.println("*You fell on your sword*");
		}

		if(tempQuestion.getBOutcome() == 33 & choice == 2){
			System.out.println(lbreak);
			System.out.println("\nNo");
			System.out.println("*He hacks you to death viciously*");
		}

		return (eOutcome.get(choice - 1));
	}

	Question getQuestion(int tempOutcome){

		for(int i = 0; i < questions.size(); ++i){
			if(questions.get(i).getBOutcome() == tempOutcome){
				return questions.get(i);
			}
		}

		return null;
	}

	void getCharacter(int choice){
		switch(choice){
			case 1: PC = new Mage(tempName);
				break;
			case 2: PC = new Warlock(tempName);
				break;
			case 3: PC = new Warrior(tempName);
				break;
			case 4: PC = new Paladin(tempName);
				break;
			default: System.out.println("Something went horribly, horribly wrong");
		}	
	}


	void fight(Question tempQuestion){
		//System.out.println("do stuff");
		System.out.println(PC + " VERSUS " + tempQuestion.getEnemy());
		
		System.out.println("YOU LOSE");
	}
}