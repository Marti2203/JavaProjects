package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PictureButton
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		Icon icon = new ImageIcon("Images/maOEFXN.jpg");
		JButton button = new JButton(icon);
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("Urp!");
			}
		});
		frame.getContentPane().add(button);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}