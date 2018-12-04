package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class GlassPane extends JPanel {
	
	public void enableGlassPane() {
        setVisible(true);
        setOpaque(false);
    }
	
	public void disableGlassPane() {
		setVisible(false);
	}
 }
