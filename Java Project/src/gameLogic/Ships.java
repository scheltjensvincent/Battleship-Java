package gameLogic;

import javax.swing.JOptionPane;

import gui.GameBoard;

public class Ships {
	//define a constructor ship
	
	public int getInitialCell() { //instead of getting 1 value here, get the x and y values
		int cellValue = 0;
		boolean validPosition = false;
		
		while(!validPosition) {
		String cell = JOptionPane.showInputDialog(null, "Enter the coordinates without the comma");
			if (cell != null) {
				try { 
					cellValue = Integer.valueOf(cell);
						if (cellValue >= 00 && cellValue < 100) {
							validPosition = true;
						} else {
							JOptionPane.showMessageDialog(null, "Please Enter a positive and valid location ranging from 00 - 99 or 1010!");
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
	
	public void placeShip(int cell, int length) { //add direction functionality
		cell = getInitialCell();
		for(int i = 0; i < length; i++) {
			GameBoard.setBtnColor(cell - 1 + length);
			GameBoard.addShipLocation(cell - 1 + length);
		}
		
	}
		
	
		
}

