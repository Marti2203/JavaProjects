package twoDgui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.RepaintManager;

public class DragImage extends JComponent implements MouseMotionListener
{
	static int imageWidth = 100, imageHeight = 100;
	int grid = 10;
	int imageX, imageY;
	Image image;

	public DragImage(Image i)
	{
		image = i;
		addMouseMotionListener(this);
	}

	public void mouseDragged(MouseEvent e)
	{
		imageX = e.getX();
		imageY = e.getY();
		repaint();
	}

	public void mouseMoved(MouseEvent e)
	{
	}

	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		int w = getSize().width / grid;
		int h = getSize().height / grid;
		boolean black = false;
		for (int y = 0; y <= grid; y++)
			for (int x = 0; x <= grid; x++)
			{
				g2.setPaint(black ? Color.black : Color.white);
				black = !black;
				g2.fillRect(x * w, y * h, w, h);
			}
		g2.drawImage(image, imageX, imageY, this);
	}

	public static void main(String[] args) throws MalformedURLException
	{
		String imageFile = "https://github.com/patniemeyer/learningjava/blob/master/examples/ch20/L1-Light.jpg?raw=true";
		if (args.length > 0) imageFile = args[0];
		// Turn off double buffering
		RepaintManager.currentManager(null).setDoubleBufferingEnabled(false);
		Image image = Toolkit.getDefaultToolkit().getImage(new URL(imageFile));
		image = image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
		JFrame frame = new JFrame("DragImage");
		frame.add(new DragImage(image));
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}