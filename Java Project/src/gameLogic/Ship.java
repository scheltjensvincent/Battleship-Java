package gameLogic;

import java.util.Random;

/*
 * Defines a ship based on the coordinates and generates the random ships for the computer
 */

public class Ship {
	
	//declaration of the objects and variables
	private Coordinates startco;
	private Coordinates endco;

	private String name;
	
	
	
	
	public Ship() {
		
	}
	
	
	//defines a ship
	public Ship(Coordinates startCo, Coordinates endCo) {
		this.setStartco(startCo);
		this.setEndco(endCo);
	}
	
	
	//defines a ship
	public Ship(String name, Coordinates startCo, Coordinates endCo) {	
		this.setStartco(startCo);
		this.setEndco(endCo);
		this.setName(name);
	}	
	
	
	//random ship generation and placement for the computer
	public static Ship getRandomShip(int length, int board_size) {
		Coordinates rndStartco = new Coordinates();
		Coordinates rndEndco = new Coordinates();
		
		int direction = getRandNum(1, 2); //1 is right, 2 is down
		
		if (direction == 1) {
			rndStartco.set_row(getRandNum(0, board_size));
			rndStartco.set_col(getRandNum(0, board_size - length));
			rndEndco.set_row(rndStartco.get_row());
			rndEndco.set_col(rndStartco.get_col() + length - 1);
			
		}
		else {
			rndStartco.set_col(getRandNum(0, board_size));
			rndStartco.set_row(getRandNum(0, board_size - length));
			rndEndco.set_col(rndStartco.get_col());
			rndEndco.set_row(rndStartco.get_row() + length - 1);
		}
		
		Ship ship = new Ship(rndStartco, rndEndco);
		
		return ship;
	}
	
	
	//getters and setter for this class
	private static int getRandNum(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;	
	}
	
	public void setStartco(Coordinates startCo) {
		this.startco = startCo;
	}
	
	public void setEndco(Coordinates endCo) {
		this.endco = endCo;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Coordinates getStartco() {
		return this.startco;
	}
	
	public Coordinates getEndco() {
		return this.endco;
	}
	
	public String getName() {
		return this.name;
	}
}
