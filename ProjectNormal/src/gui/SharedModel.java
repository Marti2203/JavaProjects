package gui;

import java.awt.GridLayout;
import java.io.File;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class SharedModel
{

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("User Information");
		// TODO Auto-generated method stub
		JEditorPane areaFiftyOne = new JEditorPane();
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(frame);
		if (result == JFileChooser.CANCEL_OPTION) return;
		try
		{
			File file = chooser.getSelectedFile();
			@SuppressWarnings("deprecation")
			java.net.URL url = file.toURL();
			areaFiftyOne.setPage(url);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		JEditorPane areaFiftyTwo = new JEditorPane();
		areaFiftyTwo.setDocument(areaFiftyOne.getDocument());
		JEditorPane areaFiftyThree = new JEditorPane();
		areaFiftyThree.setDocument(areaFiftyOne.getDocument());

		frame.setLayout(new GridLayout(3, 1));
		frame.add(new JScrollPane(areaFiftyOne));
		frame.add(new JScrollPane(areaFiftyTwo));
		frame.add(new JScrollPane(areaFiftyThree));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setVisible(true);

	}

}
