package twoDgui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class GraphicsTests extends JFrame
{

	public GraphicsTests()
	{
		super("Graphics Test");
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void paintComponents(Graphics g)
	{
		Graphics2D graphics2d=(Graphics2D) g;
		graphics2d.setColor(Color.BLACK);
		graphics2d.draw3DRect(200, 200, 100, 100, true);
		super.paintComponents(g);
	}
	public static void main(String[] args)
	{
		new GraphicsTests().repaint();
	}

}
