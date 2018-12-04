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
	public JPanel board;
	public JButton[][] btnList;
	
	public GameBoard(JPanel board, JButton[][] btnList) {
		this.board = board;
		this.btnList = btnList;
	}
	
	public static GameBoard createGrid(int row, int col) {
			
			JButton[][] btnList = new JButton[row][col];
			JPanel board = new JPanel();
			board.setLayout(new GridLayout(row, col));
			
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					btnList[i][j] = new JButton(i + ", " + j);
					btnList[i][j].setPreferredSize(new Dimension(40,40));
					btnList[i][j].setOpaque(true);
					btnList[i][j].setBackground(Color.gray);
					//btnList[i][j].setContentAreaFilled(false);
					
					btnList[i][j].setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black, 1), BorderFactory.createLineBorder(Color.gray, 3)));
					
					board.add(btnList[i][j]);
					
				}
			}
			
			GameBoard objBoard = new GameBoard(board, btnList);
			return objBoard;
			
	}
	
	public JButton getLocation(int i, int j) {
		return btnList[i][j];
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
		setBoats();
	}
	
	private String askName() {
		String name = JOptionPane.showInputDialog("What is your name?");
		
		return name;
	}
	
	private void placeBoats() {
		JOptionPane.showMessageDialog(null, "First boat: 5 blocks");
		
		
		//GlassPane myGlassPane = new GlassPane();
			
	}
	
	public static void setBoats() {
		for (int i = 0; i < 4; i++ ) {
			//btnList[i][0] = new JButton();
		}
	}

	
	public void resetBoard() {
		
	}
}
	
//JOptionPane.showMessageDialog(null, new JLabel("enter the coordinates"));	
	
	
	



