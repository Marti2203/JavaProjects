package gui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Card extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CardLayout cards = new CardLayout();

	public Card()
	{
		setLayout(cards);
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				cards.next(Card.this);
			}
		};
		JButton button;
		button = new JButton("one");
		button.addActionListener(listener);
		add(button, "one");
		button = new JButton("two");
		button.addActionListener(listener);
		add(button, "two");
		button = new JButton("three");
		button.addActionListener(listener);
		add(button, "three");
	}

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Card");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setLocation(200, 200);
		frame.setContentPane(new Card());
		frame.setVisible(true);
	}
}