package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Grid extends JPanel
{
	public Grid()
	{
		setLayout(new GridLayout(3, 2));
		add(new JButton("One"));
		add(new JButton("Two"));
		add(new JButton("Three"));
		add(new JButton("Four"));
		add(new JButton("Five"));
	}

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Grid");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setLocation(200, 200);
		frame.setContentPane(new Grid());
		frame.setVisible(true);
	}
}