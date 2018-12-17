package battleship;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import gameLogic.*;
import gui.*;

public class Game {
	
	private final static int BOARD_SIZE = 10;
	private final int[] SHIP_SIZES = new int[] {5, 4, 3, 3, 2};
	private final int MAX_SCORE = 17;
	
	private GameBoard computerPanel;
	private GameBoard humanPanel;
	
	private Board gameLogicComputerBoard = new Board(BOARD_SIZE);
	private Board gameLogicHumanBoard = new Board(BOARD_SIZE);
	
	private ComputerMove compMove = new ComputerMove();
	
	
	private int difficulty;
	private JButton[][] btnList;
	private boolean humanTurn = true;
	
	public Game(GameBoard computerPanel, GameBoard humanPanel) {
		this.computerPanel = computerPanel;
		this.humanPanel = humanPanel;
		this.btnList = computerPanel.getBtnList();
	}
	
	
	public void startProgram() {
		//this.computerPanel.enableBtns(false);
		initializeGame();
		difficulty = difficulty();
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
		setTurn(true);
	}
	
	public void addComputerEventListeners() {
		if(getTurn()) {
	    ActionListener listener = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();
				Coordinates location = Coordinates.parseIntoCoordinates(Integer.parseInt(btn.getText()));
					if(getGameLogicComputerBoard().hit(location)) {		 
						hit(btn);
						//setTurn(false);
					}
					else {
						mis(btn);
						//setTurn(false);
						
					}
				System.out.println(gameLogicComputerBoard.getOppenentScore() + " human score");
					if(gameLogicComputerBoard.getOppenentScore() == MAX_SCORE) {
						gameOver(1); //change the functionality
					} else {
						setTurn(false);
					}
					
					if(!getTurn()) {
					getComputerPanel().enableBtns(false);
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
	}
	
	public void computerMove(int difficulty) {
		if(!getTurn()) {
		int move = compMove.compMove(difficulty);
		Coordinates location = Coordinates.parseIntoCoordinates(move);
		JButton btn = humanPanel.getBtnList()[location.get_row()][location.get_col()];
			if(getGameLogicHumanBoard().hit(location)) {		 
				hit(btn);
				//setTurn(true);
			}
			else {
				mis(btn);
				//setTurn(true);
			}
		System.out.println(gameLogicHumanBoard.getOppenentScore() + " pc score");
			if(gameLogicHumanBoard.getOppenentScore() == MAX_SCORE) {
				gameOver(0); //change the functionality
				//resetGame(); 
			} else {
				setTurn(true);
			}
		
		System.out.println("Computer's turn " + difficulty + " " + move);
		this.getComputerPanel().enableBtns(true);
		//setTurn(true);
		}
	}
	

	public int difficulty() {
		int value = 0;
		boolean validDificulty = false;
		
		while(!validDificulty) {
		String val = JOptionPane.showInputDialog(null, "At what difficulty would you like to play? [1-3]");
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
		return this.difficulty;
	}
	
	public boolean getTurn() {
		return humanTurn;
	}
	
	public void setTurn(boolean playerTurn) {
		humanTurn = playerTurn;
	}
	
	public void hit(JButton btn) {
		btn.setBackground(Color.red);
		//btn.setForeground(Color.white); //doesn't work disabled JButtons get default font color gray
		btn.setOpaque(true);
		btn.setEnabled(false);
		
	}
	public void mis(JButton btn) {
		btn.setBackground(Color.white);
		//btn.setForeground(Color.white); //doesn't work disabled JButtons get default font color gray
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
