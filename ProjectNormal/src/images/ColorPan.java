package images;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class ColorPan extends JComponent
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedImage image;

	public void initialize()
	{
		int width = getSize().width;
		int height = getSize().height;
		int[] data = new int[width * height];
		int i = 0;
		for (int y = 0; y < height; y++)
		{
			int red = (y * 255) / (height - 1);
			for (int x = 0; x < width; x++)
			{
				int green = (x * 255) / (width - 1);
				int blue = 255;
				data[i++] = (red << 16) | (green << 8) | blue;
			}
		}
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		image.setRGB(0, 0, width, height, data, 0, width);
	}

	public void paint(Graphics g)
	{
		if (image == null) initialize();
		g.drawImage(image, 0, 0, this);
	}

	public void setBounds(int x, int y, int width, int height)
	{
		super.setBounds(x, y, width, height);
		initialize();
	}
	public static void main(String[] args)
	{
		ColorPan pan=new ColorPan();
		JFrame frame = new JFrame("ColorPan");
		frame.add(pan);
		frame.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosed(WindowEvent e)
			{
				//Need TO save pic
				super.windowClosed(e);
			}
		});
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}