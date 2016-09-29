package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Lister
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Lister v1.0");
		// create a combo box
		String[] items =
		{ "uno", "due", "tre", "quattro", "cinque", "sei", "sette", "otto", "nove", "deici", "undici", "dodici" };
		JComboBox<String> comboBox = new JComboBox<>(items);
		comboBox.setEditable(true);
		// create a list with the same data model
		final JList<String> list = new JList<String>(comboBox.getModel());
		// create a button; when it's pressed, print out
		// the selection in the list
		JButton button = new JButton("Per favore");
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				List<String> selection = list.getSelectedValuesList();
				System.out.println("-----");
				for (String o : selection)
					System.out.println(o);
			}
		});
		// put the controls the content pane
		Container c = frame.getContentPane(); // unnecessary in 5.0+
		JPanel comboPanel = new JPanel();
		comboBox.setEditable(false);
		comboPanel.add(comboBox);
		c.add(comboPanel, BorderLayout.NORTH);
		c.add(new JScrollPane(list), BorderLayout.CENTER);
		c.add(button, BorderLayout.SOUTH);
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
