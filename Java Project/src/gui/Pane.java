package gui;

import javax.swing.*;
import java.awt.*;
//import java.util.*;

public class Pane extends JPanel {
	
	private JLabel lblDivider;
	private JButton btnStop;
	private JButton btnRestart;
	private JLabel lblCompScore; 
	private JLabel lblPlayerScore;
	private JLabel titleOfGame;
	
	public Pane() {
		
		setLayout(new GridBagLayout());
		setPreferredSize(new Dimension(700, 1000));
		GridBagConstraints paneConstraints = new GridBagConstraints();
		
		//create grids
		GameBoard computerPanel = createGrid(10);
		GameBoard humanPanel = createGrid(10);
		
		//create buttons
		btnStop = new JButton("Stop");
		btnRestart = new JButton("Restart");
		
		//create labels
		lblCompScore = new JLabel("Computer Score: "); //definieer een variabele compScore en voeg + compScore toe
		lblPlayerScore = new JLabel("Your Score: "); //definieer een variabele playerScore en voeg + playerScore toe
		titleOfGame = new JLabel("Battleship");
		
		//create divider
		lblDivider = new JLabel(" ");
		lblDivider.setOpaque(true);
		lblDivider.setBackground(Color.black);
		
		//fill in the first column with the boards and divider
		paneConstraints.gridx = 0;
		paneConstraints.gridy = 0;
		add(titleOfGame, paneConstraints);
		
		paneConstraints.gridx = 0;
		paneConstraints.gridy = 1;
		add(computerPanel.board, paneConstraints);
		
		paneConstraints.gridx = 0;
		paneConstraints.gridy = 2;
		paneConstraints.fill = GridBagConstraints.HORIZONTAL;
		add(lblDivider, paneConstraints);
		
		paneConstraints.gridx = 0;
		paneConstraints.gridy = 3;
		add(humanPanel.board, paneConstraints);
		
		//fill the second column with the scores and options
		paneConstraints.gridx = 1;
		paneConstraints.gridy = 1;
		paneConstraints.insets = new Insets(0,20,0,0);  
		add(lblCompScore, paneConstraints);

		paneConstraints.gridx = 1;
		paneConstraints.gridy = 2;
		add(btnRestart, paneConstraints);
				
		paneConstraints.gridx = 2;
		paneConstraints.gridy = 2;
		add(btnStop, paneConstraints);
		
		paneConstraints.gridx = 1;
		paneConstraints.gridy = 3;
		paneConstraints.insets = new Insets(0,20,0,0);  
		add(lblPlayerScore, paneConstraints);
		
	}
	
	private static GameBoard createGrid(int BoardSize) {
		
		JButton[][] btnList = new JButton[BoardSize][BoardSize];
		JPanel board = new JPanel();
		board.setLayout(new GridLayout(BoardSize, BoardSize));
		
		for (int i = 0; i < BoardSize; i++) {
			for (int j = 0; j < BoardSize; j++) {
				JButton btn = new JButton(i + ", " + j);
				btn.setPreferredSize(new Dimension(40,40));
				btn.setOpaque(true);
				btn.setBackground(Color.gray);
				btn.setContentAreaFilled(false);
				
				// Probleem: door onderstaande border aan te maken kan je precies niet meer op de knop klikken?
				//Antwoord: je overschrijft het standaard effect van een aanklikbare JButton, de actie wordt nog wel waargenomen maar niet visueel weergegeven. 
				btn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black, 1), BorderFactory.createLineBorder(Color.gray, 5)));
				btnList[i][j] = btn;
				board.add(btn);
				
			}
		}
		
		GameBoard objBoard = new GameBoard(board, btnList);
		
		return objBoard;
	}

}
