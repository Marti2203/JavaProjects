package gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mango
	{
		public static void main(String[] args)
			{
				JFrame frame = new JFrame("The Frame");
				// The three methods below are delegated to the frame's
				// ContentPane.
				frame.setLayout(new FlowLayout());
				frame.add(new JLabel("Mango"));
				frame.add(new JButton("Mango"));
				frame.setLocation(100, 100);
				frame.pack();
				frame.setVisible(true);
			}
	}
