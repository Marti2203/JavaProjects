package defaultPackage;

import javax.swing.*;

public class HelloFourth {
	public static void main(String[] args) {
		int width = 300;
		int height = 300;
		JFrame frame = new JFrame("Hello Fourth Frame");
		frame.add(new Blinker("Hallo Java!", width, height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
}