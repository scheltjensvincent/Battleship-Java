package gui;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;


public class buttonListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0) {
		 JButton btn = new JButton();
		 
		btn.setBackground(Color.red);
		btn.setForeground(Color.white);
		btn.setOpaque(true);
	}
				
}


/*
if (e.getSource() == btnList[i][j]) {
	btnList[i][j].setBackground(Color.red);
	btnList[i][j].setForeground(Color.white);
	btnList[i][j].setOpaque(true);
				
}
*/