package gui;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

import battleship.Game;
import gameLogic.Board;
import gameLogic.Coordinates;


//public class ButtonListener implements ActionListener{
	/*
	public Board logicBoard;
	
	public ButtonListener(Board logicBoard) { 
		this.logicBoard = logicBoard;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		
		JButton btn = (JButton) e.getSource();
		Coordinates location = Coordinates.parseIntoCoordinates(Integer.parseInt(btn.getText()));
		
		if(logicBoard.hit(location)) {		 
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
		
		//Game.setTurn(true);
	}		*/	
//}