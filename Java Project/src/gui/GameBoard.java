package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import gameLogic.Ships;

public class GameBoard {
	private JPanel board;
	private JButton[][] btnList;
	
	public GameBoard(JPanel b, JButton[][] l) {
		this.setBoard(b);
		this.setBtnList(l);
	}
	
	public static GameBoard createGrid(int row, int col) {
			
			JButton[][] tempBtnList = new JButton[row][col];
			JPanel tempBoard = new JPanel();
			tempBoard.setLayout(new GridLayout(row, col));
			
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					tempBtnList[i][j] = new JButton(i + "" + j );
					tempBtnList[i][j].setPreferredSize(new Dimension(40,40));
					tempBtnList[i][j].setOpaque(true);
					tempBtnList[i][j].setBackground(Color.gray);
					tempBtnList[i][j].setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black, 1), BorderFactory.createLineBorder(Color.gray, 3)));
					tempBoard.add(tempBtnList[i][j]);
					
				}
			}
			
			GameBoard objBoard = new GameBoard(tempBoard, tempBtnList);
			return objBoard;
			
	}
	
	
	public void addComputerEventListeners() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				btnList[i][j].addActionListener(new ButtonListener());
			}
		}
	}
	
	/*
	public void addHumanEventListeners() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				btnList[i][j].addActionListener(new BoatButtonListener());
			}
		}
	} 
	*/
	
	public void startBoard() {
		String name = askName();
		String welcome = "Welcome " + name + "! \n" + "Before we can start you'll first have to place your boats.";
		JOptionPane.showMessageDialog(null, welcome);
		initShips();
		//placeBoats();
	}
	
	private String askName() {
		String name = JOptionPane.showInputDialog("What is your name?");
		
		return name;
	}
	/*
	private void placeBoats() {
		JOptionPane.showMessageDialog(null, "First boat: 5 blocks");
		JOptionPane.showInputDialog(null, new JLabel("Enter the coordinates"));	
		GlassPane myGlassPane = new GlassPane();
			
	} 
	*/
	
	/* 
	public static void setBoats() {
		for (int i = 0; i < 4; i++ ) {
			//btnList[i][0] = new JButton();
		}
	} 
	*/

	
	public void resetBoard() {
		
	}
	
	public JPanel getBoard() {
		return this.board;
	}
	
	public JButton[][] getBtnList() {
		return this.btnList;
	}
	
	public void setBoard(JPanel panel) {
		this.board = panel;
	}
	
	public void setBtnList(JButton[][] list) {
		this.btnList = list;
	}
	
	//sets the JButton Color of a JButton to blue for where a ship is.
	public void setBtnColor(int cell) { 
		int i = Integer.parseInt(Integer.toString(cell).substring(0, 1)); //gets the first digit
		int j = Integer.parseInt(Integer.toString(cell).substring(1)); //gets the second digit
		btnList[i][j].setBackground(Color.blue);
		
		// link int a to the coordinates of a JButton
		// this is used in the setShips method
	}
	
	public void setLblColor(int cell) { 
		int i = Integer.parseInt(Integer.toString(cell).substring(0, 1)); //gets the first digit
		int j = Integer.parseInt(Integer.toString(cell).substring(1)); //gets the second digit
		btnList[i][j].setForeground(Color.white);
	}
	
	public static void addShipLocation(int a) {
		//define that the locations should be added to some list array or something similar to  the JButton Array
	}
	
	public void initShips() { // should be in the ships classand placeShip as well
		int shipsOnBoard = 0;
		while(shipsOnBoard != 5) {
			for(int i = 5; i > 0; i--) {
				int length = i;
				int nrShip = 6 - i;
				JOptionPane.showMessageDialog(null, "Ship " + nrShip +  " exists out of: "  + length + " blocks");
				int initLoc = Ships.getInitialCell();
				//String[] direction = Ships.getRotation();
				placeShip(initLoc,length); // input rotation here
				shipsOnBoard++;	
			}
		}
		
	}
	
	public void placeShip(int cell, int length) { //add direction functionality
		//cell = getInitialCell();
		//if(direction.equals("right"){						//direction set to the right, define this 3 times more
		for(int i = 0; i < length; i++) {
			setBtnColor(cell + i);
			setLblColor(cell + i );
			addShipLocation(cell + i);  //in GameBoard define a method to write the location of the ship to an array/arraylist
															// it should be comparable to the JButtons that are clicked on by the user
			}
	} 
		
}
	

	
	
	



