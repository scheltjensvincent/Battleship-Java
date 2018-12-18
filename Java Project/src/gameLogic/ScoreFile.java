package gameLogic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//import com.sun.tools.javac.parser.*;


public class ScoreFile {
	
	
	public ScoreFile() {

	}
	
	
	public void printScore(String name, int finalScore) {
		try {
			PrintWriter printW = new PrintWriter(new FileWriter("scores.txt", true));
	
			printW.println(name + ": " + finalScore);
			printW.close();
			
		} catch (IOException e) {
			System.out.println("ERROR");
		}
	}
	
	public void readLastScore() {
		
	}
	
	/* 
	 public static void maxScore(String file) throws IOException {
	        Scanner fileScanner = new Scanner(new File(file));
	        int max = fileScanner.nextInt();
	        while (fileScanner.hasNextInt()) {
	            int num = fileScanner.nextInt();
	            if (num > max) {
	                max=num;
	            }
	        }
	        System.out.println(max);
	        fileScanner.close();
	    }
	    
	    */
}
	
