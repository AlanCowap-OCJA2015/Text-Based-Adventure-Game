import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class QuestionBuilder{

	public static void buildQuestions(ArrayList<Question> questionList, File adventureDoc){

		
		Scanner reader = null;
		try{
			reader = new Scanner(adventureDoc);
		}catch(FileNotFoundException fnfe){
			System.out.println("Error, file not found, exiting...");
			System.exit(0);
		}
		int curLineNum = 0;

		loadFile:
		do{
			ArrayList<Answer> answerList = new ArrayList<Answer>();
			String text = "";
			int id = -1;

			//check for id
			String line = reader.nextLine();
			curLineNum++;

			if(isValidIDFormat(line)){
		
				line = line.trim();

				String idNum = line.substring(0, line.indexOf(":"));
				try{ 
					id = Integer.parseInt(idNum);
				}catch(NumberFormatException nfe){
					System.out.println("The provided ID on line " + curLineNum + " is an invalid format.");
					System.out.println("Exiting program...");
					System.exit(1000);
				}

			}
			//check for text
			do{
				line = reader.nextLine();
				curLineNum++;
				if(line.startsWith("//")){
					//Text end
					line = reader.nextLine();
					curLineNum++;
					break;
				}else{
					text += line + "\n";

				}
			}while(true);

			//check for options
			
			Answer tempAnswer = null;
			
			do{
				if(line.equals("END")){

					answerList.add(new Answer("", 0));
					questionList.add(new Question(answerList,text,id));
					break loadFile;
					

				}
				
				tempAnswer = createValidAnswer(line);

				if(tempAnswer == null){
					System.out.println("The provided ANSWER on line " + curLineNum + " is an invalid format.");
					System.out.println("Exiting program...");
					System.exit(1000);
				}else{
					answerList.add(tempAnswer);
				}
			
				line = reader.nextLine();
				curLineNum++;
				

				
			}while(!line.startsWith("//"));


			questionList.add(new Question(answerList,text,id));

		}while(reader.hasNextLine());
		

	}

	public static boolean isValidIDFormat(String idString){

		idString = idString.trim();
		if(!Character.isDigit(idString.charAt(0))){
			return false;
		}

		for(int i = 1; i < idString.length(); i++){

			char c = idString.charAt(i);
			
			if(c != ':' && !Character.isDigit(c)){
				return false;

			}else if(c == ':'){
				return true;
			}

		
		}

		return false;
	
		


	}

	public static Answer createValidAnswer(String line){

		line = line.trim();

		if(line.contains("@GOTO ")){
			
			String numSub = line.substring(line.indexOf("@GOTO ") + 6);

			String digitString = "";

			for(int i = 0; i < numSub.length(); i++){

				if(Character.isDigit(numSub.charAt(i))){
					digitString += "" + numSub.charAt(i);


				}else{
		
					break;
				}

			}

			if(digitString.length() > 0){
				int destID = Integer.parseInt(digitString);
				String text = line.substring(0, line.indexOf("@GOTO"));

				Answer temp = new Answer(text,destID);
				return temp;

			}else{

				return null;
			}

		}else{

			return null;

		}

		

	}

}
