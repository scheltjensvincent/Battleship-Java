package gameLogic;

import java.awt.Color;

import javax.swing.JButton;

/* 
 *
 */

public class Board {
	
	
	private JButton[][] board;
	
	//Set the constants to define rows and columns
	public static final int COLS = 10;
	public static final int ROWS = 10;
	
	
	
	public Board() {
		board = new JButton[COLS][ROWS];
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				this.board[i][j] = new JButton();
				
			}	
		}
	}

	
	//niet ok || locaties zouden beter worden weergegeven en opgehaald op een andere manier, 
	//dit is nogal omslachtig en wordt later te complex / onoverzichtelijk
	public JButton getCell(int x, int y) { 
		return board[x][y];
	}
	
	public void hit(int x, int y) {
		board[x][y].setBackground(Color.red);
		
	}
	
	public void miss(int x, int y) {
		board[x][y].setBackground(Color.black);
	
	}
	
	
}
