package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class LocalColor
{
	public static void main(String[] args)
	{
		final JFrame frame = new JFrame("LocalColor v1.0");
		final Container content = frame.getContentPane(); // unnecessary in 5.0+
		content.setLayout(new GridBagLayout());
		JButton button = new JButton("Change color...");
		content.add(button);
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				Color c = JColorChooser.showDialog(frame, "Choose a color", content.getBackground());
				if (c != null) content.setBackground(c);
			}
		});
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
