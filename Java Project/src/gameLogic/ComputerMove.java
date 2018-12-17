package gameLogic;

import java.util.ArrayList;
import java.util.Random;

public class ComputerMove {

	public int compMove;
	private ArrayList<Integer> shotsFired = new ArrayList<Integer>();
	
	
	public ComputerMove() {
		
	}

	
	public int compMove(int dificulty) {
		if(dificulty == 1) {
			compMove = randomValue();
		}
		if(dificulty == 2) {
			compMove = algorithmOne();
		}
		if(dificulty == 3) {
			compMove = algorithmTwo();
		}
		return compMove;
	}
	

	public int randomValue() {
		boolean validLoc = false;
		int randMove = 0;
		while(!validLoc) {
			randMove = getRandNum(0, 99);
			if(shotsFired.contains(randMove)) {
				validLoc = false;
			} else {
				validLoc = true;
			}
		}
		shotsFired.add(randMove);
		
		return randMove;
	}
	
	public int algorithmOne() {
		//random or diagonal with target when hit 
		int value = 0; 
		return value;
	}
	
	private int algorithmTwo() {
		//probability density function || Monte Carlo  depending on the time left
		//to do this we need to know which ships are still on the board and the respective lengths
		int value = 0; 
		return value;
	}

	public int getCompMove() {
		return this.compMove;
	}
	
	private static int getRandNum(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;	
	}
	
	
}
