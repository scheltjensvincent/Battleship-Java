package gui;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class GUI {
	public static void main(String[] args) {
		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("Battleship");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setPreferredSize(new Dimension(700, 1000));
		mainFrame.setResizable(false);
		
		mainFrame.setLayout(new GridBagLayout());
		GridBagConstraints mainFrameConstraints = new GridBagConstraints();
		
		JLabel titleOfGame = new JLabel();
		titleOfGame.setText("Battleship"); //gezien de titel van het JFrame ook al "Battleship" is, misschien wat overbodig?
		mainFrameConstraints.gridx = 0;
		mainFrameConstraints.gridy = 0;
		//mainFrameConstraints.gridwidth = 4;
		mainFrame.add(titleOfGame, mainFrameConstraints);
		
		GameBoard computerPanel = createGrid(10);
		GameBoard humanPanel = createGrid(10);
		
		JLabel lblDivider = new JLabel(" ");
		lblDivider.setOpaque(true);
		lblDivider.setBackground(Color.black);
		
		JButton btnStop = new JButton("Stop");
		JButton btnRestart = new JButton("Restart");
		JLabel lblCompScore = new JLabel("Computer Score: "); //definieer een variabele compScore en voeg + compScore toe
		JLabel lblPlayerScore = new JLabel("Your Score: "); //definieer een variabele playerScore en voeg + playerScore toe

		mainFrameConstraints.gridx = 0;
		mainFrameConstraints.gridy = 1;
		mainFrame.add(computerPanel.board, mainFrameConstraints);
		
		mainFrameConstraints.gridx = 0;
		mainFrameConstraints.gridy = 2;
		mainFrameConstraints.fill = GridBagConstraints.HORIZONTAL;
		mainFrame.add(lblDivider, mainFrameConstraints);
		
		mainFrameConstraints.gridx = 0;
		mainFrameConstraints.gridy = 3;
		mainFrame.add(humanPanel.board, mainFrameConstraints);
		
		mainFrameConstraints.gridx = 2;
		mainFrameConstraints.gridy = 2;
		mainFrame.add(btnRestart, mainFrameConstraints);
		
		mainFrameConstraints.gridx = 1;
		mainFrameConstraints.gridy = 2;
		mainFrame.add(btnStop, mainFrameConstraints);
		
		mainFrameConstraints.gridx = 2;
		mainFrameConstraints.gridy = 1;
		mainFrame.add(lblCompScore, mainFrameConstraints);
		
		mainFrameConstraints.gridx = 2;
		mainFrameConstraints.gridy = 3;
		mainFrame.add(lblPlayerScore, mainFrameConstraints);
		
		mainFrame.pack();
		mainFrame.setVisible(true);
		
	}
	
	private static GameBoard createGrid(int BoardSize) {
		JButton[][] btnList = new JButton[BoardSize][BoardSize];
		JPanel board = new JPanel();
		board.setLayout(new GridLayout(BoardSize, BoardSize));
		
		for (int i = 0; i < BoardSize; i++) {
			for (int j = 0; j < BoardSize; j++) {
				JButton btn = new JButton(i + ", " + j);
				btn.setPreferredSize(new Dimension(40,40));
				btn.setOpaque(true);
				btn.setBackground(Color.gray);
				btn.setContentAreaFilled(false);
				
				// Probleem: door onderstaande border aan te maken kan je precies niet meer op de knop klikken?
				//Antwoord: je overschrijft het standaard effect van een aanklikbare JButton, de actie wordt nog wel waargenomen maar niet visueel weergegeven. 
				btn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black, 1), BorderFactory.createLineBorder(Color.gray, 5)));
				btnList[i][j] = btn;
				board.add(btn);
				
				
			}
		}
		
		GameBoard objBoard = new GameBoard(board, btnList);
		
		return objBoard;
	}
	
	
}
