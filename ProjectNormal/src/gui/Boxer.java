package gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Boxer extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Boxer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(250, 250);
		frame.setLocation(200, 200);
		Container box = Box.createHorizontalBox();
		box.add(Box.createHorizontalGlue());
		box.add(new JButton("In the"));
		box.add(Box.createHorizontalGlue());
		box.add(new JButton("clearing"));
		box.add(Box.createHorizontalStrut(20));
		box.add(new JButton("stands"));
		box.add(Box.createHorizontalStrut(20));
		box.add(new JButton("a"));
		box.add(Box.createHorizontalGlue());
		box.add(new JButton("boxer"));
		box.add(Box.createHorizontalGlue());
		frame.getContentPane().add(box, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}
