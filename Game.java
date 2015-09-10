import java.io.File;
import java.io.FileNotFoundException;
import java.io.Console;
import javax.swing.JFileChooser;
import java.util.ArrayList;
public class Game{

	private File gameDoc;
	private String gameDocLocation;

	private ArrayList<Question> questionList = new ArrayList<Question>();
	

	public Game(String gameDocLocation){

		this.gameDocLocation = gameDocLocation;

		try{

			if((!(this.gameDoc = new File(gameDocLocation)).exists()) || !this.gameDoc.getAbsolutePath().endsWith(".txt")){

				gameDoc = null;
				
				throw new FileNotFoundException();
			}
			
			

		}catch(FileNotFoundException fnfe){

			System.out.println("File does not exist or is invalid.");

		}

		

	}

	public static void start(){

		Game game = null;

		do{
			game = newGameMenu();

		}while(game.gameDoc == null);
			
		System.out.println("Game starting with file" + game.gameDoc.getAbsolutePath());

		QuestionBuilder.buildQuestions(game.questionList, game.gameDoc);

		Question currentQuestion = null;		

		for(Question q : game.questionList){
			if(q.getID() == 1){
				currentQuestion = q;
			}
		}
		int nextQuestion = 1;
		do{
			nextQuestion = currentQuestion.ask();

			//System.out.println(nextQuestion);

			for(Question q : game.questionList){
				if(q.getID() == nextQuestion){
					currentQuestion = q;
				}
			}

			

		}while(nextQuestion != -1);
		


	}

	public static Game newGameMenu(){

		//String loc = "C:\\Users\\User1\\Desktop\\Code Challenge 10-09-2015\\GameDocs\\MyAdventure.txt";
		//Game game = new Game(loc);

		Console input = System.console();


		while(true){

			System.out.println("1) Enter file path");
			System.out.println("2) Open file chooser");
			System.out.println("3) Exit");

			String inputString = input.readLine();

			switch(inputString){
	
				case "1":
					String filePath = input.readLine("Please enter the full file path");
					return new Game(filePath);
				case "2":
					JFileChooser chooser = new JFileChooser();
					int result = chooser.showOpenDialog(null);
					if(result == JFileChooser.APPROVE_OPTION){
						return new Game(chooser.getSelectedFile().getAbsolutePath());
					}
				case "3":
					System.exit(0);	
					break;
				default : 
					System.out.println("Invalid input");

			}
		}
		

	}

}
