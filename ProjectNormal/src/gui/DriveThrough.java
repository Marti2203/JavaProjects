package gui;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class DriveThrough
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Lister v1.0");
		JPanel entreePanel = new JPanel();
		final ButtonGroup entreeGroup = new ButtonGroup();
		JRadioButton radioButton;
		entreePanel.add(radioButton = new JRadioButton("Beef"));
		radioButton.setActionCommand("Beef");
		entreeGroup.add(radioButton);
		entreePanel.add(radioButton = new JRadioButton("Chicken"));
		radioButton.setActionCommand("Chicken");
		entreeGroup.add(radioButton);
		entreePanel.add(radioButton = new JRadioButton("Veggie", true));
		radioButton.setActionCommand("Veggie");
		entreeGroup.add(radioButton);
		final JPanel condimentsPanel = new JPanel();
		condimentsPanel.add(new JCheckBox("Ketchup"));
		condimentsPanel.add(new JCheckBox("Mustard"));
		condimentsPanel.add(new JCheckBox("Pickles"));
		JPanel orderPanel = new JPanel();
		JButton orderButton = new JButton("Place Order");
		orderPanel.add(orderButton); // unnecessary in 5.0+
		frame.setLayout(new GridLayout(3, 1));
		frame.add(entreePanel);
		frame.add(condimentsPanel);
		frame.add(orderPanel);
		orderButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				String entree = entreeGroup.getSelection().getActionCommand();
				System.out.print(entree + " sandwich");
				Component[] components = condimentsPanel.getComponents();
				for (Component c : components)
				{
					JCheckBox cb = (JCheckBox) c;
					if (cb.isSelected()) System.out.print(" with " + cb.getText());
				}
				System.out.print("\n");
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 150);
		frame.setVisible(true);
	}
}
