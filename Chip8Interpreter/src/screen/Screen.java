package screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Screen extends JFrame
	{
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;

		public Screen()
			{
				super();
				setLayout(new FlowLayout());
				setVisible(true);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}

		public Screen(Dimension size)
			{
				this();
				setSize(size);
			}

		public void addPixel(int x, int y, int width, int height, Color color)
			{
				Pixel pixel = new Pixel(x, y, width, height);
				pixel.setColor(color);
				add(pixel);

			}

		public void addPixel(int x, int y, int width, int height)
			{
				addPixel(x, y, width, height, Color.BLACK);
			}

		public void addPixel(int x, int y, int width)
			{
				addPixel(x, y, width, width, Color.BLACK);
			}

		public void addPixel(int x, int y, int width, Color color)
			{
				addPixel(x, y, width, width, color);
			}

		public void createScreen(int xPixels, int yPixels)
			{
				Dimension currentDim = getSize();
				System.out.println(currentDim);
				int width = currentDim.width / xPixels;
				int height = currentDim.width / yPixels;
				for (int x = 0; x < xPixels; x++)
					{
						for (int y = 0; y < yPixels; y++)
							{
								addPixel(x * width, y * height, width, height);
							}
					}
				list(System.out);
			}
	}
