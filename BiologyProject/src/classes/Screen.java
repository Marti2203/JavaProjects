package classes;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.net.MalformedURLException;
import java.net.URL;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.JFrame;

public class Screen extends JFrame
{
	Image background;
	ImageObserver observer=new ImageObserver()
	{
		
		@Override
		public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height)
		{
			if((ImageObserver.HEIGHT & infoflags) == 2)
				Screen.this.setSize(Screen.this.getWidth(),height);
			if((ImageObserver.WIDTH & infoflags) == 1)
				Screen.this.setSize(width, Screen.this.getHeight());
			return true;
		}
	};
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Screen()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try
		{
			background=Toolkit.getDefaultToolkit().getImage(new URL("file:Images/forest.jpg"));
			if(background.getWidth(observer)!=-1 && background.getHeight(observer)!=-1)
			{
				setSize(background.getWidth(null),background.getHeight(null));
			}
		}
		catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void paint(Graphics g)
	{
		g.drawImage(background, 0, 0, null);
		super.paint(g);
	}
}
