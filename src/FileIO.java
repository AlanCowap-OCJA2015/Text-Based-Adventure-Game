package nu.xdi.code_challenge.adventure;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

class FileIO {

	public int readConfig(String... filename) {

        BufferedReader inFile = null;
        String inLine = null;
		String inputFilename = "";
        
        if (filename.length == 0) {
			inputFilename = filename[0];
        } else {
			inputFilename = "config.txt";
		}

        // open file for input
        try {
            inFile = new BufferedReader(new FileReader(inputFilename));
        } catch (IOException e) {
			return -1;
        }
	        
        // read file and parse nodes
        if (inFile != null) {
	        try {
				do {
           			inLine = inFile.readLine();
					System.out.println (inLine);
           		} while (inLine != null);
	        } catch (IOException e) {
				return -1;
	        }
        }
		return 0;		// Successful configuration
	}

}
