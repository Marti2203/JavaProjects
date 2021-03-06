package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Borders
{
	public static void main(String[] args)
	{
		// create a JFrame to hold everything
		JFrame frame = new JFrame("Borders");
		// Create labels with borders.
		int center = SwingConstants.CENTER;
		JLabel labelOne = new JLabel("raised BevelBorder", center);
		labelOne.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		JLabel labelTwo = new JLabel("EtchedBorder", center);
		labelTwo.setBorder(BorderFactory.createEtchedBorder());
		JLabel labelThree = new JLabel("MatteBorder", center);
		labelThree.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.pink));
		JLabel labelFour = new JLabel("TitledBorder", center);
		Border etch = BorderFactory.createEtchedBorder();
		labelFour.setBorder(BorderFactory.createTitledBorder(etch, "Title"));
		JLabel labelFive = new JLabel("TitledBorder", center);
		Border low = BorderFactory.createLoweredBevelBorder();
		labelFive.setBorder(BorderFactory.createTitledBorder(low, "Title", TitledBorder.RIGHT, TitledBorder.BOTTOM));
		JLabel labelSix = new JLabel("CompoundBorder", center);
		Border one = BorderFactory.createEtchedBorder();
		Border two = BorderFactory.createMatteBorder(4, 4, 4, 4, Color.blue);
		labelSix.setBorder(BorderFactory.createCompoundBorder(one, two));
		// add components to the content pane
		Container c = frame.getContentPane(); // unnecessary in 5.0+
		c.setLayout(new GridLayout(3, 2));
		c.add(labelOne);
		c.add(labelTwo);
		c.add(labelThree);
		c.add(labelFour);
		c.add(labelFive);
		c.add(labelSix);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}