package images;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class StatusImage extends JComponent
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean loaded = false;
	String message = "Loading...";
	Image image;

	public StatusImage(Image image)
	{
		this.image = image;
	}

	public void paint(Graphics g)
	{
		if (loaded)
			g.drawImage(image, 0, 0, this);
		else
		{
			g.drawRect(0, 0, getSize().width - 1, getSize().height - 1);
			g.drawString(message, 20, 20);
		}
	}

	public void loaded()
	{
		loaded = true;
		repaint();
	}

	public void setMessage(String msg)
	{
		message = msg;
		repaint();
	}

	public static void main(String[] args) throws MalformedURLException
	{
		String path="https://i.imgur.com/agOMBj2.jpg";
		JFrame frame = new JFrame("TrackImage");
		Image image = Toolkit.getDefaultToolkit().getImage(new URL(path));
		StatusImage statusImage = new StatusImage(image);
		frame.add(new JScrollPane(statusImage));
		frame.setSize(300, 300);
		frame.setVisible(true);
		MediaTracker tracker = new MediaTracker(statusImage);
		int MAIN_IMAGE = 0;
		tracker.addImage(image, MAIN_IMAGE);
		try
		{
			tracker.waitForID(MAIN_IMAGE);
		}
		catch (InterruptedException e)
		{
		}
		if (tracker.isErrorID(MAIN_IMAGE))
			statusImage.setMessage("Error");
		else statusImage.loaded();
	}
}