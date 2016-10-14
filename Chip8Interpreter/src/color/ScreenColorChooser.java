package color;

import javax.swing.JFrame;

import screen.Screen;

public abstract class ScreenColorChooser extends ColorChooser
{
	public ScreenColorChooser(Screen screen)
	{
		super((JFrame) screen);
		for (int x = 0; x < screen.getCols(); x++)
		{
			for (int y = 0; y < screen.getRows(); y++)
			{
				screen.getPixels()[x][y].addMouseListener(mouseListener);
			}
		}
	}
	
	public ScreenColorChooser(JFrame frame)
	{
		super(frame);
	}
}
