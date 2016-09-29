package color;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import screen.Pixel;
import screen.Screen;
import utils.CharExtender;
import utils.ListExtender;

public class ColorPalette extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static ArrayList<Field> colors = CreateColors();

	@SuppressWarnings("unused")
	private Screen screen;
	private Pixel[][] pixels;

	private JButton setColorButton = new JButton("Set Color");

	private ParameterUnit xUnit = new ParameterUnit("X coordinate");
	private ParameterUnit yUnit = new ParameterUnit("Y coordinate");
	private JLabel errorLabel = new JLabel();

	private static ArrayList<Field> CreateColors()
	{
		String[] nonColorFields =
		{ "FACTOR", "serialVersionUID" };
		Field[] declaredFields = Color.class.getDeclaredFields();
		ArrayList<Field> staticFields = new ArrayList<Field>();
		for (Field field : declaredFields)
		{
			if (Modifier.isStatic(field.getModifiers())
					&& !ListExtender.Contains(Arrays.asList(nonColorFields), field.getName())
					&& CharExtender.isLowerCase(field.getName()))
			{
				staticFields.add(field);
			}
		}
		return staticFields;
	}

	public ColorPalette(Screen screen)
	{
		super();
		this.screen = screen;
		this.pixels = screen.getPixels();
		setLayout(new GridLayout(5, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setColorButton.setActionCommand("setColor");
		JPanel panel = new JPanel();
		ButtonGroup colorGroup = new ButtonGroup();
		int i = 0;
		for (Field color : colors)
		{
			JRadioButton button = new JRadioButton(color.getName());
			button.setActionCommand(Integer.toString(i++));
			try
			{
				button.setBackground((Color) color.get(null));
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			colorGroup.add(button);
			panel.add(button);
		}

		setColorButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				StringBuffer error = new StringBuffer();
				boolean errorFlag = false;
				int xCoord = -1;
				int yCoord = -1;
				if ((xCoord = tryParse(xUnit.input.getText(), 16)) < 0 || xCoord >= screen.getCols())
				{
					error.append("X must be positive and below ");
					error.append(screen.getCols());
					error.append(" ");
					errorFlag = true;
				}
				if ((yCoord = tryParse(yUnit.input.getText(), 16)) < 0 || yCoord >= screen.getRows())
				{
					error.append("Y must be positive and below ");
					error.append(screen.getRows());
					error.append(" ");
					errorFlag = true;
				}
				try
				{
					if (colorGroup.getSelection() == null || errorFlag)
					{
						if (colorGroup.getSelection() == null) error.append("No Color Choice\n");
						return;
					}

					pixels[yCoord][xCoord].setBackground((Color) colors
							.get(Integer.parseInt(colorGroup.getSelection().getActionCommand())).get(null));

				}
				catch (IllegalArgumentException | IllegalAccessException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				finally
				{
					errorLabel.setText(error.toString());
				}
			}
		});

		add(panel);
		add(xUnit);
		add(yUnit);
		add(setColorButton);
		add(errorLabel);

		pack();
		setVisible(true);
	}

	private static int tryParse(String input, int radix)
	{
		int result = -1;
		try
		{
			result = Integer.parseInt(input, radix);
		}
		catch (NumberFormatException e)
		{
			result = -1;
		}
		return result;
	}

	private class ParameterUnit extends JPanel
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@SuppressWarnings("unused")
		public JLabel description;
		public JTextField input;
		@SuppressWarnings("unused")
		public String name;

		public ParameterUnit(String name)
		{
			super();
			setLayout(new GridLayout(1, 2));
			add(description = new JLabel(MessageFormat.format("Input {0}", name)));
			add(input = new JTextField());
		}

	}
}
