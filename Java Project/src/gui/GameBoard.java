package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameBoard {
	JPanel board;
	JButton[][] btnList;
	
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
					btnList[i][j].setContentAreaFilled(false);
					
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
	
	
}
	
	
	
	
	



