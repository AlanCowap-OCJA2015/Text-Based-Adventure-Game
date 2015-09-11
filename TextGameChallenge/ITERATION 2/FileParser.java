import java.io.*; //change this when possible
import java.util.ArrayList;
import java.util.*;

class FileParser{
	private BufferedReader reader;
	private ArrayList<Question> questions;
	private ArrayList<String> answers;
	private ArrayList<Integer> eOutcome;
	
	//public static void main(String[] args){
	//	new FileParser().read();
	//}

	public ArrayList<Question> read(){
		try{

			//ABANDON HOPE ALL YE WHO ENTER HERE
				
			questions = new ArrayList<Question>();

			File file = new File("sample.txt");
			reader = new BufferedReader(new FileReader(file));

			String[] prefix;
			String line = "", question = "", answer = "";
			int bOutcome = -1;
			
			
			while((line = reader.readLine()) != null){
				prefix = line.split(" ", 2);

				if(line.equals("START")){
					answers = new ArrayList<String>();
					eOutcome = new ArrayList<Integer>();
				}

				if(!line.equals("BREAK")){
					
					//System.out.println(prefix[0]);

					switch(prefix[0]){

						case "QUESTION": question = prefix[1]; break;
				
						case "ANSWER": 	answers.add(prefix[1]); //.substring(1, prefix[1].length())
								break;

						case "EOUTCOME": eOutcome.add(Integer.parseInt(prefix[1]));
								break;

						case "BOUTCOME": bOutcome = Integer.parseInt(prefix[1]); break;
					}

				} else {
					questions.add(new Question(question, answers, bOutcome, eOutcome));
					eOutcome = new ArrayList<Integer>();
					answers = new ArrayList<String>();
				}

			}


		} catch(IOException ioe){
			
			ioe.printStackTrace();
	
		} finally {
			try{
				reader.close();
			} catch(IOException ioe){
				ioe.printStackTrace();
			}
		}

		return questions;

		//write();
	}

	//void write(){
		//System.out.println(questions);
	//}


}