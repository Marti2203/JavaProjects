package defaultPackage;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.lang.reflect.*;

import javax.swing.JButton;
import javax.swing.JComponent;

import projects.ListExtender;

class TextBoxAndButton extends JComponent implements MouseMotionListener, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String theMessage;
	int messageX = 125, messageY = 95; // Coordinates of the message

	JButton theButton;
	Random rng = new Random();

	int colorIndex; // Current index into someColors
	static ArrayList<Field> someColors = CreateColors();

	public TextBoxAndButton(String message,String ColorChangeText) {
		theMessage = message;
		theButton = new JButton(ColorChangeText);
		setLayout(new FlowLayout());
		add(theButton);
		theButton.addActionListener(this);
		addMouseMotionListener(this);
	}
	public void paintComponent(Graphics g) {
		g.drawString(theMessage, messageX, messageY);
	}

	public void mouseDragged(MouseEvent e) {
		messageX = e.getX();
		messageY = e.getY();
		repaint();
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void actionPerformed(ActionEvent e) {
		// Did somebody push our button?
		if (e.getSource() == theButton)
			try {
				changeColor();
			} catch (IllegalArgumentException | IllegalAccessException e1) {
				System.out.println("Failed at Action Performed");
			}
	}
	
	public void changeText()
	{
		theMessage="Changed";
		repaint();
	}
	private static ArrayList<Field> CreateColors() {
		String[] nonColorFields={"FACTOR","serialVersionUID"};
		Field[] declaredFields = Color.class.getDeclaredFields();
		ArrayList<Field> staticFields = new ArrayList<Field>();
		for (Field field : declaredFields) {
			if (Modifier.isStatic(field.getModifiers()) 
					&& !ListExtender.StringSearcher
					.Contains(Arrays.asList(nonColorFields),field.getName())) {
				staticFields.add(field);
			}
		}
		return staticFields;
	}
	
	synchronized private void changeColor() throws IllegalArgumentException, IllegalAccessException {
		// Change the index to the next color, awkwardly.
		colorIndex = rng.nextInt(someColors.size());
		try {
			setForeground(currentColor());
		} catch (Exception e) {
			System.out.println("Failed at Change Color");
		}
		// Use the new color.
		repaint(); // Paint again so we can see the change.
	}

	@SuppressWarnings("finally")
	synchronized private Color currentColor() throws IllegalArgumentException, IllegalAccessException {
		Color result = null;
		try {
			result = (Color) someColors.get(colorIndex).get(null);
		} catch (Exception e) {
			System.out.println("Failed at CurrentColor");
			System.out.println(String.format("Color is %s", someColors.get(colorIndex).toString()));
			result = Color.black;
		} finally {
			return result;
		}
	}
}