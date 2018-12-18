package gameLogic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ScoreFile {
	
	//private int finalScore;
	//private String name;
	
	public ScoreFile() {

	}
	
	/*
	public ScoreFile(int finalScore, String name) {
		this.finalScore = finalScore;
		this.name = name;
	}
	*/
	
	public void printScore(String name, int finalScore) {
		try {
			FileWriter fileW = new FileWriter("scores.txt");
			PrintWriter printW = new PrintWriter(fileW);
	
			printW.println(name + ": " + finalScore);
			printW.close();
			
		} catch (IOException e) {
			System.out.println("ERROR");
		}
	}
	
	public void readScore() {
		
	}
}
	
