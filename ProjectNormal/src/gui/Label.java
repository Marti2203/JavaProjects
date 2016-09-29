package gui;

import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Label
{
	public static void main(String[] args)
	{
		JFrame frame=new JFrame("Labels");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(1,4));
		// default alignment (CENTER)
		JLabel label1 = new JLabel("Lions");
		// left aligned
		JLabel label2 = new JLabel("Tigers", SwingConstants.LEFT);
		//label with no text, default alignment
		JLabel label3 = new JLabel();
		// create image icon
		Icon icon = new ImageIcon("Images/rhino.gif");
		// create image label
		JLabel label4 = new JLabel(icon);
		// assigning text to label3
		label3.setText("and Bears");
		// set alignment
		label3.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
		frame.pack();
		frame.setVisible(true);
	}
	
}
