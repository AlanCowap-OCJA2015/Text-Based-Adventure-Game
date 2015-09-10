public class Answer{

	private String text;
	private int destID;

	public Answer(String text, int destID){
		
		this.text = text;
		this.destID = destID;
	}


	public String getText(){
		return this.text;
	}

	public int getDestID(){
		return this.destID;
	}

}
