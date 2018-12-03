package gui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameBoard {
	JPanel board;
	JButton[][] btnList;
	
	public GameBoard(JPanel board, JButton[][] btnList) {
		this.board = board;
		this.btnList = btnList;
	}
}
