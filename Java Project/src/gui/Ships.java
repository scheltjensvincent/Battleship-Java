package gui;

import javax.swing.JOptionPane;

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
					JOptionPane.showMessageDialog(null, "Please Enter a Valid Loction!");
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
		String dir = JOptionPane.showInputDialog(null, "Direction: Enter 1 for 'Right', 2 for 'Left', 3 for 'Up' or 4 for 'Down'");
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
				direction = -1;
				validDir = true;
			}
			
		}
	return direction;
	}
	
	// we first want to construct a shape based on the entered data, then we want to check whether the the ship can still
	// be placed on the board
	// ship: start_coordinate(X, Y) & end_coordinate(X,Y)
	
}
		
	
		


