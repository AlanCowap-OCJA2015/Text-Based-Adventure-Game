import java.util.ArrayList;

class Question{
	private String question;
	private ArrayList<String> answers;
	private int outcome;

	public Question(String question, ArrayList<String> answers, int outcome){
		this.question = question;
		this.answers = answers;
		this.outcome = outcome;
	}

	public String toString(){
		return "Question: " + this.question + " Answers: " + this.answers + " Outcome: " + this.outcome + "\n";
	}
}