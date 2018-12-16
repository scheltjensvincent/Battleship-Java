package gameLogic;

import java.util.*;

public class Board {
	private final int BOARD_SIZE;
	private int[][] board;
	private int maxScore;
	private int scoreOpponent;
	
	private Ship carrier;
	private Ship battleship;
	private Ship cruiser;
	private Ship submarine;
	private Ship destroyer;
	
	ArrayList<Ship> ships = new ArrayList<Ship>();
	
	public Board(int board_size) {
		this.BOARD_SIZE = board_size;
		board = new int[BOARD_SIZE][BOARD_SIZE];
	}
	
	public int[][] getBoard() {
		return this.board;
	}
	
	public int getOppenentScore() {
		return this.scoreOpponent;
	}
	
	public int getMaxScore() {
		return this.maxScore;
	}
	
	public ArrayList<Ship> getShips(){
		ArrayList<Ship> ships = new ArrayList<Ship>();
		ships.add(carrier);
		ships.add(battleship);
		ships.add(cruiser);
		ships.add(submarine);
		ships.add(destroyer);
		return ships;
	}
	
	public void incrementMaxScore() {
		this.maxScore++;
	}
	
	public void incrementScoreOpponent() {
		this.scoreOpponent++;
	}
	
	public boolean addShip(Ship ship) {
		if (checkConstraints(ship) == true) {
			for (int i = ship.getStartco().get_row(); i <= ship.getEndco().get_row(); i++) {
				for (int j = ship.getStartco().get_col(); j <= ship.getEndco().get_col(); j++) {
						this.getBoard()[i][j] = 1;
						this.incrementMaxScore();
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
			this.getBoard()[coordinate.get_row()][coordinate.get_col()] = -1;
			this.incrementScoreOpponent();
			//System.out.println(scoreOpponent);
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean getShotFired() {
		return true;
	}
	
	public boolean opponentWon() {
		if (this.getOppenentScore() == this.getMaxScore()) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
