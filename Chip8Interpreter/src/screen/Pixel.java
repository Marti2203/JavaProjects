package screen;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Objects;

public class Pixel extends Component
	{

		private int x;
		private int y;
		private int width;
		private int height;
		private Color colour;
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public int getX()
			{
				return x;
			}

		public int getY()
			{
				return y;
			}

		public void setWidth(int width)
			{
				this.width = width;
			}

		public void setHeight(int height)
			{

				this.height = height;
			}
		public void setColor(Color colour)
			{
				this.colour=colour;
			}

		public Pixel(int x, int y, int dimensions, Color colour)
			{
				this(x, y, dimensions, dimensions, colour);
			}

		public Pixel(int x, int y, int width, int height, Color colour)
			{
				super();
				this.x = x;
				this.y = y;
				this.width = width;
				this.height = height;
				this.colour = colour;
				setPreferredSize(new Dimension(width, height));
				setVisible(true);
			}

		@Override
		public void paint(Graphics g)
			{
				g.setColor(colour);
				g.fillRect(x, y, width, height);
				super.paint(g);
			}

		//@Override
		//protected void paintComponent(Graphics g)
		//{
		//	g.setColor(colour);
		//	g.fillRect(x, y, width, height);
		//	super.paintComponent(g);
		//}
		
		@Override
		public boolean equals(Object obj)
			{
				Objects.requireNonNull(obj);
				Objects.requireNonNull(this);
				if (obj.getClass() != getClass())
					return false;
				Pixel ob = (Pixel) obj;
				return this.getX() == ob.getX() && this.getY() == ob.getY();
			}

	}
