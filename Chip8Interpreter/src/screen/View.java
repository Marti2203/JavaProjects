package screen;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.text.MessageFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame
	{
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;

		int widthPixelCount;
		int heightPixelCount;
		Pixel[][] screen;

		public View(int pixelWidth, int pixelHeight)
			{
				super();
				setSize(500, 500);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				widthPixelCount = pixelWidth;
				heightPixelCount = pixelHeight;
				screen = new Pixel[pixelWidth][pixelHeight];

				setLayout(new FlowLayout());
				createPixels();

				setVisible(true);
			}

		public View(String name, int pixelWidth, int pixelHeight)
			{
				super(name);
				setSize(500, 500);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				widthPixelCount = pixelWidth;
				heightPixelCount = pixelHeight;
				screen = new Pixel[pixelWidth][pixelHeight];

				setLayout(new FlowLayout());
				createPixels();

				setVisible(true);
			}

		private void resizePixels(String s)
			{
				System.out.printf("Resized %s\n", s);
				int pixelHeight = getHeight() / heightPixelCount;
				int pixelWidth = getWidth() / widthPixelCount;
				for (int x = 0; x < widthPixelCount; x++)
					{
						for (int y = 0; y < heightPixelCount; y++)
							{
								screen[x][y].setHeight(pixelHeight * y);
								screen[x][y].setWidth(pixelWidth * x);
							}
					}
			}

		private void createPixels()
			{
				int pixelHeight = getHeight() / heightPixelCount;
				int pixelWidth = getWidth() / widthPixelCount;
				for (int x = 0; x < widthPixelCount; x++)
					{
						for (int y = 0; y < heightPixelCount; y++)
							{
								System.out.println(MessageFormat.format("{0} {1}", x,y));
								//screen[x][y]=new Pixel(pixelWidth * x, pixelHeight * y, pixelWidth, pixelHeight,
								//Color.blue); 
								add(new Pixel(pixelWidth * x, pixelHeight * y, pixelWidth, pixelHeight,
										Color.blue));
	
							}
					}
			}

		@Override
		public void paint(Graphics g)
			{
				// resizePixels("paint");
				super.paint(g);
			}
	}
