package defaultPackage;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

class JTextBox extends JComponent implements MouseMotionListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String theMessage, firstMessage, secondMessage;
	int messageX = 125, messageY = 95; // Coordinates of the message

	public JTextBox(String messageFirst, String messageSecond) {
		theMessage = messageFirst;
		firstMessage = messageFirst;
		secondMessage = messageSecond;
		addMouseMotionListener(this);
		addKeyListener(this);
	}

	public JTextBox(String messageFirst, String messageSecond, int coordinateX, int coordinateY) {
		this(messageFirst, messageSecond);
		this.messageX = coordinateX;
		this.messageY = coordinateY;
	}

	public void paintComponent(Graphics g) {
		if (messageX == 200) {
			this.theMessage = this.secondMessage;
		}
		if (messageY == 100) {
			this.theMessage = this.firstMessage;
		}
		g.drawString(String.format("%s=>\t %s %s", theMessage, messageX, messageY), messageX, messageY);
	}

	private void doMovement(MouseEvent e){
		messageX = e.getX();
		messageY = e.getY();
		repaint();
	}
	public void mouseDragged(MouseEvent e) {
		// Save the mouse coordinates and paint the message.
		doMovement(e);
	}

	public void mouseMoved(MouseEvent e) {
		doMovement(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		this.theMessage = "Key Pressed";
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		this.theMessage = "Key Released";
		this.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		this.theMessage = "Key Typed";
		this.repaint();
	}
}