package sound;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;

public class NoisyButton
{
	public static void main(String[] args) throws Exception
	{
		JFrame frame = new JFrame("NoisyButton");
		URL url = new URL("file:Sounds/bark.aiff");
		final AudioClip sound = Applet.newAudioClip(url);
		JButton button = new JButton("Woof!");
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.play();
			}
		});
		Container content = frame.getContentPane();
		content.setBackground(Color.pink);
		content.setLayout(new GridBagLayout());
		content.add(button);
		frame.setVisible(true);
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
