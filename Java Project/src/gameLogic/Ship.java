package gameLogic;

import java.util.Random;

//import java.util.ArrayList;

public class Ship {
	private Coordinates startco;
	private Coordinates endco;
	//private ArrayList<Coordinates> coordinates = new ArrayList<Coordinates>();

	private String name;
	
	public Ship() {
		
	}
	
	public Ship(Coordinates startCo, Coordinates endCo) {
		this.setStartco(startCo);
		this.setEndco(endCo);
	}
	
	public Ship(String name, Coordinates startCo, Coordinates endCo) {	
		this.setStartco(startCo);
		this.setEndco(endCo);
		this.setName(name);
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
	
	public static Ship getRandomShip(int length, int board_size) {
		Coordinates rndStartco = new Coordinates();
		Coordinates rndEndco = new Coordinates();
		
		int direction = getRandNum(1, 2); //1 is naar rechts, 2 is naar beneden
		
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
	
	private static int getRandNum(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;	
	}
}
