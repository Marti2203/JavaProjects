package defaultPackage;

import javax.swing.*;

public class HelloThird {
	public static void main(String[] args) {
			StartFrameAndComponents(new String[] { "Test", "JOHN Snow","Change Color" });
	}

	public static void StartFrameAndComponents(String[] input) {
		JFrame frame = new JFrame(input[0]);
		frame.add(new TextBoxAndButton(String.format("Hello %s!", input[1]),input[2]));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}