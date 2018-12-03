package battleship;

import javax.swing.JFrame;
import gui.Pane;

public class Battleship {

	public static void main(String[] args) {
		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("Battleship");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().add(new Pane());
		mainFrame.setResizable(false);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}

}
