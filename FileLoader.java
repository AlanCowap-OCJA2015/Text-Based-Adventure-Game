//Loads text from file, returns text using toString()

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class FileLoader {
	private String text = "";
	
	//add constructor which loads text
	public FileLoader(String path){
		this.loadTextFromFile(path);
	}

	//load text from file
	public void loadTextFromFile(String filePath){
		try{
			File file = new File(filePath);
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			if (file.exists()){
				String tempLine;
				if((tempLine = br.readLine()) == null){
					System.out.println("Readline returns null");
				} else {
					text += tempLine;
					while((tempLine = br.readLine()) != null){
						text += tempLine;
					}
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public String toString(){
		return this.text;
	}
}
