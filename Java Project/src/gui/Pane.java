package gui;

import javax.swing.*;

import battleship.Game;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class Pane extends JPanel {
	private static final long serialVersionUID = -7518568006313720524L;
	private JLabel lblDivider;
	private JButton btnStart;
	private JButton btnStop;
	private JButton btnRestart;
	private JLabel lblCompScore = new JLabel("Computer's score: 0"); 
	private JLabel lblPlayerScore =  new JLabel("Your score: 0");
	private JLabel lblPreviousScores = new JLabel("Previous Scores:");
	private JLabel welcomeOfGame; 
	
	private GameBoard computerPanel = new GameBoard(Game.getBoardSize());
	private GameBoard humanPanel = new GameBoard(Game.getBoardSize());
	
	private Game game = new Game(getComputerPanel(), getHumanPanel(), getHumanScore(), getComputerScore(), getPreviousScores());
	
	
	public Pane() {
		setLayout(new GridBagLayout());
		setPreferredSize(new Dimension(700, 800));
		
		initialize();
	}
	
	public void initialize() {
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
			reset();
			}	
		});
		
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			}	
		});
		
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
		add(game.getLblComputerScore(), paneConstraints);
		game.getLblComputerScore().setVisible(false);

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
		add(game.getLblHumanScore(), paneConstraints);
		game.getLblHumanScore().setVisible(false);
	}
	
	public void reset() {
		SwingUtilities.invokeLater(new Runnable() {
			   public void run() {
				   computerPanel = new GameBoard(Game.getBoardSize());
				   humanPanel = new GameBoard(Game.getBoardSize());
				   lblCompScore = new JLabel("Computer's score: 0"); 
				   lblPlayerScore =  new JLabel("Your score: 0");
				   lblPreviousScores = new JLabel("Previous Scores:");
				   game = new Game(getComputerPanel(), getHumanPanel(), getHumanScore(), getComputerScore(), getPreviousScores());
				  
				   removeAll();
				   repaint();
				   revalidate();
		
				   initialize();
			   }
		});
	}
	
	public GameBoard getHumanPanel() {
		return this.humanPanel;
	}
	
	public GameBoard getComputerPanel() {
		return this.computerPanel;
	}
	
	public JLabel getHumanScore() {
		return this.lblPlayerScore;
	}
	
	public JLabel getComputerScore() {
		return this.lblCompScore;
	}
	
	public JLabel getPreviousScores() {
		return this.lblPreviousScores;
	}
}





