package defaultPackage;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComponent;

import projects.ListExtender;

class Blinker extends JComponent implements MouseMotionListener, ActionListener, Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String theMessage;
	static Random rng = new Random();
	int messageX, messageY; // Coordinates of the message

	JButton theButton;

	int colorIndex; // Current index into someColors.
	static ArrayList<Field> someColors = CreateColors();

	boolean blinkState;

	public Blinker(String message, int width, int height) {
		theMessage = message;
		theButton = new JButton("Change Color");
		messageX = rng.nextInt(width);
		messageY = rng.nextInt(height);
		setLayout(new FlowLayout());
		add(theButton);
		theButton.addActionListener(this);
		addMouseMotionListener(this);
		Thread t = new Thread(this);
		t.start();
	}

	public void paintComponent(Graphics g) {
		g.setColor(blinkState ? getBackground() : currentColor());
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
		if (e.getSource() == theButton)
			changeColor();
	}

	private static ArrayList<Field> CreateColors() {
		String[] nonColorFields = { "FACTOR", "serialVersionUID" };
		Field[] declaredFields = Color.class.getDeclaredFields();
		ArrayList<Field> staticFields = new ArrayList<Field>();
		for (Field field : declaredFields) {System.out.println(field);
			if (Modifier.isStatic(field.getModifiers())
					&& !ListExtender.StringSearcher.Contains(Arrays.asList(nonColorFields), field.getName())) {
				staticFields.add(field);
			}
		}
		return staticFields;
	}

	synchronized private void changeColor() {
		// Change the index to the next color, awkwardly.
		colorIndex = rng.nextInt(someColors.size());
		setForeground(currentColor());
		// Use the new color.
		repaint(); // Paint again so we can see the change.
	}

	@SuppressWarnings("finally")
	synchronized private Color currentColor() {
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

	public void run() {
		try {
			while (true) {
				blinkState = !blinkState; // Toggle blinkState.
				repaint(); // Show the change.
				Thread.sleep(300);
			}
		} catch (InterruptedException ie) {
		}
	}
}