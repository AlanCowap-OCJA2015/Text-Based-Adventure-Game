import java.util.Scanner;

public class GameApp{

	public static void main(String[] args){
		System.out.println("Hello Choose your own adventure");

		String str = "What need have you#But come to sense#To fumble in the greasy till#And add the halfpence to the pence";
		Scanner scan = new Scanner(str);
		scan.useDelimiter("#");
		while(scan.hasNext()){
			System.out.println(scan.next());
		}		
	}

}
