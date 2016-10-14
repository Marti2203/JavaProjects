package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoveButton extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton button = new JButton("I Move");

	public MoveButton()
	{
		setLayout(null);
		add(button);
		button.setSize(button.getPreferredSize());
		button.setLocation(20, 20);
		button.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				System.out.print(button.getX());
				System.out.println(" ");
				System.out.println(button.getY());
			}
		});
		addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				button.setLocation(e.getX(), e.getY());
			}
		});
	}

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("MoveButton");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(250, 200);
		frame.setLocation(200, 200);
		frame.setContentPane(new MoveButton());
		frame.setVisible(true);
	}
}