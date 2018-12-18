package gameLogic;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class ScoreFile {
	
	
	public ScoreFile() {

	}
	
	
	public void printScore(int finalScore) {
		try {
			PrintWriter printW = new PrintWriter(new FileWriter("scores.txt", true));
	
			//printW.println(name + ": " + finalScore);
			printW.println(finalScore);
			printW.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
	 public void highScore() {
	 	try {
	        Scanner scanner = new Scanner(new FileReader("scores.txt"));
	        int highScore = scanner.nextInt();
		        while (scanner.hasNextInt()) {
		            int n = scanner.nextInt();
		            if (n > highScore) {
		               highScore = n;
		            }
		        }
		        System.out.println(highScore);
		        scanner.close(); 
		        
	 	} catch (IOException e) {
			e.printStackTrace();
	 	}
	}
	 
	        
	    
}
	
