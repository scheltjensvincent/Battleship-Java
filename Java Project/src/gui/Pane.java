package gui;

import javax.swing.*;

import battleship.Game;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

/*
 * Here the pane that serves as content for the JFrame is created and filled with all elements / objects.
 * The constraints for placements are set and listeners are added where needed.
 * When all placement is finished a call is made to start the program.
 */

public class Pane extends JPanel {
	private static final long serialVersionUID = -7518568006313720524L;
	
	//set and initialize (some) of the objects
	private JButton btnStart;
	private JButton btnStop;
	private JButton btnRestart;
	
	private JLabel lblDivider;
	private JLabel lblCompScore = new JLabel("Computer's hits: 0/17"); 
	private JLabel lblPlayerScore =  new JLabel("Your hits: 0/17");
	private JLabel lblHighScore = new JLabel("High Score:");
	private JLabel welcomeOfGame; 
	private JLabel lblYourBoard = new JLabel("Lower board: your ships");
	private JLabel lblComputerBoard = new JLabel("Upper board: computer's ships");
	
	private GameBoard computerPanel = new GameBoard(Game.getBoardSize());
	private GameBoard humanPanel = new GameBoard(Game.getBoardSize());
	
	private Game game = new Game(getComputerPanel(), getHumanPanel(), getHumanScore(), getComputerScore(), getHighScore());
	
	
	//Defines the layout and overall dimension
	public Pane() {
		setLayout(new GridBagLayout());
		setPreferredSize(new Dimension(700, 800));
		
		initialize();
	}
	
	
	//Creates and structures all visual content (grids, buttons, labels)
	public void initialize() {
		GridBagConstraints paneConstraints = new GridBagConstraints();
		
		//create grids
		computerPanel.createGrid();
		humanPanel.createGrid();
		
		//initialize buttons
		btnStart = new JButton("Start");
		btnStop = new JButton("Stop");
		btnRestart = new JButton("Restart");
		
		//Set objects to (in)visible / (dis)(en)abled and add listeners
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				humanPanel.getBoard().setVisible(true);
				lblDivider.setVisible(true);
				computerPanel.getBoard().setVisible(true);
				
				lblYourBoard.setVisible(true);
				lblComputerBoard.setVisible(true);
				
				lblCompScore.setVisible(true);
				lblPlayerScore.setVisible(true);
				lblHighScore.setVisible(true);
				
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
		
		//fill in the first column with the boards, labels and divider
		paneConstraints.gridx = 0;
		paneConstraints.gridy = 0;
		add(welcomeOfGame, paneConstraints);
		
		paneConstraints.gridx = 0;
		paneConstraints.gridy = 1;
		paneConstraints.insets = new Insets(0,0,5,0);  
		add(lblComputerBoard, paneConstraints);
		lblComputerBoard.setVisible(false);
		
		paneConstraints.gridx = 0;
		paneConstraints.gridy = 2;
		add(computerPanel.getBoard(), paneConstraints);
		computerPanel.getBoard().setVisible(false);
		
		paneConstraints.gridx = 0;
		paneConstraints.gridy = 3;
		paneConstraints.fill = GridBagConstraints.HORIZONTAL;
		add(lblDivider, paneConstraints);
		lblDivider.setVisible(false);
		
		paneConstraints.gridx = 0;
		paneConstraints.gridy = 4;
		add(humanPanel.getBoard(), paneConstraints);
		humanPanel.getBoard().setVisible(false);
		
		paneConstraints.gridx = 0;
		paneConstraints.gridy = 5;
		paneConstraints.insets = new Insets(5,0,0,0);
		add(lblYourBoard, paneConstraints);
		lblYourBoard.setVisible(false);
		
		paneConstraints.gridx = 0;
		paneConstraints.gridy = 6;
		paneConstraints.insets = new Insets(20,0,0,0);  
		add(game.getLblHighScore(), paneConstraints);
		game.getLblHighScore().setVisible(false);
		
		//fill the second column with the scores and options
		paneConstraints.gridx = 1;
		paneConstraints.gridy = 2;
		paneConstraints.insets = new Insets(0,20,0,0);  
		add(game.getLblComputerScore(), paneConstraints);
		game.getLblComputerScore().setVisible(false);

		paneConstraints.gridx = 1;
		paneConstraints.gridy = 0;
		add(btnStart, paneConstraints);	
		
		paneConstraints.gridx = 1;
		paneConstraints.gridy = 3;
		add(btnRestart, paneConstraints);
		btnRestart.setVisible(false);
		
		paneConstraints.gridx = 2;
		paneConstraints.gridy = 3;
		add(btnStop, paneConstraints);
		btnStop.setVisible(false);
		
		paneConstraints.gridx = 1;
		paneConstraints.gridy = 4;
		paneConstraints.insets = new Insets(0,20,0,0);  
		add(game.getLblHumanScore(), paneConstraints);
		game.getLblHumanScore().setVisible(false);
	}
	
	
	//Method that resets the game when restart is pressed
	public void reset() {
		SwingUtilities.invokeLater(new Runnable() {
			   public void run() {
				   computerPanel = new GameBoard(Game.getBoardSize());
				   humanPanel = new GameBoard(Game.getBoardSize());
				   lblCompScore = new JLabel("Computer's hits: 0/17"); 
				   lblPlayerScore =  new JLabel("Your hits: 0/17");
				   lblHighScore = new JLabel("High Score:");
				   game = new Game(getComputerPanel(), getHumanPanel(), getHumanScore(), getComputerScore(), getHighScore());
				  
				   removeAll();
				   repaint();
				   revalidate();
				   initialize();
			   }
		});
	}
	

	//getters and setter for different elements in this class
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
	
	public JLabel getHighScore() {
		return this.lblHighScore;
	}
}
