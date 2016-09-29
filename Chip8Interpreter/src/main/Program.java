package main;
import javax.swing.JFrame;

import color.ColorChooser;
import color.CombinedColorChooser;
import color.CustomColorChooser;
import color.SimpleColorChooser;
import screen.Screen;

public class Program
{
	public static void main(String[] args)
	{
		Screen screen = new Screen(10, 10);
		//JFrame frame=new  JFrame();
		//frame.setSize(200, 200);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setVisible(true);
		CombinedColorChooser chooser=new CombinedColorChooser(screen);
	}
}
