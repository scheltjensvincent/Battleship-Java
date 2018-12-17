package gui;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import gameLogic.*;

public class GameBoard {
	private final int BOARD_SIZE;
	private JPanel board;
	private JButton[][] btnList;
	
	private boolean shipManualShipGeneration;

	public GameBoard(int board_size) {
		this.BOARD_SIZE = board_size;
		this.setBoard(new JPanel());
		this.getBoard().setLayout(new GridLayout(this.getBoardSize(), this.getBoardSize()));
		this.setBtnList(new JButton[this.getBoardSize()][this.getBoardSize()]);
	}
	
	public void createGrid() {
			for (int i = 0; i < this.getBoardSize(); i++) {
				for (int j = 0; j < this.getBoardSize(); j++) {
					this.getBtnList()[i][j] = new JButton((i) + "" + (j));
					this.getBtnList()[i][j].setPreferredSize(new Dimension(100,100));
					this.getBtnList()[i][j].setOpaque(true);
					this.getBtnList()[i][j].setBackground(Color.gray);
					this.getBtnList()[i][j].setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black, 1), BorderFactory.createLineBorder(new Color(255, 255, 255, 0), 3)));
					this.getBoard().add(this.getBtnList()[i][j]);
				}
			}
	}
	
	public void startBoard() {
		String name = askName();
		String welcome = "Welcome " + name + "! \n" + "Before we can start you'll first have to place your boats.";
		JOptionPane.showMessageDialog(null, welcome);
		
		int dialogButton = JOptionPane.YES_NO_OPTION;
		String str = "Click YES, if you want to place yours ships manually. \n" + "Click NO, if you want them to be placed for you." ;
		int dialogResult = JOptionPane.showConfirmDialog(null, str, "Ship placement", dialogButton);
		
		if(dialogResult == 0) {
			this.shipManualShipGeneration = true;
		}
		else {
			this.shipManualShipGeneration = false;
		} 
		
		
	}
	
	private String askName() {
		String name = JOptionPane.showInputDialog("What is your name?");
		return name;
	}
	
	public static void printError() {
		JOptionPane.showMessageDialog(null, "The boat was not placed correctly, please choose another position.");
	}
	
	public void resetBoard() {
		
	}
	
	
	//sets the JButton Color of a JButton to blue for where a ship is.
	public void setBtnColor(int row, int col) { 		
		this.getBtnList()[row][col].setBackground(Color.blue);
	}
	
	public void setLblColor(int row, int col) { 		
		this.getBtnList()[row][col].setForeground(Color.white);
	}
	
	public void placeShipGuiBoard(Ship ship) {
		for (int i = ship.getStartco().get_row(); i <= ship.getEndco().get_row(); i++) {
			for (int j = ship.getStartco().get_col(); j <= ship.getEndco().get_col(); j++) {
				setBtnColor(i, j);
				setLblColor(i, j);
			} 
		}
	}
	
	public void enableBtns(boolean bln, int[][] board) {
		for (int i = 0; i < this.getBoardSize(); i++) {
			for (int j = 0; j < this.getBoardSize(); j++) {
				if (board[i][j] == 0 || board[i][j] == 1) {
					this.getBtnList()[i][j].setEnabled(bln);
				}
			}
		}
	}
	
	public JPanel getBoard() {
		return this.board;
	}
	
	public JButton[][] getBtnList() {
		return this.btnList;
	}
	
	public int getBoardSize() {
		return this.BOARD_SIZE;
	}
	
	public boolean getshipManualShipGeneration() {
		return this.shipManualShipGeneration;
	}
	
	public void setBoard(JPanel panel) {
		this.board = panel;
	}
	
	public void setBtnList(JButton[][] list) {
		this.btnList = list;
	}
}
	

	
	
	



