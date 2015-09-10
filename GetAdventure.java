import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class GetAdventure{

	private ArrayList<Question> choices = new ArrayList<Question>();

	public ArrayList<Question> readFile(String fileName){
		if(fileName.length() == 0){
			fileName = "AdventureTime.txt";
		}
		else{
			fileName += ".txt";
		}
		
		try(Scanner scan = new Scanner(new File(fileName))){
			scan.useDelimiter("#");
			while(scan.hasNext()){
				String info = scan.next();
				String[] breakdown = info.split("\\*");
				
				String text = breakdown[0];
				int opt1 = Character.getNumericValue(breakdown[1].charAt((breakdown[1].length() - 1)));
				int opt2 = Character.getNumericValue(breakdown[2].charAt((breakdown[2].length() - 1)));
				choices.add(new Question(text, opt1, opt2));
			}
			return choices;
		}
		catch(FileNotFoundException fnfe){
			System.out.println("Could not find File!");
			return choices;
		}
		catch(NumberFormatException nfe){
			System.out.println("Well that wasn't a number");
			nfe.printStackTrace();
			return choices;
		}
		catch(Exception e){
			System.out.println("Exception I didn't think of!");
			e.printStackTrace();
			return choices;
		}

	}
}
