import java.io.Console;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TestMain{
	ArrayList<Room> world;
	Player player;
	boolean debug = false;
	
	void getInput(){
		while (true){
			Console con = System.console();
			String userInput = con.readLine(" > ");
			if (userInput.length() != 0 && userInput.charAt(0) == '?') {
				displayHelpText();
			} else {
				String[] inputArray = userInput.split(" ");
				switch (inputArray.length){
					case 0: break;
					case 1: useInput(inputArray[0]); break;
					default: useInput(inputArray[0], inputArray[1]); break;
				}
			}
		}
	}

	void displayHelpText(){
		Method[] methods = player.getClass().getMethods();
		for (Method m: methods){
			if (m.toString().startsWith("Player", 12)) {
				int temp = m.toString().indexOf('(');
				System.out.println(m.toString().substring(19, temp));
			}
		} 
	}

	void useInput(String method){
		if (debug) System.out.println("Debug text: in useInput String");
		try {
			Method m = player.getClass().getMethod(method);
			if (debug) System.out.println("Debug text: method name - " + m.toString());
			m.invoke(player, (Object[])null);
		} catch (Exception e){
			System.out.println("I'm sorry, I can't do that");
			if (debug){
				System.out.println(e);
				e.printStackTrace();
			}
		}
	}

	void useInput(String method, String argument){
		if (debug) System.out.println("Debug text: in useInput String, String");
		try {
			Method m = player.getClass().getMethod(method, String.class);
			if (debug) System.out.println("Debug text: method name - " + m.toString());
			m.invoke(player, argument);
		} catch (Exception e){
			System.out.println("I'm sorry, I can't do that");
			if (debug){
				System.out.println(e);
				e.printStackTrace();
			}
		}
	}

	public void runApp(){
		this.player = new Player();
		world = FileLoader.load();
		player.setCurrentRoom(world.get(0));
		player.look();
		getInput();
	}
	public static void main(String[] args){
		TestMain tc = new TestMain();
		tc.runApp();		
	}
}
