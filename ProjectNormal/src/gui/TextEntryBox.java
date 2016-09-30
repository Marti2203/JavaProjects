package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextEntryBox
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Text Entry Box");
		final JTextArea area = new JTextArea();
		area.setFont(new Font("Serif", Font.BOLD, 18));
		area.setText("Howdy!\n");
		area.setEditable(false);
		final JTextField field = new JTextField();
		frame.add(new JScrollPane(area), BorderLayout.CENTER);
		frame.add(field, BorderLayout.SOUTH);
		field.requestFocus();
		field.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if (field.getText().startsWith("/"))
					runCommand(field.getText().toLowerCase());
				else area.append(field.getText() + '\n');
				field.setText("");
			}

			private void runCommand(String text)
			{
				switch (text)
				{
					case "/clear":
						area.setText("");
						break;
					default:
						System.out.print("Unknown command");
						System.out.println(text);
						break;
				}

			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 300);
		frame.setVisible(true);
	}
}