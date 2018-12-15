package gui;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

import gameLogic.Coordinates;


public class ButtonListener implements ActionListener{
	@Override 
	public void actionPerformed(ActionEvent e) {
		 
		JButton btn = (JButton) e.getSource();		 
		btn.setBackground(Color.red);
		btn.setForeground(Color.white);
		btn.setOpaque(true);
		
		btn.setEnabled(false);
		
		//Coordinates location = Coordinates.parseIntoCoordinates(Integer.parseInt(btn.getText()));
		
	}
				
}