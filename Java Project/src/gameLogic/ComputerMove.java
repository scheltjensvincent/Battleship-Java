package gameLogic;

import java.util.ArrayList;
import java.util.Random;

/*
 * Based on the difficulty selected by the player the computer moves are generated here
 */

public class ComputerMove {
	
	//initializing variables
	private int compMove;
	private int algoMove = 0;
	private boolean hit;
	private boolean down;
	private boolean up;
	private boolean left;
	private boolean right;
	
	//Array list to keep track of the moves made
	private ArrayList<Integer> shotsFired = new ArrayList<Integer>();
	
	
	//empty constructor used in the Game class to call the method compMove from this class
	public ComputerMove() {
		
	}
	
	
	//Gets and returns the computer move based on the difficulty
	public int compMove(int dificulty) {
		if(dificulty == 1) {
			compMove = randomValue();
		}
		if(dificulty == 2) {
			compMove = algorithmOne();
		}
		return compMove;
	}
	
	//Random value generation and check if already used
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
	
	
	/*
	 * Hunt & Target algorithm implementation
	 * Generates random moves until hit is registered
	 * When a hit is registered go down, up, right or left to take out the entire ship
	 * When looped through this sequence and no hits anymore get new random moves until a new hit is registered
	 * This can be made more efficient by checking the diagonals from large -> small when no hits are made
	 */
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
	return algoMove;
	}
	

	//Check whether a move hit a ship or not and act accordingly
	public void hit(boolean hitShot) {
		if(hitShot) {
			hit = true;
		} else {
			hit = false;
		}
	}
	
	
	//When invoked passes a move that coincides with the position left from the prior move
	//Gets called last in the algorithmOne() method so when this would go under 0 a new random move is passed
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

	
	//When invoked passes a move that coincides with the position right from the prior move
	//invokes left() when moves over 99 would be passed
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


	//When invoked passes a move that coincides with the position upwards from the prior move
	//when moves under zero would be passed right() is invoked
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
				right();
			}
		}	
		return algoMove;
	}
	

	//When invoked passes a move that coincides with the position downwards from the prior move
	//When moves under zero would be passed up() is invoked
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
	
	
	//makes an initial check for the move that is about to be passed not to be already made before
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
	
	
	public int getCompMove() {
		return this.compMove;
	}
	
	
	//random number generated and initializes the booleans all to false	
	private int getRandNum(int min, int max) {
		down = false;
		up = false;
		left = false;
		right = false;
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;	
	}
}
