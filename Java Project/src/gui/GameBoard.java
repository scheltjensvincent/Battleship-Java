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

import java.util.Random;
import gameLogic.*;

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
					tempBtnList[i][j] = new JButton((i) + "" + (j));
					tempBtnList[i][j].setPreferredSize(new Dimension(100,100));
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
	
	
	public void startBoard(int player) {
		if(player == 1) {
			String name = askName();
			String welcome = "Welcome " + name + "! \n" + "Before we can start you'll first have to place your boats.";
			JOptionPane.showMessageDialog(null, welcome);
			
			//initShips(player);
		} /*else {
			initShips(player);
		} */
	}
	
	private String askName() {
		String name = JOptionPane.showInputDialog("What is your name?");
		
		return name;
	}

	
	public void resetBoard() {
		
	}
	
	
	//sets the JButton Color of a JButton to blue for where a ship is.
	public void setBtnColor(int row, int col) { 		
		btnList[row][col].setBackground(Color.blue);
		 
	}
	
	public void setLblColor(int row, int col) { 		
		btnList[row][row].setForeground(Color.white);
	}
	
	public void placeShipGuiBoard(Ship ship) {
		for (int i = ship.getStartco().get_row(); i < ship.getEndco().get_row(); i++) {
			for (int j = ship.getStartco().get_col(); j < ship.getEndco().get_col(); j++) {
				setBtnColor(i, j);
				setLblColor(i, j);
			}
		}	
	}
	
	
	/*
	public void initShips(int player) { // should be in the ships class and placeShip as well
		int shipsOnBoard = 0;
		if(player == 1) {
			while(shipsOnBoard != 5) {
				for(int i = 5; i > 0; i--) {
					int length = i;
					int nrShip = 6 - i;
					
					//generate one ship 
					

					shipsOnBoard++;	
				}
			}
		} else { 
			while(shipsOnBoard != 5) { // delete WHILE LOOP + hierboven ook
				for(int i = 5; i > 0; i--) {
					int length = i;
					int initLoc = getRandNum(0, 100);
					int direction = getRandNum(1, 5);
					placeShip(initLoc,length, direction, player);
					shipsOnBoard++;	
				}
			}
		}
	} */
	
	private static int getRandNum(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
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
	
}
	

	
	
	



