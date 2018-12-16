package battleship;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gameLogic.*;
import gui.*;

public class Game {
	
	private final static int BOARD_SIZE = 10;
	private final int[] SHIP_SIZES = new int[] {5, 4, 3, 3, 2};
	
	private GameBoard computerPanel;
	private GameBoard humanPanel;
	
	private Board gameLogicComputerBoard = new Board(BOARD_SIZE);
	private Board gameLogicHumanBoard = new Board(BOARD_SIZE);
	
	
	private int dificulty;
	private JButton[][] btnList;
	private static boolean humanTurn = true;
	
	public Game(GameBoard computerPanel, GameBoard humanPanel) {
		this.computerPanel = computerPanel;
		this.humanPanel = humanPanel;
		this.btnList = computerPanel.getBtnList();
	}
	
	
	public void startProgram() {
		initializeGame();
		//this.computerPanel.addComputerEventListeners(gameLogicComputerBoard);
		//this.computerPanel.enableBtns(false); //disable this when working on the startGame method
		//startGame();
		
		this.addComputerEventListeners();
	}
	
	
	public void initializeGame() {
		this.humanPanel.startBoard(1);
		
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
		
		for (int i = 0; i < this.SHIP_SIZES.length; i++) {	
			boolean success = false;
			do {
				Ship compShip = Ship.getRandomShip(SHIP_SIZES[i], BOARD_SIZE);
				
				if (this.gameLogicComputerBoard.addShip(compShip) == true) {
					this.computerPanel.placeShipGuiBoard(compShip);	
					success = true;
				}	
			} while (!success);
		}
	}

	public int difficulty() {
		int value = 0;
		boolean validDificulty = false;
		
		while(!validDificulty) {
		String val = JOptionPane.showInputDialog(null, "At what difficulty would you want to play? [1-3]");
			if (val != null) {
				try { 
					value = Integer.valueOf(val);
						if (value >= 1 && value < 4) {
							validDificulty = true;
						} else {
							JOptionPane.showMessageDialog(null, "Please enter a valid dificulty between 1 and 3");
						}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please Enter a Valid Location!");
					validDificulty = false;
				}
			} else {
				value = -1;
				validDificulty = true;
			}
			
		}
	return value;
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
	
	public int getDifficulty() {
		return this.dificulty;
	}
	
	public static boolean getTurn() {
		return humanTurn;
	}
	
	public static void setTurn(boolean playerTurn) {
		humanTurn = playerTurn;
	}
	
	/*public void startGame() {
		
		do {
			if(humanTurn) {
				this.getComputerPanel().enableBtns(true);
				
				
				//this.getGameLogicComputerBoard().incrementScoreOpponent();
				
				this.getComputerPanel().getBtnList()[0][0].
				
				setTurn(false);
				this.getComputerPanel().enableBtns(false);
			}
			else {
				System.out.println("Computer hit");
				humanTurn = true;
			}
			
		} while(!this.getGameLogicComputerBoard().opponentWon());
		
	}*/
	
	public void computer() {
		System.out.println("Computer's turn");
		this.getComputerPanel().enableBtns(true);
	}
	
	public void addComputerEventListeners() {
	    ActionListener listener = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();
				Coordinates location = Coordinates.parseIntoCoordinates(Integer.parseInt(btn.getText()));
				if(getGameLogicComputerBoard().hit(location)) {		 
					btn.setBackground(Color.red);
					//btn.setForeground(Color.white); //doesn't work disabled JButtons get default font color gray
					btn.setOpaque(true);
					btn.setEnabled(false);
				}
				else {
					btn.setBackground(Color.white);
					//btn.setForeground(Color.white); //doesn't work disabled JButtons get default font color gray
					btn.setOpaque(true);
					btn.setEnabled(false);
				}
				getComputerPanel().enableBtns(false);
				computer();
	        }
	    };
		
		for (int i = 0; i < getBoardSize(); i++) {
			for (int j = 0; j < getBoardSize(); j++) {
				this.getBtnList()[i][j].addActionListener(listener);
			}
		}
	}
/*
	
	//the major part here is still pseudocode
	public void startGame() {
		int difficulty = difficulty();
		boolean won = false;
		do {
		boolean playerTurn = true;
			while(playerTurn) {
				this.computerPanel.enableBtns();
				//human starts -> can fire one shot
				//how do we register here that a shot has been fired? 
				//we can add a method that returns true whenever hit (fire) fails or succeeds. 
				
				//should kick in whenever a JButton is clicked
				if(gameLogicComputerBoard.shotFired()) { // shotfired a method that returns true when a shot is fired 
				this.computerPanel.disableBtns();
					//update score
					//check whether the human has won
					//if(playerScore == maxScore) {
						//won = true;
						//gameOver();
						//resetGame(); 
					//} else {
						playerTurn = false;
					}
				}
			 while(!playerTurn) {
				while(!gameLogicHumanBoard.shotFired()) { // when in the loop disabled buttons are selected no shot is registered so you'll loop through.
					int computerMove = compMove(difficulty); //make a class and define computer move for difficulty levels 1-3
				}
				// handel the computermove etc 
				//computer's turn -> can fire one shot
				//update score

				//check whether the computer has won
				//if(computerScore == maxScore) {
					//	won = true;
					//	gameOver();
					//	resetGame(); 
					//} else {
						playerTurn = true;
					//}
			}
		} while(!won); 
	}
	
	*/
	
}
