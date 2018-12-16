package gui;

import javax.swing.*;

import battleship.Game;
import gameLogic.Ship;
import gameLogic.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.util.*;

public class Pane extends JPanel {
	
	private final int BOARD_SIZE = 10;
	private JLabel lblDivider;
	private JButton btnStart;
	private JButton btnStop;
	private JButton btnRestart;
	private JLabel lblCompScore; 
	private JLabel lblPlayerScore;
	private JLabel welcomeOfGame; 
	
	public GameBoard computerPanel = new GameBoard(BOARD_SIZE);
	public GameBoard humanPanel = new GameBoard(BOARD_SIZE);
	
	public Board gameLogicHumanBoard = new Board(BOARD_SIZE);
	public Board gameLogicComputerBoard = new Board(BOARD_SIZE);
	public int[] shipSizes = new int[] {5, 4, 3, 3, 2};
	private Game game = new Game(getComputerPanel(), getHumanPanel(), getGameLogicHumanBoard(), getGameLogicComputerBoard(), getShipSizes() );
	
	public Pane() {
		
		setLayout(new GridBagLayout());
		setPreferredSize(new Dimension(700, 800));
		GridBagConstraints paneConstraints = new GridBagConstraints();
		
		//create grids
		computerPanel.createGrid();
		humanPanel.createGrid();
		
		//create buttons
		btnStart = new JButton("Start");
		btnStop = new JButton("Stop");
		btnRestart = new JButton("Restart");
		
		//methods for the visibility and enabling should still be written
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				humanPanel.getBoard().setVisible(true);
				lblDivider.setVisible(true);
				computerPanel.getBoard().setVisible(true);
				
				lblCompScore.setVisible(true);
				lblPlayerScore.setVisible(true);
				
				btnRestart.setVisible(true);
				btnStop.setVisible(true);
				btnStart.setVisible(false);
				
				btnRestart.setEnabled(false);
				btnStop.setEnabled(false);
				
				welcomeOfGame.setVisible(false);
				btnStop.setEnabled(true);
				btnRestart.setEnabled(true);
				
				game.startProgram();			
			}	
		});
		
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			humanPanel.resetBoard();
			computerPanel.resetBoard();
			}	
		});
		
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			}	
		});
		
		
		//create labels
		lblCompScore = new JLabel("Computer Score: "); //definieer een variabele compScore en voeg + compScore toe
		lblPlayerScore = new JLabel("Your Score: "); //definieer een variabele playerScore en voeg + playerScore toe
		welcomeOfGame = new JLabel("Welcome to the Battleship game, hit start to play!");
		
		//create divider
		lblDivider = new JLabel(" ");
		lblDivider.setOpaque(true);
		lblDivider.setBackground(Color.black);
		
		//fill in the first column with the boards and divider
		paneConstraints.gridx = 0;
		paneConstraints.gridy = 0;
		add(welcomeOfGame, paneConstraints);
		
		paneConstraints.gridx = 0;
		paneConstraints.gridy = 1;
		add(computerPanel.getBoard(), paneConstraints);
		computerPanel.getBoard().setVisible(false);
		
		paneConstraints.gridx = 0;
		paneConstraints.gridy = 2;
		paneConstraints.fill = GridBagConstraints.HORIZONTAL;
		add(lblDivider, paneConstraints);
		lblDivider.setVisible(false);
		
		paneConstraints.gridx = 0;
		paneConstraints.gridy = 3;
		add(humanPanel.getBoard(), paneConstraints);
		humanPanel.getBoard().setVisible(false);
		
		//fill the second column with the scores and options
		paneConstraints.gridx = 1;
		paneConstraints.gridy = 1;
		paneConstraints.insets = new Insets(0,20,0,0);  
		add(lblCompScore, paneConstraints);
		lblCompScore.setVisible(false);

		paneConstraints.gridx = 1;
		paneConstraints.gridy = 0;
		add(btnStart, paneConstraints);
				
		
		paneConstraints.gridx = 1;
		paneConstraints.gridy = 2;
		add(btnRestart, paneConstraints);
		btnRestart.setVisible(false);
		
		paneConstraints.gridx = 2;
		paneConstraints.gridy = 2;
		add(btnStop, paneConstraints);
		btnStop.setVisible(false);
		
		paneConstraints.gridx = 1;
		paneConstraints.gridy = 3;
		paneConstraints.insets = new Insets(0,20,0,0);  
		add(lblPlayerScore, paneConstraints);
		lblPlayerScore.setVisible(false);
		
	}
	
	public GameBoard getHumanPanel() {
		return this.humanPanel;
	}
	
	public GameBoard getComputerPanel() {
		return this.computerPanel;
	}
	
	public Board getGameLogicHumanBoard() {
		return this.gameLogicHumanBoard;
	}
	
	public Board getGameLogicComputerBoard() {
		return this.gameLogicComputerBoard;
	}
	
	public int[] getShipSizes() {
		return this.shipSizes;
	}
	
	
	
}





