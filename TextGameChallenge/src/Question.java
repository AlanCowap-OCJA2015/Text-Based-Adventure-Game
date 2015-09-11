import java.util.ArrayList;

class Question{
	private String question;
	private ArrayList<String> answers;
	private ArrayList<Integer> eOutcome;
	private int bOutcome;
	private Enemy enemy;


	public Question(String question, ArrayList<String> answers, int bOutcome, ArrayList<Integer> eOutcome, Enemy enemy){
		this.question = question;
		this.answers = answers;
		this.bOutcome = bOutcome;
		this.eOutcome= eOutcome;
		this.enemy = enemy;
	}

	public String toString(){
		return "Question: " + this.question + " Answers: " + this.answers + " bOutcome: " + this.bOutcome + " eOutcome: " + this.eOutcome
			 + " Enemy: " + this.enemy + "\n";
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

	public Enemy getEnemy(){
		return this.enemy;
	}

	public void setEnemy(Enemy e){
		this.enemy = e;
	}
}