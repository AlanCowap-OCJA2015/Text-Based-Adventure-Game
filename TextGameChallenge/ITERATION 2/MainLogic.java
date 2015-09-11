import java.util.ArrayList;

public class MainLogic{
	private FileParser parser = new FileParser();
	private ArrayList<Question> questions;
	private ArrayList<String> answers;
	private ArrayList<Integer> eOutcome;
	private int outcome;
	private static final String lbreak = "---------------------";

	public static void main(String[] args){
		new MainLogic().init();
	}

	private void init(){
		questions = parser.read();

		while(outcome != -1){
			outcome = showQuestion(outcome);
		}
	}

	private int showQuestion(int tempOutcome){
		Question tempQuestion = null;


		for(int i = 0; i < questions.size(); ++i){
			if(questions.get(i).getBOutcome() == tempOutcome){
				tempQuestion = questions.get(i);
			}
		}

		System.out.println("\n" + tempQuestion.getQuestion());
		System.out.println(lbreak);

		answers = tempQuestion.getAnswers();
		eOutcome = tempQuestion.getEOutcome();

		for(int i = 0; i < answers.size(); ++i){
			System.out.println((i+1) + ") " + answers.get(i));
		}


		//System.out.println(tempQuestion.getBOutcome() + " " + tempQuestion.getEOutcome());
		//System.out.println("Answer: " + answers.get(0) + ", EOUTCOME: " + eOutcome.get(0));

		int choice = Integer.parseInt(System.console().readLine());

		return (eOutcome.get(choice - 1));
	}
}