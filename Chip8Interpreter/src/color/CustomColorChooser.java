package color;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JColorChooser;
import javax.swing.JFrame;

import screen.Screen;

public class CustomColorChooser extends ScreenColorChooser
{
	JFrame frame;

	public CustomColorChooser(JFrame frame)
	{
		super(frame);
	}

	public CustomColorChooser(Screen screen)
	{
		super(screen);
	}

	@Override
	protected void treatPopupTrigger(MouseEvent e)
	{
		selectedComponent = e.getComponent();
		Color c = JColorChooser.showDialog(frame, "Choose a color", selectedComponent.getBackground());
		if (c != null) selectedComponent.setBackground(c);

	}

}
