package defaultPackage;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("unused")
public class HelloFirst {
	public static void main(String[] args) throws IOException {
		String[] elements = { "world", "John Cena" };
		StartFrameCustom(elements);
	}

	public static void Write(String[] input) {
		System.out.printf("Hello %s.This is %s", input[0], input[1]);
	}

	public static void StartFrameEmpty(String[] input) {
		JFrame frame = new JFrame(String.format("Hello %s.This is %s", input[0], input[1]));
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	public static void StartFrameSmarter(String[] input) {
		JFrame frame = new JFrame(String.format("Hello %s.", input[0]));
		JLabel label = new JLabel(String.format("This is %s !", input[1]), JLabel.CENTER);
		frame.getContentPane().add(label);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	public static void StartFrameCustom(String[] input) {
		JFrame frame = new JFrame(String.format("Hello %s.", input[0]));
		frame.add(new TextBoxFirst(String.format("This is %s",input[1])));
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
