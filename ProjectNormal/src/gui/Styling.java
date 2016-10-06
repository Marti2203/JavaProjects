package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class Styling extends JFrame
{
	private JTextPane textPane;

	public Styling()
	{
		super("Stylin' v1.0");
		setSize(300, 200);
		textPane = new JTextPane();
		textPane.setFont(new Font("Serif", Font.PLAIN, 24));
		// create some handy attribute sets
		SimpleAttributeSet red = new SimpleAttributeSet();
		StyleConstants.setForeground(red, Color.red);
		StyleConstants.setBold(red, true);
		SimpleAttributeSet blue = new SimpleAttributeSet();
		StyleConstants.setForeground(blue, Color.blue);
		SimpleAttributeSet italic = new SimpleAttributeSet();
		StyleConstants.setItalic(italic, true);
		StyleConstants.setForeground(italic, Color.orange);
		// add the text
		append("In a ", null);
		append("sky", blue);
		append(" full of people\nOnly some want to ", null);
		append("fly", italic);
		append("\nIsn't that ", null);
		append("crazy", red);
		append("?", null);
		add(new JScrollPane(textPane), BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	protected void append(String s, AttributeSet attributes)
	{
		Document d = textPane.getDocument();
		try
		{
			d.insertString(d.getLength(), s, attributes);
		}
		catch (BadLocationException ble)
		{
		}
	}

	public static void main(String[] args)
	{
		new Styling().setVisible(true);
	}
}
