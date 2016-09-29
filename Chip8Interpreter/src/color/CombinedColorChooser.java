package color;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

import screen.Screen;

public class CombinedColorChooser extends SimpleColorChooser implements ActionListener
{
	private static final String CUSTOM = "Custom";
	JFrame frame;

	public CombinedColorChooser(JFrame frame)
	{
		super(frame);
		AddCustomMenuItem();
	}

	public CombinedColorChooser(Screen screen)
	{
		super(screen);
		AddCustomMenuItem();
	}

	private void AddCustomMenuItem()
	{
		JMenuItem custom = new JMenuItem("Custom");
		custom.setActionCommand(CUSTOM);
		custom.addActionListener(this);
		colorMenu.addSeparator();
		colorMenu.add(custom);
	}
	
	@Override
	protected void doCustomCheck(ActionEvent e)
	{
		if(e.getActionCommand().equals(CUSTOM))
		{
			Color c = JColorChooser.showDialog(frame, "Choose a color", selectedComponent.getBackground());
			if (c != null) selectedComponent.setBackground(c);
		}
		super.doCustomCheck(e);
	}
	
}
