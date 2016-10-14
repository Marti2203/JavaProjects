package classes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Sun extends JButton
{
	public int drawX;
	public int drawY;
	Image sun;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Sun()
	{
		try
		{
			init(null, new ImageIcon(new URL("file:Images/sun.jpg")));
		}
		catch (MalformedURLException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setPreferredSize(new Dimension(100, 100));
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusable(false);

		addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Test");
			}
		});
	}

	@Override
	public void paint(Graphics g)
	{
		g.drawImage(sun, drawX, drawY, null);
		super.paint(g);
	}
}
