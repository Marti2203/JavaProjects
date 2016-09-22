package gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class RedirectButton extends JFrame
{
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	JButton button;
	JTextField linkField;

	public RedirectButton( )
	{
		super();
		button = new JButton("Open link");
		linkField = new JTextField(40);
		setLayout(new FlowLayout());
		add(button);
		add(linkField);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}

}