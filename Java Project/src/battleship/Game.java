package battleship;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import gameLogic.*;
import gui.*;

public class Game {
	
	private final int BOARD_SIZE = 10;
	GameBoard computerPanel;
	GameBoard humanPanel;
	Board gameLogicComputerBoard;
	Board gameLogicHumanBoard;
	int[] shipSizes;
	JButton[][] btnList;
	
	public Game(GameBoard computerPanel, GameBoard humanPanel, Board gameLogicComputerBoard , Board gameLogicHumanBoard, int[] shipSizes) {
		this.computerPanel = computerPanel;
		this.humanPanel = humanPanel;
		this.gameLogicComputerBoard = gameLogicComputerBoard;
		this.gameLogicHumanBoard = gameLogicHumanBoard;
		this.shipSizes = shipSizes;
		
	}
	
	public Game(JButton[][] btnList) {
		this.btnList = btnList;
	}
	
	public void startProgram() {
		this.computerPanel.disableBtns();
		initializeGame();
		this.computerPanel.addComputerEventListeners(gameLogicComputerBoard);
		this.computerPanel.enableBtns(); //disable this when working on the startGame method
		
		

		
		//startGame();
	}
	
	/*
	
	//the major part here is still pseudocode
	public void startGame() {
		int dificulty = getDificulty();
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
					if(playerScore == maxScore) {
						won = true;
						gameOver();
						resetGame(); 
					} else {
						playerTurn = false;
					}
				}
			} while(!playerTurn) {
				int computerMove = compMove(dificulty); //make a class and define computer move for dificulty levels 1-3
				// handel the computermove etc 
				//computer's turn -> can fire one shot
				//update score

				//check whether the computer has won
				if(computerScore == maxScore) {
						won = true;
						gameOver();
						resetGame(); 
					} else {
						playerTurn = true;
					}
			}
		} while(!won); 
	}
	
	*/
	
	public void initializeGame() {
		this.humanPanel.startBoard(1);
		
		for (int i = 0; i < this.shipSizes.length; i++) {
			boolean success = false;	
			do {
				Ship guiShip = Ships.getOneShip(shipSizes[i]);
				if (this.gameLogicHumanBoard.addShip(guiShip) == true) {
					this.humanPanel.placeShipGuiBoard(guiShip);	
					success = true;
				}
				else {
					GameBoard.printError();
				}	
			} while(!success);
		}
		
		for (int i = 0; i < this.shipSizes.length; i++) {	
			boolean success = false;
			do {
				Ship compShip = Ship.getRandomShip(shipSizes[i], BOARD_SIZE);
				
				if (this.gameLogicComputerBoard.addShip(compShip) == true) {
					this.computerPanel.placeShipGuiBoard(compShip);	
					success = true;
				}	
			} while (!success);
		}
	}

	public int getDificulty() {
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
}
