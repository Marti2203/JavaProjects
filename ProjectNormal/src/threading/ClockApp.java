package threading;

import javax.swing.JFrame;

public class ClockApp
	{
		public static void main(String[] args)
			{
				JFrame frame = new JFrame("Clock Application");
				frame.setSize(400, 400);
				Clock clock = new Clock();
				frame.add(clock);
				clock.start();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
	}
