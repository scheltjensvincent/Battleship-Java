package gameLogic;

import java.util.*;

/*
 * Allows for logic boards to be created and assigns 1 for the coordinates with parts of a ship,
 * -1 when a ship is hit and 9 when a shot was fired but it was a miss. The remaining locations are initialized to 0.
 * Checks the constraints for ship placement and checks hit / miss for the moves made.
 */

public class Board {

	//defining variables and objects
	private final int BOARD_SIZE;
	private final int MAX_SCORE;
	private int[][] board;
	private int scoreOpponent = 0;

	private ArrayList<Ship> ships = new ArrayList<Ship>();
	
	
	//defines a board
	public Board(int board_size, int max_score) {
		this.BOARD_SIZE = board_size;
		board = new int[BOARD_SIZE][BOARD_SIZE];
		this.MAX_SCORE = max_score;
	}


	public ArrayList<Ship> getShips(){
		return this.ships;
	}


	public void incrementScoreOpponent() {
		this.scoreOpponent++;
	}


	//adds a ship to the arraylist when no constraints are violated and assigns a value of 1 to the logic boards for all the ship coordinates
	public boolean addShip(Ship ship) {
		if (checkConstraints(ship) == true) {
			for (int i = ship.getStartco().get_row(); i <= ship.getEndco().get_row(); i++) {
				for (int j = ship.getStartco().get_col(); j <= ship.getEndco().get_col(); j++) {
					this.getBoard()[i][j] = 1;
				}		
			}
			ships.add(ship);
			return true;
		} else {
			return false;
		}	
	}


	//checks out of bound placement and overlap of ships about to be placed
	private boolean checkConstraints(Ship newShip) {
		if (newShip.getStartco().get_row() < 0) {
			return false;
		}

		if (newShip.getStartco().get_col() < 0) {
			return false;
		}

		if (newShip.getEndco().get_row() > BOARD_SIZE - 1) {
			return false;
		}

		if (newShip.getEndco().get_col() > BOARD_SIZE - 1) {
			return false;
		}

		for (int i = newShip.getStartco().get_row(); i <= newShip.getEndco().get_row(); i++) {
			for (int j = newShip.getStartco().get_col(); j <= newShip.getEndco().get_col(); j++) {
				if (this.getBoard()[i][j] == 1) {
					return false;
				}							
			}		
		}

		return true;
	}


	//checks whether a certain move / coordinate is a hit or a miss and avoids buttons being responsive after hits / misses
	public boolean hit(Coordinates coordinate) {
		if (board[coordinate.get_row()][coordinate.get_col()] == 1) {
			this.getBoard()[coordinate.get_row()][coordinate.get_col()] = -1; //-1 is a hit
			this.incrementScoreOpponent();
			//System.out.println(scoreOpponent);
			return true;
		} else {
			this.getBoard()[coordinate.get_row()][coordinate.get_col()] = 9; //9 is no hit
			return false;
		}

	}


	//defines when player or computer 
	public boolean opponentWon() {
		if (this.getOppenentScore() == this.MAX_SCORE) {
			return true;
		} else {
			return false;
		}
	}


	//getters and setters for this class
	public int[][] getBoard() {
		return this.board;
	}

	public int getOppenentScore() {
		return this.scoreOpponent;
	}

}
