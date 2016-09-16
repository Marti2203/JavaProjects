package defaultPackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

class JCell extends Component {
	
	private Cell cell;
	private static final long serialVersionUID = 1L;

	public JCell(int x, int y) {
		cell = new Cell(x, y);
	}

	public void paintComponent(Graphics g) {
		Color current = g.getColor();
		g.setColor(getIsAlive() ? Color.black : Color.white);
		g.drawLine(this.getX(), this.getY(), this.getX(), this.getY());
		g.setColor(current);
	}

	public int getX() {
		return cell.getX();
	}

	public int getY() {
		return cell.getY();
	}

	public boolean getIsAlive() {
		return cell.getIsAlive();
	}

	public boolean setIsAlive(boolean value) {
		cell.setIsAlive(value);
		repaint();
		return value;
	}

	public int setX(int value) {
		cell.setX(value);
		return value;
	}

	public int setY(int value) {
		cell.setY(value);
		return value;
	}

}

class Cell {
	
	private int x;
	private int y;
	private boolean isAlive;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		this.isAlive = false;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean getIsAlive() {
		return isAlive;
	}

	public boolean setIsAlive(boolean value) {
		isAlive = value;
		return value;
	}

	public int setX(int value) {
		x = value;
		return value;
	}

	public int setY(int value) {
		y = value;
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		return ((Cell) obj).getX() == x && ((Cell) obj).getY() == y && ((Cell) obj).getIsAlive() == isAlive;
	}

	@Override
	public String toString() {
		return String.format("%s, %s : %b", x, y, isAlive);
	}
}