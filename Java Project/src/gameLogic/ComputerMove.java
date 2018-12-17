package gameLogic;

import java.util.ArrayList;
import java.util.Random;

public class ComputerMove {

	private int compMove;
	private int algoMove = 0;
	private int shots;
	
	private boolean hit;
	private boolean down;
	private boolean up;
	private boolean left;
	private boolean right;
	
	
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
		boolean validLoc = false;
		while(!validLoc) { // this
			if(!hit && !down && !up && !left && !right) {
				algoMove = getRandNum(0, 99);
			} else if (hit && !down && !up && !left && !right) {
				algoMove = down();
			} else if (hit && down) {
				algoMove = down();
			} else if (!hit && down){
				algoMove = up();
			} else if (hit && up) {
				algoMove = up();
			} else if (!hit && up) {
				algoMove +=10; // get back to initial hit
				algoMove = right();
			} else if (hit && right) {
				algoMove = right();
			} else if (!hit && right){
				algoMove = left();
			} else if (hit && left) {
				algoMove = left();
			} else if (!hit && left) { 
				algoMove = getRandNum(0, 99);
			} else {
				algoMove = getRandNum(0, 99);
			}
			
			if(shotsFired.contains(algoMove)) {
				validLoc = false;
			} else { 
				shotsFired.add(algoMove);
				validLoc = true;
			}
	}
		shots++;
		//shotsFired.add(algoMove);
		System.out.println(shotsFired);
		System.out.println(shotsFired.size());
		System.out.println(shots);
		return algoMove;
	}

	
	public void hit(boolean hitShot) {
		
		if(hitShot) {
			hit = true;
		} else {
			hit = false;
		}
	}
	
	private int left() {
		down = false;
		up = false;
		left = true;
		right = false;
		
		while(!validLoc(algoMove)) {
			if(algoMove >= 0 && algoMove <= 99) {
				algoMove -= 1;
			}
			if(algoMove < 0) {
				algoMove = getRandNum(0, 99);
			}
		}
	return algoMove;
	}


	private int right() {
		down = false;
		up = false;
		left = false;
		right = true;
		
		while(!validLoc(algoMove)) {
			if(algoMove >= 0 && algoMove <= 99) {
				algoMove += 1;
			}
			
			if(algoMove > 99) {
				left();
			}
		}
	return algoMove;
	}


	private int up() {
		down = false;
		up = true;
		left = false;
		right = false;
		
		while(!validLoc(algoMove)) {
			if(algoMove >= 0 && algoMove < 100) {
				algoMove -= 10;
			}
		
			if(algoMove < 0) {
				algoMove += 10;
				algoMove = getRandNum(0,99);
			}
		}	
	return algoMove;
	}


	private int down() {
		down = true;
		up = false;
		left = false;
		right = false;
		
		while(!validLoc(algoMove)) {
			
			if(algoMove >= 0 && algoMove < 100) {
				algoMove += 10;
			}
			if(algoMove > 99) {
				algoMove -= 10;
				up();
			}
		}
	return algoMove;
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
	
	public boolean validLoc(int a) {
		for(int i : shotsFired) {
			if(i == a) {
				return false;
			}
		if(a < 0 || a > 99) {
			return false;
		}
		}
	return true;
	}
	
		
	private int getRandNum(int min, int max) {
		down = false;
		up = false;
		left = false;
		right = false;
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;	
	}
}
