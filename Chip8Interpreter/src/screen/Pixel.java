package screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Objects;

import javax.swing.JComponent;

public class Pixel extends JComponent
	{
		Dimension xyDimension = new Dimension();
		Dimension dimensions = new Dimension();
		Color color = Color.BLACK;

		public Color getColor()
			{
				return color;
			}

		public void setColor(Color color)
			{
				Objects.requireNonNull(color);
				this.color = color;
			}

		public int getX()
			{
				return xyDimension.width;
			}

		public int getY()
			{
				return xyDimension.height;
			}

		public int getWidth()
			{
				return dimensions.width;
			}

		public int getHeight()
			{
				return dimensions.height;
			}

		public void setX(int x)
			{
				if (x < 0)
					throw new IllegalArgumentException("X cannot be negative");
				else
					xyDimension.width = x;
			}

		public void setY(int y)
			{
				if (y < 0)
					throw new IllegalArgumentException("Y cannot be negative");
				xyDimension.height = y;
			}

		public void setWidth(int width)
			{
				if (width < 0)
					throw new IllegalArgumentException("Width cannot be negative");
				dimensions.width = width;
			}

		public void setHeight(int height)
			{
				if (height < 0)
					throw new IllegalArgumentException("Height cannot be negative");
				dimensions.height = height;
			}

		public Pixel(int x, int y, int dimensions)
			{
				this(x, y, dimensions, dimensions);
			}

		public Pixel(int x, int y, int width, int height)
			{
				setX(x);
				setY(y);
				setWidth(width);
				setHeight(height);
			}

		@Override
		public void paint(Graphics g)
			{
				g.setColor(color);
				g.fillRect(getX(), getY(), getWidth(), getHeight());
			}

		@Override
		public boolean equals(Object obj)
			{
				Objects.requireNonNull(obj);
				Objects.requireNonNull(this);
				Pixel pixel;
				try
					{
						pixel = (Pixel) obj;
					}
				catch (ClassCastException e)
					{
						return false;
					}
				return pixel.xyDimension.equals(this.xyDimension) && pixel.dimensions.equals(this.dimensions);
			}

		@Override
		public int hashCode()
			{
				return xyDimension.hashCode();
			}
	}
