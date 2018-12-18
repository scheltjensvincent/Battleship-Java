package gui;

import javax.swing.JOptionPane;

import gameLogic.Coordinates;
import gameLogic.Ship;

public class Ships {
	public static int getInitialCell() { //instead of getting 1 value here, get the x and y values
		int cellValue = 0;
		boolean validPosition = false;
		
		while(!validPosition) {
		String cell = JOptionPane.showInputDialog(null, "Give the number of the cell where you would like to initialize your ship.");
			if (cell != null) {
				try { 
					cellValue = Integer.valueOf(cell);
						if (cellValue >= 00 && cellValue < 100) {
							validPosition = true;
						} else {
							JOptionPane.showMessageDialog(null, "Please Enter a positive and valid location ranging from 00 - 99");
						}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please Enter a Valid Location!");
					validPosition = false;
				}
			} else {
				cellValue = -1;
				validPosition = true;
			}
			
		}
		return cellValue;
	}
	
	public static int getDirection() {
		int direction = 0;
		boolean validDir = false; 
		
		while(!validDir) {
		String dir = JOptionPane.showInputDialog(null, "Direction:\n" + "Enter 1 for 'Right'\n" + "Enter 2 for 'Left'\n" + "Enter 3 for 'Up'\n" + "Enter 4 for 'Down'");
			if(dir != null) {
				try { 
					direction = Integer.valueOf(dir);
						if (direction >= 1 && direction< 5) {
							validDir = true;
						} else {
							JOptionPane.showMessageDialog(null, "Please Enter a positive and valid location ranging from 1 to 4");
						}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please Enter a Valid Direction!");
					validDir = false;
				}
			} else {
				direction = 1;
				validDir = true;
			}
			
		}
		return direction;
	}
	
	
	public static Ship getOneShip(int length) {
		Ship ship;
		ship = new Ship();
		
		JOptionPane.showMessageDialog(null, "Ship " + " exists out of: "  + length + " blocks");
		
		Coordinates initialCo = Coordinates.parseIntoCoordinates(getInitialCell());
		int direction = getDirection();
		
		Coordinates startCo = new Coordinates();
		Coordinates endCo = new Coordinates();
		
		length--;
		
		if(direction == 1){
			ship.setStartco(initialCo);
			endCo.set_row(initialCo.get_row());
			endCo.set_col(initialCo.get_col() + length);
			ship.setEndco(endCo);	
		}
		else if(direction == 2){
			startCo.set_row(initialCo.get_row());
			startCo.set_col(initialCo.get_col() - length);
			ship.setStartco(startCo);
			ship.setEndco(initialCo);;
		}
		else if(direction == 3){						
			startCo.set_row(initialCo.get_row() - length);
			startCo.set_col(initialCo.get_col());
			ship.setStartco(startCo);
			ship.setEndco(initialCo);
		}
		else if(direction == 4){
			ship.setStartco(initialCo);
			endCo.set_row(initialCo.get_row() + length);
			endCo.set_col(initialCo.get_col());
			ship.setEndco(endCo);
		}
		
		return ship;
	}
	
}
		
	
		


