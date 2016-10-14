package sound;

import java.awt.BorderLayout;
import java.awt.Component;
import java.net.URL;

import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.Manager;
import javax.media.Player;
import javax.media.RealizeCompleteEvent;
import javax.swing.JFrame;

public class MediaPlayer
{
	public static void main(String[] args) throws Exception
	{
		final JFrame frame = new JFrame("MediaPlayer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		URL url = new URL("file:Sounds/dancing_baby.avi");
		final Player player = Manager.createPlayer(url);
		player.addControllerListener(new ControllerListener()
		{
			public void controllerUpdate(ControllerEvent ce)
			{
				if (ce instanceof RealizeCompleteEvent)
				{
					Component visual = player.getVisualComponent();
					Component control = player.getControlPanelComponent();
					if (visual != null) frame.add(visual, BorderLayout.CENTER);
					frame.add(control, BorderLayout.SOUTH);
					frame.pack();
					frame.setVisible(true);
					player.start();
				}
			}
		});
		player.realize();
	}
}