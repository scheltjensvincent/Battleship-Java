package gameLogic;

import java.util.*;

public class Board {
	private final int BOARD_SIZE;
	private final int MAX_SCORE;
	private int[][] board;
	private int scoreOpponent = 0;
	
	ArrayList<Ship> ships = new ArrayList<Ship>();
	
	public Board(int board_size, int max_score) {
		this.BOARD_SIZE = board_size;
		board = new int[BOARD_SIZE][BOARD_SIZE];
		this.MAX_SCORE = max_score;
	}
	
	public int[][] getBoard() {
		return this.board;
	}
	
	public int getOppenentScore() {
		return this.scoreOpponent;
	}
	
	public ArrayList<Ship> getShips(){
		return this.ships;
	}
	
	public void incrementScoreOpponent() {
		this.scoreOpponent++;
	}
	
	public boolean addShip(Ship ship) {
		if (checkConstraints(ship) == true) {
			for (int i = ship.getStartco().get_row(); i <= ship.getEndco().get_row(); i++) {
				for (int j = ship.getStartco().get_col(); j <= ship.getEndco().get_col(); j++) {
						this.getBoard()[i][j] = 1;
				}		
			}
			ships.add(ship);
			return true;
		}
		else {
			return false;
		}	
		
	}
	
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
	
	public boolean hit(Coordinates coordinate) {
		if (board[coordinate.get_row()][coordinate.get_col()] == 1) {
			this.getBoard()[coordinate.get_row()][coordinate.get_col()] = -1; //-1 is a hit
			this.incrementScoreOpponent();
			return true;
		} else {
			this.getBoard()[coordinate.get_row()][coordinate.get_col()] = 9; //9 is no hit
			return false;
		}
		
	}
	
	public boolean opponentWon() {
		if (this.getOppenentScore() == this.MAX_SCORE) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
