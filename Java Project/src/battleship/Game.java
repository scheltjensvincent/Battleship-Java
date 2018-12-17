package battleship;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import gameLogic.*;
import gui.*;

public class Game {
	private final static int BOARD_SIZE = 10;
	private final int[] SHIP_SIZES = new int[] {5, 4, 3, 3, 2};
	private final int MAX_SCORE = 17;
	
	private GameBoard computerPanel;
	private GameBoard humanPanel;
	
	private JLabel lblHumanScore;
	private JLabel lblComputerScore;
	
	private Board gameLogicComputerBoard = new Board(BOARD_SIZE, MAX_SCORE);
	private Board gameLogicHumanBoard = new Board(BOARD_SIZE, MAX_SCORE);
	
	private ComputerMove compMove = new ComputerMove();
	
	private int difficulty;
	private JButton[][] btnList;
	
	public Game(GameBoard computerPanel, GameBoard humanPanel, JLabel humanScore, JLabel computerScore) {
		this.computerPanel = computerPanel;
		this.humanPanel = humanPanel;
		this.btnList = computerPanel.getBtnList();
		this.lblHumanScore = humanScore;
		this.lblComputerScore = computerScore;
	}
	
	public void startProgram() {
		initializeGame();
		difficulty = difficulty();
		this.addComputerEventListeners();
	}
	
	
	public void initializeGame() {
		this.humanPanel.startBoard();
		
		if (this.humanPanel.getshipManualShipGeneration() == true) {
			for (int i = 0; i < this.SHIP_SIZES.length; i++) {
				boolean success = false;	
				do {
					Ship guiShip = Ships.getOneShip(SHIP_SIZES[i]);
					if (this.gameLogicHumanBoard.addShip(guiShip) == true) {
						this.humanPanel.placeShipGuiBoard(guiShip);	
						success = true;
					}
					else {
						GameBoard.printError();
					}	
				} while(!success);
			}
		}
		else {
			for (int i = 0; i < this.SHIP_SIZES.length; i++) {	
				boolean success = false;
				do {
					Ship guiShip = Ship.getRandomShip(SHIP_SIZES[i], BOARD_SIZE);
					
					if (this.gameLogicHumanBoard.addShip(guiShip) == true) {
						this.humanPanel.placeShipGuiBoard(guiShip);	
						success = true;
					}	
				} while (!success);
			}
		}

		for (int i = 0; i < this.SHIP_SIZES.length; i++) {	
			boolean success = false;
			do {
				Ship compShip = Ship.getRandomShip(SHIP_SIZES[i], BOARD_SIZE);
				if (this.gameLogicComputerBoard.addShip(compShip) == true) {
					/*
					 * FOR TESTING PURPOSES ONLY
					 * this.computerPanel.placeShipGuiBoard(compShip);
					 */
					success = true;
				}	
			} while (!success);
		}
	}
	
	public void addComputerEventListeners() {
	    ActionListener listener = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();
				Coordinates location = Coordinates.parseIntoCoordinates(Integer.parseInt(btn.getText()));
					if(getGameLogicComputerBoard().hit(location)) {		 
						hit(btn);
					}
					else {
						miss(btn);
					}
					
					if(gameLogicComputerBoard.opponentWon()) {
						gameOver(1);
					} else {
						getComputerPanel().enableBtns(false, gameLogicComputerBoard.getBoard());
						computerMove(getDifficulty());
					}
	        }
	    
	    };
		
		for (int i = 0; i < getBoardSize(); i++) {
			for (int j = 0; j < getBoardSize(); j++) {
				this.getBtnList()[i][j].addActionListener(listener);
			}
		}
	}
	
	public void computerMove(int difficulty) {
		int move = compMove.compMove(difficulty);
		Coordinates location = Coordinates.parseIntoCoordinates(move);
		JButton btn = humanPanel.getBtnList()[location.get_row()][location.get_col()];
		if(getGameLogicHumanBoard().hit(location)) {		 
			hit(btn);
			compMove.hit(true);
		}
		else {
			miss(btn);
			compMove.hit(false);
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			   public void run() {
				   lblComputerScore.setText("Computer Score: " + String.valueOf(gameLogicHumanBoard.getOppenentScore()));
			   }
		});

		
		if(gameLogicHumanBoard.opponentWon()) {
			gameOver(0); //change the functionality
		}
		
		System.out.println("Computer's turn " + difficulty + " " + move);
		this.getComputerPanel().enableBtns(true, gameLogicComputerBoard.getBoard());
	}
	
	
	public int difficulty() {
		int value = 0;
		boolean validDificulty = false;
		
		while(!validDificulty) {
		String val = JOptionPane.showInputDialog(null, "At what difficulty would you like to play? [1-2]");
			if (val != null) {
				try { 
					value = Integer.valueOf(val);
						if (value >= 1 && value < 4) {
							validDificulty = true;
						} else {
							JOptionPane.showMessageDialog(null, "Please enter a valid difficulty between 1 and 2");
						}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please enter a valid difficulty!");
					validDificulty = false;
				}
			} else {
				value = -1;
				validDificulty = true;
			}
			
		}
	return value;
	}
	
	
	public void hit(JButton btn) {
		btn.setBackground(Color.red);
		btn.setOpaque(true);
		btn.setEnabled(false);
	}
	public void miss(JButton btn) {
		btn.setBackground(Color.white);
		btn.setOpaque(true);
		btn.setEnabled(false);
	}
	
	public void gameOver(int status) {
		if(status == 1) {
		JOptionPane.showMessageDialog(null, "Good Job! You won the game!");
		} else if (status == 0) {
		JOptionPane.showMessageDialog(null, "Snap! You Lost! Better luck next time!");
		}
		//resetGame()
	}
	
	public static int getBoardSize() {
		return BOARD_SIZE;
	}
	
	public int[] getShipSizes() {
		return this.SHIP_SIZES;
	}
	
	public Board getGameLogicHumanBoard() {
		return this.gameLogicHumanBoard;
	}
	
	public Board getGameLogicComputerBoard() {
		return this.gameLogicComputerBoard;
	}
	
	public GameBoard getComputerPanel() {
		return this.computerPanel;
	}
	
	public GameBoard getHumanPanel() {
		return this.humanPanel;
	}
	
	public JButton[][] getBtnList() {
		return this.btnList;
	}
	
	public JLabel getLblHumanScore() {
		return this.lblHumanScore;
	}
	
	public JLabel getLblComputerScore() {
		return this.lblComputerScore;
	}
	
	public int getDifficulty() {
		return this.difficulty;
	}

}
