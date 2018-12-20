package battleship;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class ScoreFile {
	

	//empty constructor to create an instance of this class elsewhere
	public ScoreFile() {

	}


	//method to print the final score to a text file
	public void printScore(int finalScore) {
		try {
			PrintWriter printW = new PrintWriter(new FileWriter("scores.txt", true));
			printW.println(finalScore);
			printW.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	//method that consults the text file and returns the highest value in there (highscore)
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
