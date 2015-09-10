public class Question{

	private String question;
	private int opt1;
	private int opt2;

	public void setQuestion(String q){
		this.question = q;
	}

	public void setOpt1(int o1){
		this.opt1 = o1;
	}

	public void setOpt2(int o2){
		this.opt2 = o2;
	}

	public String getQuestion(){
		return this.question;	
	}

	public int getOpt1(){
		return this.opt1;	
	}

	public int getOpt2(){
		return this.opt2;	
	}

	Question(String q1, int option1, int option2){
	
		this.setQuestion(q1) ;
		this.setOpt1(option2);
		this.setOpt2(option2);
	}

}
