import java.util.ArrayList;

public class GameApp{

	public static void main(String[] args){
		System.out.println("Hello Choose your own adventure");
			
		GetAdventure adventure = new GetAdventure();
		ArrayList<String> choices = null;
		choices = adventure.readFile();
		for(String s:choices){
			System.out.println(s);
		}
	}

}
