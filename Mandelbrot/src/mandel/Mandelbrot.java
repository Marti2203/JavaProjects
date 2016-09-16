package mandel;

import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.util.concurrent.*;

public class Mandelbrot extends JFrame
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void paint(Graphics g)
			{
				BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
				ForkJoinPool pool = new ForkJoinPool(); // defaults thread per
														// processor
				pool.invoke(new MandelbrotTask(image, 0, image.getWidth() - 1, 0, image.getHeight() - 1));
				g.drawImage(image, 0, 0, null);
			}
		public Mandelbrot()
		{
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setSize(768, 768);
			this.setVisible(true);
		}
		public static void main(String[] args)
			{
				new Mandelbrot();
			}
	}
class MandelbrotTask extends RecursiveAction
	{
		/**	
		* 
		*/
		private static final long serialVersionUID = 1L;
		private static double size = 3.0, offsetX = -0.7, thresholdSq = 100;
		private static int maxIterations = 30;
		private BufferedImage image;
		private int xStart, xEnd, yStart, yEnd;
		private static int taskSplitThreshold = 1024;

		MandelbrotTask(BufferedImage image, int xStart, int xEnd, int yStart, int yEnd)
			{
				this.image = image;
				this.xStart = xStart;
				this.xEnd = xEnd;
				this.yStart = yStart;
				this.yEnd = yEnd;
			}

		public void renderFull()
			{
				for (int x = xStart; x <= xEnd; x++)
					{
						for (int y = yStart; y <= yEnd; y++)
							{
								double realPart = x * size / image.getWidth() - size / 2 + offsetX;
								double imaginaryPart = y * size / image.getHeight() - size / 2;
								double zReal = 0, zImaginary = 0;
								int iter;
								for (iter = 0; iter < maxIterations; iter++)
									{
										double newZReal = zReal * zReal - zImaginary * zImaginary + realPart;
										double newZImaginary = 2 * zReal * zImaginary + imaginaryPart;
										if (newZReal * newZReal + newZImaginary * newZImaginary > thresholdSq)
											{
												break;
											}
										zReal = newZReal;
										zImaginary = newZImaginary;
									}
								image.setRGB(x, y, Color.HSBtoRGB(0.5f * iter / maxIterations, 1.0f, 1.0f));
							}
					}
			}

		@Override
		protected void compute()
			{
				int width = xEnd - xStart, height = yEnd - yStart;
				if (width * height < taskSplitThreshold)
					{
						renderFull();
					}
				else
					{
						invokeAll(new MandelbrotTask(image, xStart, xStart + width / 2, yStart, yStart + height / 2),
								new MandelbrotTask(image, xStart + width / 2 + 1, xEnd, yStart, yStart + height / 2),
								new MandelbrotTask(image, xStart, xStart + width / 2, yStart + height / 2 + 1, yEnd),
								new MandelbrotTask(image, xStart + width / 2 + 1, xEnd, yStart + height / 2 + 1, yEnd));
					}
			}
	}