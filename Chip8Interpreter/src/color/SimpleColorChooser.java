package color;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import screen.Screen;
import utils.CharExtender;
import utils.ListExtender;

public class SimpleColorChooser extends ColorChooser implements ActionListener
{
	JPopupMenu colorMenu = new JPopupMenu("Color");
	static ArrayList<String> ColorNames = new ArrayList<>();
	static ArrayList<Color> Colors = new ArrayList<>();
	int counter = 0;

	static
	{
		String[] nonColorFields =
		{ "FACTOR", "serialVersionUID" };
		Field[] declaredFields = Color.class.getDeclaredFields();
		for (Field field : declaredFields)
		{
			if (Modifier.isStatic(field.getModifiers())
					&& !ListExtender.Contains(Arrays.asList(nonColorFields), field.getName())
					&& CharExtender.isLowerCase(field.getName()))
			{
				ColorNames.add(field.getName());
				try
				{
					Colors.add((Color) field.get(null));
				}
				catch (IllegalArgumentException | IllegalAccessException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public SimpleColorChooser(JFrame frame)
	{
		super(frame);
		PutColors();
	}

	public SimpleColorChooser(Screen screen)
	{
		super(screen);
		PutColors();
	}

	private void PutColors()
	{
		ColorNames.forEach(color -> colorMenu.add(makeMenuItem(color)));
	}

	public void actionPerformed(ActionEvent e)
	{
		try
		{
			selectedComponent.setBackground(Colors.get(Integer.parseInt(e.getActionCommand())));
		}
		catch (NumberFormatException exception)
		{
			doCustomCheck(e);
		}
	}

	protected void doCustomCheck(ActionEvent e)
	{
		
	}

	protected JMenuItem makeMenuItem(String label)
	{
		JMenuItem item = new JMenuItem(label);
		item.setActionCommand(Integer.toString(counter++));
		item.addActionListener(this);
		return item;
	}

	@Override
	protected void treatPopupTrigger(MouseEvent e)
	{
		selectedComponent = e.getComponent();
		colorMenu.show(e.getComponent(), e.getX(), e.getY());

	}
}
