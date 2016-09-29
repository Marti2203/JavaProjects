package color;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import screen.Screen;

public abstract class ColorChooser
{
	Component selectedComponent;

	MouseListener mouseListener = new MouseAdapter()
	{
		public void mousePressed(MouseEvent e)
		{
			checkPopup(e);
		}

		public void mouseClicked(MouseEvent e)
		{
			checkPopup(e);
		}

		public void mouseReleased(MouseEvent e)
		{
			checkPopup(e);
		}

		private void checkPopup(MouseEvent e)
		{
			if (e.isPopupTrigger())
			{
				treatPopupTrigger(e);
			}
		}
	};

	public ColorChooser(JFrame frame)
	{
		super();
		frame.getContentPane().addMouseListener(mouseListener);
	}

	public ColorChooser(Screen screen)
	{
		this((JFrame) screen);
		for (int x = 0; x < screen.getCols(); x++)
		{
			for (int y = 0; y < screen.getRows(); y++)
			{
				screen.getPixels()[x][y].addMouseListener(mouseListener);
			}
		}
	}

	protected abstract void treatPopupTrigger(MouseEvent e);

}
