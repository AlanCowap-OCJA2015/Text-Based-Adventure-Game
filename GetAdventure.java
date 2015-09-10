import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class GetAdventure{

	private ArrayList<String> choices = new ArrayList<String>();

	public ArrayList<String> readFile(){
		
		try(Scanner scan = new Scanner(new File("AdventureTime.txt"))){
			scan.useDelimiter("#");
			while(scan.hasNext()){
				String info = scan.next();
				if(scan.hasNextInt()){
					int option = scan.nextInt();
					System.out.println("Int is " + option);
				}
				choices.add(info);
			}
			return choices;
		}
		catch(FileNotFoundException fnfe){
			System.out.println("Could not find File!");
			return choices;
		}
		catch(Exception e){
			System.out.println("Exception I didn't think of!");
			return choices;
		}

	}
}
