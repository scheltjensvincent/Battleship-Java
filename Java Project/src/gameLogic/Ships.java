package gameLogic;

import javax.swing.JOptionPane;

import gui.GameBoard;
import gui.Pane;

public class Ships {
	//define a constructor ship
	
	/* public void initShips() {
		int shipsOnBoard = 0;
		while(shipsOnBoard != 5) {
			for(int i = 5; i > 0; i--) {
				int length = i;
				JOptionPane.showMessageDialog(null, "Your First ship are " + length + " blocks");
				int initLoc = getInitialCell();
				placeShip(initLoc,length);
				shipsOnBoard++;	
			}
		}
		
	} */
	
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
	
	/* public void placeShip(int cell, int length) { //add direction functionality
		//cell = getInitialCell();
		//if(direction.equals("right"){						//direction set to the right, define this 3 times more
		for(int i = 0; i < length; i++) {
			GameBoard.setBtnColor(cell - 1 + length);
			GameBoard.addShipLocation(cell - 1 + length);  //in GameBoard define a method to write the location of the ship to an array/arraylist
															// it should be comparable to the JButtons that are clicked on by the user
			}
	} */
		
}
		
	
		


