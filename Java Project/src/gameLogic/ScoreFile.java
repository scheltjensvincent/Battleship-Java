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
			printW.println(finalScore);
			printW.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
	 public int highScore() {
		int highScore = 0;
	 	try {
	        Scanner scanner = new Scanner(new FileReader("scores.txt"));
	        highScore = scanner.nextInt();
		        while (scanner.hasNextInt()) {
		            int n = scanner.nextInt();
		            if (n > highScore) {
		               highScore = n;
		            }
		        }
		        scanner.close();
		        
	 	} catch (IOException e) {
			e.printStackTrace();
	 	} 
	 	
	 	return highScore;
	 	
	}

}
	
