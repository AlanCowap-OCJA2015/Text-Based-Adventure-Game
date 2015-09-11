import java.util.ArrayList;

class Question{
	private String question;
	private ArrayList<String> answers;
	private int bOutcome;
	private ArrayList<Integer> eOutcome;

	public Question(String question, ArrayList<String> answers, int bOutcome, ArrayList<Integer> eOutcome){
		this.question = question;
		this.answers = answers;
		this.bOutcome = bOutcome;
		this.eOutcome= eOutcome;
	}

	public String toString(){
		return "Question: " + this.question + " Answers: " + this.answers + " bOutcome: " + this.bOutcome + " eOutcome: " + this.eOutcome + "\n";
	}

	public String getQuestion(){
		return this.question;
	}

	public ArrayList<String> getAnswers(){
		return this.answers;
	}

	public int getBOutcome(){
		return this.bOutcome;
	}

	public ArrayList<Integer> getEOutcome(){
		return this.eOutcome;
	}
}