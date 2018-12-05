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
					//btnList[i][j].setContentAreaFilled(false);
					
					
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
	
	/*public void addHumanEventListeners() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				btnList[i][j].addActionListener(new BoatButtonListener());
			}
		}
	} */
	
	public void startBoard() {
		String name = askName();
		String welcome = "Welcome " + name + "! \n" + "Before we can start you'll first have to place your boats.";
		JOptionPane.showMessageDialog(null, welcome);
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
			
	} */
	
	/* public static void setBoats() {
		for (int i = 0; i < 4; i++ ) {
			//btnList[i][0] = new JButton();
		}
	} */

	
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
	
	public static void addShipLocation(int a) {
		//define that the locations should be added to some list array or something similar to  the JButton Array
	}
		
		
		
		
		
}
	

	
	
	



