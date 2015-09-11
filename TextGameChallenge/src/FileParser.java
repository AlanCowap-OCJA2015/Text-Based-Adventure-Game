import java.io.*; //change this when possible
import java.util.ArrayList;
import java.util.*;

class FileParser{
	private BufferedReader reader;
	private int fightNumber;
	private ArrayList<Question> questions;
	private ArrayList<String> answers;
	private ArrayList<Integer> eOutcome;
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();

	public ArrayList<Question> read(){
		try{

			getEnemy();

			//ABANDON HOPE ALL YE WHO ENTER HERE
				
			questions = new ArrayList<Question>();

			File file = new File("sample.txt");
			reader = new BufferedReader(new FileReader(file));

			String[] prefix;
			Enemy tempEnemy = null;
			boolean fight = false;
			String line = "", question = "", answer = "";
			String name = "", loot = "";
			int HP = 0, XP = 0, attack = 0;
			int bOutcome = -1;
			//int fightNumber = -1;
			
			
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

						case "FIGHT": 	fight = true;

								

								break;
						//case "ENEMYSTART": getEnemy();
					}

				} else {

			
					//System.out.println("HELLO" + tempEnemy);
					//System.out.println("HELLO" + fightNumber + " " + bOutcome);




					//if(bOutcome == fightNumber){
					//System.out.println(tempEnemy);
						//questions.add(new Question(question, answers, bOutcome, eOutcome, tempEnemy));
						//System.out.println(new Question(question, answers, bOutcome, eOutcome, tempEnemy));
					
						//for(int i = 0; i < questions.size(); ++i){
						//	//System.out.println(questions.get(i).getEnemy());
						//}					
	
					//} else {
						questions.add(new Question(question, answers, bOutcome, eOutcome, null));
					//}
					eOutcome = new ArrayList<Integer>();
					answers = new ArrayList<String>();
					fight = false;
				}

				for(int i = 0; i < questions.size(); ++i){
					if(questions.get(i).getBOutcome() == 33){
						questions.get(i).setEnemy(enemies.get(0));
					}
				}

			}

			//System.out.println(questions);


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
	}

	void getEnemy(){
		try{

			File file = new File("sample.txt");
			reader = new BufferedReader(new FileReader(file));

			String[] prefix;
			String line = "", name = "", loot = "";
			int HP = 0, XP = 0, attack = 0;

			
			
			while((line = reader.readLine()) != null){
				prefix = line.split(" ", 2);

				if(!line.equals("ENEMYEND")){

					switch(prefix[0]){

						case "FIGHT": fightNumber = Integer.parseInt(prefix[1]);

						case "NAME": 	name = prefix[1];break;
						
						case "HP": 	HP = Integer.parseInt(prefix[1]); break;
				
						case "XP": 	XP = Integer.parseInt(prefix[1]); break;

						case "ATTACK": 	attack = Integer.parseInt(prefix[1]);break;

						case "LOOT": 	loot = prefix[1]; break;
					}

				} else {
					enemies.add(new Enemy(HP, XP, attack, name, loot, fightNumber));
					HP = 0;
					XP = 0; 
					attack = 0;
					name = "";
					loot = "";
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

		//System.out.println(enemies);
	}

}