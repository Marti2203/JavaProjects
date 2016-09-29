package gui;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class DinnerMenu
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Dinner Menu");
		// create the Utensils menu
		JMenu utensils = new JMenu("Utensils");
		utensils.setMnemonic(KeyEvent.VK_U);
		utensils.add(new JMenuItem("Fork"));
		utensils.add(new JMenuItem("Knife"));
		utensils.add(new JMenuItem("Spoon"));
		JMenu hybrid = new JMenu("Hybrid");
		hybrid.add(new JMenuItem("Spork"));
		hybrid.add(new JMenuItem("Spife"));
		JMenuItem knork = new JMenuItem("Knork");
		knork.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("KNORK!");

			}
		});
		hybrid.add(knork);
		utensils.addSeparator();
		utensils.add(hybrid);
		utensils.addSeparator();
		// do some fancy stuff with the Quit item
		JMenu quitMenu = new JMenu("File");
		quitMenu.setMnemonic(KeyEvent.VK_F);
		JMenuItem quitItem = new JMenuItem("Quit");
		quitItem.setMnemonic(KeyEvent.VK_Q);
		quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK));
		quitItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		quitMenu.add(quitItem);
		// create the Spices menu
		JMenu spices = new JMenu("Spices");
		spices.setMnemonic(KeyEvent.VK_S);
		spices.add(new JCheckBoxMenuItem("Thyme"));
		spices.add(new JCheckBoxMenuItem("Rosemary"));
		spices.add(new JCheckBoxMenuItem("Oregano", true));
		spices.add(new JCheckBoxMenuItem("Fennel"));
		// create the Cheese menu
		JMenu cheese = new JMenu("Cheese");
		cheese.setMnemonic(KeyEvent.VK_C);
		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem rbmi;
		rbmi = new JRadioButtonMenuItem("Regular", true);
		group.add(rbmi);
		cheese.add(rbmi);
		rbmi = new JRadioButtonMenuItem("Extra");
		group.add(rbmi);
		cheese.add(rbmi);
		rbmi = new JRadioButtonMenuItem("Blue");
		group.add(rbmi);
		cheese.add(rbmi);
		// create a menu bar and use it in this JFrame
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(quitMenu);
		menuBar.add(utensils);
		menuBar.add(spices);
		menuBar.add(cheese);

		frame.setJMenuBar(menuBar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}
}