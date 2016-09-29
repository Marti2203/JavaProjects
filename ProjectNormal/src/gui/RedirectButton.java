package gui;

import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class RedirectButton extends JFrame implements ActionListener
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
		button.addActionListener(this);
		linkField = new JTextField(40);
		setLayout(new FlowLayout());
		add(button);
		add(linkField);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			Desktop.getDesktop().browse(new URI(MessageFormat.format("https://{0}.com", linkField.getText())));
		} catch (IOException | URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}