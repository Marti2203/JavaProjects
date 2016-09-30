package gui;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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
				try
				{
					Desktop.getDesktop().browse(new URI("https://imgur.com"));
				}
				catch (IOException | URISyntaxException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(button);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}