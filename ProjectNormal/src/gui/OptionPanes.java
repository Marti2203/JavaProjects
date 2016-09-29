package gui;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class OptionPanes
{

	public static void main(String[] args)
	{
		JOptionPane.showMessageDialog(null, "You have mail.");
		JOptionPane.showMessageDialog(null, "You are low on memory.", "Apocalyptic message",
				JOptionPane.WARNING_MESSAGE);
		int result = JOptionPane.showConfirmDialog(null, "Do you want to remove Windows now?");
		System.out.println(result);
		String name = JOptionPane.showInputDialog(null, "Please enter your name.");
		System.out.println(name);
		JTextField userField = new JTextField();
		JPasswordField passField = new JPasswordField();
		String message = "Please enter your user name and password.";
		result = JOptionPane.showOptionDialog(null, new Object[]
		{ message, userField, passField }, "Login", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null,
				null);
		System.out.println(result);
		if (result == JOptionPane.OK_OPTION)
			System.out.println(userField.getText() + " " + new String(passField.getPassword()));
		System.exit(0);
	}

}
