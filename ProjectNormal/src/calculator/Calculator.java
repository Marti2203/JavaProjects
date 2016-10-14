package calculator;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GridBagConstraints gbc = new GridBagConstraints();
	JTextField theDisplay = new JTextField();
	String operation;

	Class<?> type = BigInteger.class;

	Number result = BigInteger.ZERO;

	boolean isDefault = true;

	public Calculator()
	{
		theDisplay.setEditable(false);
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		ContainerListener listener = new ContainerAdapter()
		{
			public void componentAdded(ContainerEvent e)
			{
				Component comp = e.getChild();
				if (comp instanceof JButton) ((JButton) comp).addActionListener(Calculator.this);
			}
		};
		addContainerListener(listener);
		gbc.gridwidth = 4;
		addGB(this, theDisplay, 0, 0);
		// make the top row
		JPanel topRow = new JPanel();
		topRow.addContainerListener(listener);
		gbc.gridwidth = 1;
		gbc.weightx = 1.0;
		addGB(topRow, new JButton("C"), 0, 0);
		gbc.weightx = 0.33;
		addGB(topRow, new JButton("%"), 1, 0);
		gbc.weightx = 1.0;
		addGB(topRow, new JButton("+"), 2, 0);
		gbc.gridwidth = 4;
		addGB(this, topRow, 0, 1);
		gbc.weightx = 1.0;
		gbc.gridwidth = 1;
		// make the digits
		for (int j = 0; j < 3; j++)
			for (int i = 0; i < 3; i++)
				addGB(this, new JButton("" + ((2 - j) * 3 + i + 1)), i, j + 2);
		// -, x, and divide
		addGB(this, new JButton("-"), 3, 2);
		addGB(this, new JButton("x"), 3, 3);
		addGB(this, new JButton("\u00F7"), 3, 4);
		// make the bottom row
		JPanel bottomRow = new JPanel();
		bottomRow.addContainerListener(listener);
		gbc.weightx = 1.0;
		addGB(bottomRow, new JButton("0"), 0, 0);
		gbc.weightx = 0.33;
		addGB(bottomRow, new JButton("."), 1, 0);
		gbc.weightx = 1.0;
		addGB(bottomRow, new JButton("="), 2, 0);
		gbc.gridwidth = 4;
		addGB(this, bottomRow, 0, 5);
	}

	void addGB(Container cont, Component comp, int x, int y)
	{
		if ((cont.getLayout() instanceof GridBagLayout) == false) cont.setLayout(new GridBagLayout());
		gbc.gridx = x;
		gbc.gridy = y;
		cont.add(comp, gbc);
	}

	public void actionPerformed(ActionEvent e)
	{
	}

	private void calculateTest()
	{

		try
		{
			Constructor<?> constructor = type.getConstructor(String.class);
			if (operation == null)
			{
				result = (Number) constructor.newInstance(theDisplay.getText());
				return;
			}
			System.out.println(theDisplay.getText());
			String number = theDisplay.getText().substring(1);

			Method add = type.getMethod("add", type);
			Method subtract = type.getMethod("subtract", type);
			Method multiply = type.getMethod("multiply", type);
			Method divide = type.getMethod("divide", type);
			Method remainder = type.getMethod("remainder", type);

			switch (operation)
			{
				case "+":
					result = (Number) add.invoke(result, constructor.newInstance(number));
					break;
				case "-":
					result = (Number) subtract.invoke(result, constructor.newInstance(number));
					break;
				case "\u00F7":
					result = (Number) divide.invoke(result, constructor.newInstance(number));
					break;
				case "x":
					result = (Number) multiply.invoke(result, constructor.newInstance(number));
					break;
				case "%":
					result = (Number) remainder.invoke(result, constructor.newInstance(number));
					break;
				default:
					throw new NumberFormatException();
			}

		}
		catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e)
		{
			e.printStackTrace();
		}

	}

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 250);
		frame.setLocation(200, 200);
		frame.setContentPane(new Calculator());
		frame.setVisible(true);
	}
}